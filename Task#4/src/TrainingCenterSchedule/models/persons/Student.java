package TrainingCenterSchedule.models.persons;

import TrainingCenterSchedule.exceptions.IllegalDateException;
import TrainingCenterSchedule.models.cources.Curriculum;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Student {

    static final int HOURS_IN_TRAININGDAY = 8;
    static final int HOURS_START_TRAININGDAY = 10;
    static final int HOURS_END_TRAININGDAY = 18;
    static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";

    private String firstName;
    private String lastName;
    private LocalDateTime startDate;
    private Curriculum curriculum;

    public Student(String firstName, String lastName, Curriculum curriculum, String dateTime) throws IllegalDateException{
        this.firstName=firstName;
        this.lastName=lastName;
        this.curriculum=curriculum;
        setStartDate(dateTime);
    }

    private void setStartDate(String stringDate) throws IllegalDateException {
        this.startDate = LocalDateTime.parse(stringDate,DateTimeFormatter.ofPattern(DATETIME_FORMAT));
        if (this.startDate.isAfter(LocalDateTime.now())) {
            throw new IllegalDateException("Date and time of the beginning of courses cannot be more than the current date!");
        }
    }

    public void printTimeLeft(){
        printTimeStatus(getDuration());
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }

    private LocalDateTime getEndDate(){
        /*
         * The code will calculate the study time from now until the end of the curriculum
         */
        int curriculumDuration = curriculum.getDuration();
        /*
         * If time is included in the interval of working time, then this time needs to be adjusted.
         */
        if (startDate.getHour()<HOURS_END_TRAININGDAY){
            int difference = 0;
            if (startDate.getHour()<HOURS_START_TRAININGDAY){
                difference=HOURS_IN_TRAININGDAY;
            } else {
                difference=HOURS_END_TRAININGDAY-startDate.getHour();
            }
            curriculumDuration-=difference;
        }

        /*
         * We calculate the end time of the courses, adding days and hours
         */
        LocalDateTime endDate = startDate.withHour(HOURS_END_TRAININGDAY).plusDays(hoursToTrainingDay(curriculumDuration));
        if (hoursLeft(curriculumDuration)==0){
            endDate=endDate.minusDays(1).withHour(HOURS_END_TRAININGDAY);
        } else {
            endDate=endDate.withHour(HOURS_START_TRAININGDAY+hoursLeft(curriculumDuration));
        }
        return endDate;
    }

    private int getDuration(){
        int duration = 0;
        LocalDateTime endDate = getEndDate();

        /*
         * Check if the training is completed. If not, consider how much time is left.
         * If the training is over, consider how much time has passed
         */
        if (LocalDateTime.now().isBefore(endDate)){

            /*
             * Count the number of full days
             */
            int durationBetweenEndAndNow = ((int)Duration.between(LocalDateTime.now().withHour(0).withMinute(0),endDate.withHour(0).withMinute(0)).toDays())-1;
            if (durationBetweenEndAndNow>0){
                duration+=HOURS_IN_TRAININGDAY*durationBetweenEndAndNow;
            }

            /*
             * If the time difference is more than a day. Then we calculate the time difference,
             * taking into account the days between the first and last day
             */
            if (durationBetweenEndAndNow>0) {
                if (endDate.getHour() <= HOURS_END_TRAININGDAY) {
                    duration += endDate.getHour() - HOURS_START_TRAININGDAY;
                }
                if (LocalDateTime.now().getHour() <= HOURS_END_TRAININGDAY) {
                    if (LocalDateTime.now().getHour() <= HOURS_START_TRAININGDAY) {
                        duration += HOURS_IN_TRAININGDAY;
                    } else {
                        duration += HOURS_END_TRAININGDAY - LocalDateTime.now().getHour();
                    }
                }
            } else {
                if (LocalDateTime.now().getHour()<=HOURS_END_TRAININGDAY && LocalDateTime.now().getHour()>=HOURS_START_TRAININGDAY){
                    if (endDate.getDayOfMonth()==LocalDateTime.now().getDayOfMonth()){
                        duration+=endDate.getHour()-LocalDateTime.now().getHour();
                    } else {
                        duration+=(HOURS_END_TRAININGDAY-LocalDateTime.now().getHour())+(endDate.getHour()-HOURS_START_TRAININGDAY);
                    }
                } else {
                    duration+=endDate.getHour()-HOURS_START_TRAININGDAY;
                }
            }
            return duration;
        } else {
            int durationBetweenEndAndNow = ((int)Duration.between(endDate.withHour(0).withMinute(0),LocalDateTime.now().withHour(0).withMinute(0)).toDays())-1;
            if (durationBetweenEndAndNow>0){
                duration+=HOURS_IN_TRAININGDAY*durationBetweenEndAndNow;
            }
            if (durationBetweenEndAndNow>0){
                if (endDate.getHour()<=HOURS_END_TRAININGDAY){
                    if (endDate.getHour()<HOURS_START_TRAININGDAY){
                        duration+=HOURS_IN_TRAININGDAY;
                    } else {
                        duration+= HOURS_END_TRAININGDAY-endDate.getHour();
                    }
                }
                if (LocalDateTime.now().getHour()>=HOURS_START_TRAININGDAY){
                    if (LocalDateTime.now().getHour()>=HOURS_END_TRAININGDAY){
                        duration+=HOURS_IN_TRAININGDAY;
                    } else {
                        duration+=LocalDateTime.now().getHour()-HOURS_START_TRAININGDAY;
                    }
                }
            } else {
                if (LocalDateTime.now().getHour()>=HOURS_END_TRAININGDAY || LocalDateTime.now().getHour()<=HOURS_START_TRAININGDAY){
                    duration+=HOURS_END_TRAININGDAY-endDate.getHour();
                } else {
                    if (endDate.getDayOfMonth()==LocalDateTime.now().getDayOfMonth()){
                        duration+=LocalDateTime.now().getHour()-endDate.getHour();
                    } else {
                        duration+=(LocalDateTime.now().getHour()-HOURS_START_TRAININGDAY)+(HOURS_END_TRAININGDAY-endDate.getHour());
                    }

                }
            }
            return(duration*-1);
        }
    }

    private int hoursToTrainingDay(int hours){
        return hours/HOURS_IN_TRAININGDAY+1;
    }

    private int hoursLeft(int hours){
        return hours%=HOURS_IN_TRAININGDAY;
    }

    private void printTimeStatus(int hours){

        /*
         * If the training is not finished yet, then a positive number is passed to the method, otherwise a negative
         */
        if (hours>0){
            System.out.format("%s (%s) Remaining time: %d days, %d hours\n",getFullName(),curriculum.getName(),hours/HOURS_IN_TRAININGDAY,hours%HOURS_IN_TRAININGDAY);
        } else {
            System.out.format("%s (%s) Left time after ending training: %d days, %d hours\n",getFullName(),curriculum.getName(),(hours*-1)/HOURS_IN_TRAININGDAY,(hours*-1)%HOURS_IN_TRAININGDAY);
        }

    }

}

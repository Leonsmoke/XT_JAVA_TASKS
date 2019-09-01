package TrainingCenterSchedule.models.cources;

public class Course {
    private String name;
    private int duration;

    public Course(String name, int duration) {
        this.name = name;
        this.setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration){
        if (duration>0){
            this.duration=duration;
        }
    }
}

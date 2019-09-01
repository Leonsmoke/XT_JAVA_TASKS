package TrainingCenterSchedule;

import TrainingCenterSchedule.models.persons.Student;
import TrainingCenterSchedule.services.CurriculumFactory;
import TrainingCenterSchedule.services.StudentStorageService;

public class TrainingCenterScheduleApplication {
    private static String IVANOV_START_DATE = "27/08/2019 20:00";
    private static String PETROV_START_DATE = "31/08/2019 12:00";

    private StudentStorageService studentStorage = new StudentStorageService();

    public static void main(String[] args) {
        TrainingCenterScheduleApplication app = new TrainingCenterScheduleApplication();

        app.generateData();
        app.printInfoAboutStudents();
    }

    private void generateData(){

        /*
         * Create student objects and generate data for them.
         */
        studentStorage.add(new Student("Ivan", "Ivanov", CurriculumFactory.create(CurriculumFactory.J2EE_CURRICULUM),IVANOV_START_DATE));
        studentStorage.add(new Student("Petr", "Petrov", CurriculumFactory.create(CurriculumFactory.JAVA_DEVELOPER),PETROV_START_DATE));
    }

    private void printInfoAboutStudents(){
        for (int index=0; ;index++){
            Student student = studentStorage.get(index);
            if (student==null){
                break;
            }
            student.printTimeLeft();
        }
    }
}

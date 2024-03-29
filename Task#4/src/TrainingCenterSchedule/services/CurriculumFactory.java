package TrainingCenterSchedule.services;

import TrainingCenterSchedule.models.cources.Course;
import TrainingCenterSchedule.models.cources.Curriculum;

public class CurriculumFactory {
    public static final String J2EE_CURRICULUM = "J2EE Developer";
    public static final String JAVA_DEVELOPER = "Java Developer";

    public static Curriculum create(String name){
        Curriculum curriculum;
        switch (name){
            case J2EE_CURRICULUM:
                curriculum = new Curriculum(J2EE_CURRICULUM);
                curriculum.addCourse(new Course("Java Servlet Technology",16));
                curriculum.addCourse(new Course("Struts Framework",24));
                return curriculum;
            case JAVA_DEVELOPER:
                curriculum = new Curriculum(JAVA_DEVELOPER);
                curriculum.addCourse(new Course("Java 8 Technology",8));
                curriculum.addCourse(new Course("JFC/Swing Libraries",16));
                curriculum.addCourse(new Course("JDBC Technology",16));
                return curriculum;
        }
        return null;
    }

}

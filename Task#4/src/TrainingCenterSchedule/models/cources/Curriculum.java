package TrainingCenterSchedule.models.cources;

public class Curriculum {
    private String name;
    private Course[] syllabus;

    public Curriculum(String name) {
        this.name = name;
    }

    public void addCourse(Course course){
        if (syllabus==null){
            syllabus=new Course[1];
            syllabus[0]= course;
            return;
        }
        Course[] tempSyllabus = new Course[syllabus.length+1];
        System.arraycopy(syllabus,0,tempSyllabus,0,syllabus.length);
        tempSyllabus[syllabus.length]= course;
        syllabus=tempSyllabus;
    }

    public String getName() {
        return name;
    }

    public int getDuration(){
        int duration=0;
        if (syllabus!=null){
            for (Course course: syllabus
                 ) {
                duration+=course.getDuration();
            }
        }
        return duration;
    }
}

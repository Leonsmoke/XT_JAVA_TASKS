package TrainingCenterSchedule.services;

import TrainingCenterSchedule.models.persons.Student;

public class StudentStorageService {
    Student[] students;

    public void add(Student student){
        if (students==null){
            students=new Student[1];
            students[0]= student;
            return;
        }
        Student[] tempStudents = new Student[students.length+1];
        System.arraycopy(students,0,tempStudents,0,students.length);
        tempStudents[students.length]= student;
        students=tempStudents;
    }

    public Student get(int index){
        if (students==null || students.length<=index){
            return null;
        }
        return students[index];
    }
}

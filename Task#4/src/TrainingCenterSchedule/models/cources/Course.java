package TrainingCenterSchedule.models.cources;

import TrainingCenterSchedule.exceptions.IllegalDuration;
import TrainingCenterSchedule.exceptions.IllegalName;

public class Course {
    private String name;
    private int duration;

    public Course(String name, int duration) throws IllegalDuration, IllegalName {
        this.setName(name);
        this.setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) throws IllegalName{
        if (name==null || name.length()<2){
            throw new IllegalName("Name is too short.",name);
        }
        this.name = name;
    }

    public void setDuration(int duration) throws IllegalDuration{
        if (duration<=0){
            throw new IllegalDuration("Duration can't be less than 1 hour");
        }
        this.duration=duration;
    }
}

package TrainingCenterSchedule.exceptions;

public class IllegalName extends Exception {
    private String name;

    public IllegalName(String message, String name) {
        super(message);
        this.name=name;
    }

    public String getName() {
        return name;
    }
}

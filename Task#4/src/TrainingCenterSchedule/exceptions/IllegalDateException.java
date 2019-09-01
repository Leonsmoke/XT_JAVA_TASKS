package TrainingCenterSchedule.exceptions;

import java.time.DateTimeException;

/**
 * Exception class that does not allow you to set the start date of courses is greater than the current date
 */
public class IllegalDateException extends Exception {

    public IllegalDateException(String message) {
        super(message);
    }
}

package RetryableFrameWork;

public class TaskFailedException extends Exception {
    TaskFailedException(String s) {
        super(s);
    }
}

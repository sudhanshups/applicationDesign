package RetryableFrameWork;

public class TaskFailedException extends RuntimeException {
    TaskFailedException(String s) {
        super(s);
    }
}

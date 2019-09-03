package RetryableFrameWork;

public class Driver {
    public static void main(String[] args) {
        System.out.println("start=======");
        //RetryStrategy incStrategy = new IncrementalRetry(2);

        RetryStrategy exponentialRetry = new ExponentialBackOffRetry();

        Task a = new ComputePie("ComputePie Task", 3, exponentialRetry,
                System.currentTimeMillis() + 3 * 1000);
        TaskExecutor taskExecutor = new TaskExecutor();
        taskExecutor.add(a);

        taskExecutor.start();

        System.out.println("end=======");
    }
}

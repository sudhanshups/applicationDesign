package RetryableFrameWork;

public class Driver {
    public static void main(String[] args) {
        System.out.println("start=======");
        //RetryStrategy incStrategy = new IncrementalRetry(2);

        RetryStrategy exponentialRetry = new ExponentialBackOffRetry();

        Task a = new ComputePie("ComputePie Task", 3, exponentialRetry,
                System.currentTimeMillis() + 3 * 1000);
        TaskScheduler taskScheduler = TaskScheduler.getInstance();
        taskScheduler.schedule(a);
        taskScheduler.run();

        System.out.println("end=======");
    }
}

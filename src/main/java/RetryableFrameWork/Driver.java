package RetryableFrameWork;

public class Driver {
    public static void main(String[] args) {
        System.out.println("start=======");

        RetryStrategy exponentialRetry = new ExponentialBackOffRetry();
        Task a = new ComputePie("ComputePie Task", 5, exponentialRetry,
                System.currentTimeMillis() + 3 * 1000);

        TaskScheduler taskScheduler = TaskScheduler.getInstance();
        taskScheduler.schedule(a);


        RetryStrategy incStrategy = new IncrementalRetry(2);
        Task b = new ComputePie("Multiply 3*3 Task", 3, incStrategy,
                System.currentTimeMillis() + 1 * 1000);
        taskScheduler.schedule(b);

        taskScheduler.run();
        System.out.println("end=======");
    }
}

package RetryableFrameWork;

public class Driver {
    public static void main(String[] args) {
        System.out.println("start=======");
        RetryStrategy incStrategy = new IncrementalRetry(3, 5);
        RetryStrategy exponentialRetry = new ExponentialRetry(5);

        Task a = new ComputePie("ComputePie Task", incStrategy, System.currentTimeMillis() + 5 * 1000);
        TaskExecutor taskExecutor = new TaskExecutor();
        taskExecutor.add(a);

        taskExecutor.start();

        System.out.println("end=======");
    }
}

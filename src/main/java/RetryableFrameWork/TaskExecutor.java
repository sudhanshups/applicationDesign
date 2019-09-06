package RetryableFrameWork;

import java.util.Date;

public class TaskExecutor {
    TaskScheduler taskScheduler;

    TaskExecutor(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public void execute(Task task) {
        try {
            System.out.println();
            System.out.println(new Date() + " Executing " + task.taskName);
            task.start();
        } catch (RuntimeException e) {
            taskScheduler.schedule(task);
        }
    }
}

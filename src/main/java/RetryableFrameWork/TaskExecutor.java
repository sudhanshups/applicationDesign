package RetryableFrameWork;

import java.util.Date;
import java.util.PriorityQueue;

public class TaskExecutor extends Thread {
    PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> (int) (a.nextRunMilli - b.nextRunMilli));

    void add(Task a) {
        tasks.add(a);
    }

    public void run() {
        while (true) {
            if (tasks.isEmpty()) {
                System.out.println(" === nothing to run == ");
                return;
            }

            Task currentTask = tasks.poll();
            try {
                System.out.println();
                System.out.println(new Date() + " Executing " + currentTask.taskName);
                currentTask.start();
            } catch (RuntimeException e) {
                System.out.println(currentTask.taskName + " Exception is caught. " + e.getMessage());
            }
            if (!TASK_STATUS.FINISHED.equals(currentTask.status)) {
                tasks.add(currentTask);
            }
        }
    }
}

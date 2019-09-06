package RetryableFrameWork;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {
    private volatile static PriorityQueue<Task> tasks;
    private volatile static TaskScheduler taskScheduler;

    public static TaskScheduler getInstance() {
        if (taskScheduler == null) {
            synchronized (TaskScheduler.class) {
                if (taskScheduler == null) {
                    taskScheduler = new TaskScheduler(new PriorityQueue<>((a, b) -> (int) (a.nextRunMilli - b.nextRunMilli)));
                }
            }
        }
        return taskScheduler;
    }

    private TaskScheduler(PriorityQueue<Task> tasks) {
        this.tasks = tasks;
    }

    synchronized void schedule(Task a) {
        tasks.add(a);
    }

    synchronized Task getScheduledTask() {
        return tasks.poll();
    }


    public void run() {
        int i=0;
        while (i<20) {
            if (tasks.isEmpty()) {
                System.out.println(" === nothing to run ("+i+"/20) ==");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                i++;
                continue;
            }

            try {
                System.out.println();
                Task task = getScheduledTask();
                TaskExecutor taskExecutor = new TaskExecutor(getInstance());

                new Thread(() -> {
                    taskExecutor.execute(task);
                }).start();
                System.out.println("started");
            } catch (RuntimeException e) {
                System.out.println(" Exception is caught. " + e.getMessage());
            }
        }
    }
}

package RetryableFrameWork;

import java.util.Date;
import java.util.PriorityQueue;

public abstract class Task {
    long nextRunMili;
    RetryStrategy strategy;
    String name;
    int status = 0; //0-start , 1- inprogress,2-halted, 3 done;

    Task(String name, RetryStrategy retryStrategy, long nextRunMili) {
        this.name = name;
        this.strategy = retryStrategy;
        this.nextRunMili = nextRunMili;
    }

    final void start() {
        execute();
        status = 2;
        if (strategy.TOTAL_RETRY_REQUIRED == strategy.retryCount) {
            status = 3;
        }
    }

    abstract void execute() throws RuntimeException;
}

class ComputePie extends Task {

    ComputePie(String name, RetryStrategy retryStrategy, long nextRunMili) {
        super(name, retryStrategy, nextRunMili);
    }

    int i = 0;

    @Override
    void execute() throws RuntimeException {
        i++;
        System.out.println(i + "th Iteration, Calculate 22/7 =" + 22 / 7);
        if (i != 5) {
            throw new RuntimeException(i + "th Iteration, Exception while calculation");
        }
    }
}

class TaskExecutor extends Thread {
    PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> (int) (a.nextRunMili - b.nextRunMili));

    void add(Task a) {
        tasks.add(a);
    }

    public void run() {
        int i = 0;
        while (true) {
            i++;
            try {
                Thread.sleep(1000);
                //System.out.println("slept for 1 sec for " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tasks.isEmpty()) {
                System.out.println("nothing to run");
                return;
            }
            Task currentTask = tasks.poll();
            if (currentTask.status == 3) {
                continue;
            }else if (currentTask.nextRunMili > System.currentTimeMillis()){
                tasks.add(currentTask);
                continue;
            }

            try {
                System.out.println();
                System.out.println(new Date() + " Executing " + currentTask.name);
                currentTask.start();
            } catch (RuntimeException e) {
                System.out.println(currentTask.name + " Exception is caught. " + e.getMessage());
                currentTask.nextRunMili = currentTask.strategy.nextRun(currentTask.nextRunMili);
                tasks.add(currentTask);
            }/* catch (InterruptedException e) {

            }*/
        }
    }


}

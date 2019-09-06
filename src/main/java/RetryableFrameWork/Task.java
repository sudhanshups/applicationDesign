package RetryableFrameWork;

import java.util.Date;

enum TASK_STATUS {
    SCHEDULED, IN_PROGRESS, FAILED, FINISHED
}

public abstract class Task {
    final int TOTAL_RETRY_REQUIRED;
    private RetryStrategy strategy;
    String taskName;
    TASK_STATUS status;
    private int retryCount = 0;
    private long firstRun;
    long nextRunMilli;

    Task(String name, int totalRetries, RetryStrategy retryStrategy, long nextRunMilli) {
        this.taskName = name;
        TOTAL_RETRY_REQUIRED = totalRetries;
        this.strategy = retryStrategy;
        this.nextRunMilli = nextRunMilli;
        this.status = TASK_STATUS.SCHEDULED;
    }

    final void start() {
        System.out.println(new Date() + ": " + taskName + " -starting the task");
        if (TASK_STATUS.SCHEDULED.equals(status)) {
            firstRun = System.currentTimeMillis();
        }
        status = TASK_STATUS.IN_PROGRESS;
        retryCount++;

        try {
            execute();
            status = TASK_STATUS.FINISHED;
            System.out.println(new Date() + ": " + taskName + " -Finished the task");
        } catch (RuntimeException e) {
            if (TOTAL_RETRY_REQUIRED == retryCount) {
                status = TASK_STATUS.FINISHED;
                System.out.println(new Date() + ": " + taskName + " -failed the task");
            } else {
                status = TASK_STATUS.FAILED;
                nextRunMilli = strategy.nextRunTime(firstRun, retryCount);
                System.out.println(new Date() + ": " + taskName + " -failed the task. == next Execution Time" + new Date(nextRunMilli));
                throw e;
            }
        }
    }

    abstract void execute() throws RuntimeException;
}

class ComputePie extends Task {
    ComputePie(String name, int totalRetries, RetryStrategy retryStrategy, long nextRunMili) {
        super(name, totalRetries, retryStrategy, nextRunMili);
    }

    int i = 0;

    @Override
    void execute() throws RuntimeException {
        i++;
        //Test Exception thrown
        if (i != 2) {
            throw new RuntimeException(i + "th Iteration, Exception while calculation");
        }
    }
}

class Multiply extends Task {
    Multiply(String name, int totalRetries, RetryStrategy retryStrategy, long nextRunMili) {
        super(name, totalRetries, retryStrategy, nextRunMili);
    }

    int i = 0;

    @Override
    void execute() throws RuntimeException {
        i++;
        //Test Exception thrown
        if (i != 2) {
            throw new RuntimeException(i + "th Iteration, Exception while calculation");
        }
    }
}

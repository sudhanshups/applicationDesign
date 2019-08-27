package RetryableFrameWork;

public abstract class RetryStrategy {
    int TOTAL_RETRY_REQUIRED = 3;
    int retryCount = 0;

    abstract long nextRun(long nextRunMili);
}

class ExponentialRetry extends RetryStrategy {
    final int EXPONENT = 2;

    long nextRun(long nextRunMili) {
        if (System.currentTimeMillis() < nextRunMili) {
            return nextRunMili;
        }
        retryCount++;
        return (long) (System.currentTimeMillis() + Math.pow(EXPONENT, retryCount) * 1000);
    }

    ExponentialRetry(int totalRetryRequired) {
        this.TOTAL_RETRY_REQUIRED = totalRetryRequired;
    }
}

class IncrementalRetry extends RetryStrategy {
    long RETRY_INTERVAL;

    long nextRun(long nextRunMili) {
        if (System.currentTimeMillis() < nextRunMili) {
            return nextRunMili;
        }
        retryCount++;
        return System.currentTimeMillis() + RETRY_INTERVAL * 1000;
    }

    IncrementalRetry(int totalRetryRequired, long retryInterval) {
        this.TOTAL_RETRY_REQUIRED = totalRetryRequired;
        this.RETRY_INTERVAL = retryInterval;
    }
}

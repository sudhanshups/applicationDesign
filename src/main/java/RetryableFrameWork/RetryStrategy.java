package RetryableFrameWork;

interface RetryStrategy {
    long nextRunTime(long firstRun, int retryCount);
}

class ExponentialBackOffRetry implements RetryStrategy {
    final int EXPONENT = 2;

    public long nextRunTime(long firstRun, int retryCount) {
        long timeToAdd = 0;
        for (int i = 1; i <= retryCount; i++) {
            timeToAdd += (long) Math.pow(EXPONENT, i) * 1000;
        }
        return firstRun + timeToAdd;
    }

    ExponentialBackOffRetry() {
    }
}

class IncrementalRetry implements RetryStrategy {
    long RETRY_INTERVAL;

    public long nextRunTime(long firstRun, int retryCount) {
        return (firstRun + retryCount * RETRY_INTERVAL * 1000);
    }

    IncrementalRetry(long retryInterval) {
        this.RETRY_INTERVAL = retryInterval;
    }
}
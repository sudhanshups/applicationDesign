package LoggingObserver;

public enum MessageType {
    ERROR(3),
    WARNING(2),
    GENERAL(1);

    int priority;

    MessageType(int pri) {
        priority = pri;
    }
}

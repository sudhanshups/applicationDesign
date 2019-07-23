package LoggingObserver;

import java.util.HashMap;
import java.util.Map;

public class Logger extends Subject {

    Map<MessageType, Boolean> messageStatusMap = new HashMap<>();


    public Logger() {
        messageStatusMap.put(MessageType.ERROR, true);
        messageStatusMap.put(MessageType.WARNING, true);
        messageStatusMap.put(MessageType.GENERAL, true);
    }

    public void writeLog(MessageType type, String message) {
        if (messageStatusMap.get(type)) {
            setData(message);
            notify(type);
        }
    }

    public void enableLoggingOfMessage(MessageType type) {
        messageStatusMap.put(type, true);
    }

    public void disableLoggingOfMessage(MessageType type) {
        messageStatusMap.put(type, false);
    }
}

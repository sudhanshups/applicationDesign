package LoggingObserver;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
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

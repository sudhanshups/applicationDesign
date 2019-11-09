package LoggingObserver;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public abstract class Subject {

    Map<MessageType, List<Observer>> registryMap = new HashMap<>();
    String data;

    public String getData() {
        return data;
    }

    public void setData(String value) {
        data = value;
    }

    public void attach(MessageType messageType, Observer pObsrvr) {
        if (!registryMap.containsKey(messageType)) {
            registryMap.put(messageType, new ArrayList<>());
        }

        registryMap.get(messageType).add(pObsrvr);
        if (messageType.priority < MessageType.WARNING.priority) {
            registryMap.get(MessageType.WARNING).add(pObsrvr);
        }
        if (messageType.priority < MessageType.ERROR.priority) {
            registryMap.get(MessageType.ERROR).add(pObsrvr);
        }
    }

    public void detach(Observer observer) {
        for (Map.Entry<MessageType, List<Observer>> entry : registryMap.entrySet()) {
            entry.getValue().remove(observer);
        }
    }

    public void notify(MessageType messageType) {
        if (registryMap.containsKey(messageType)) {
            registryMap.get(messageType).forEach(u -> u.update(this));
        }
    }
}


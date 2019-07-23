package LoggingObserver;

interface Observer {
    void update(Subject pSubject);
}


class ConsoleLoggingPlatform implements Observer {
    public void update(Subject pSubject) {
        System.out.println(pSubject.getData());
    }
}

class FlatFileLoggingPlatform implements Observer {
    String fileName;

    public FlatFileLoggingPlatform(String name) {
        fileName = name;
    }

    public void update(Subject pSubject) {
        // all the batching of message to write in file in one go will be done here.
        String data = pSubject.getData();
        System.out.println(fileName + "  " + pSubject.getData());
        // Add data to file
    }
}


class NetworkLoggingPlatform implements Observer {
    public void update(Subject pSubject) {
        String data = pSubject.getData();
        // Send data in network
    }
}
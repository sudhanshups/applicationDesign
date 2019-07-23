package LoggingObserver;

public class Tester {
    public static void main(String[] args) {

        Logger logger = new Logger();
        logger.enableLoggingOfMessage(MessageType.GENERAL);
        logger.enableLoggingOfMessage(MessageType.ERROR);

        Observer consoleObserver = new ConsoleLoggingPlatform();
        Observer flatFileObserver = new FlatFileLoggingPlatform("flatFile");

        logger.attach(MessageType.GENERAL, consoleObserver);
        logger.attach(MessageType.WARNING, flatFileObserver);
        logger.writeLog(MessageType.WARNING, "I am Robat");

        logger.detach(flatFileObserver);
        logger.writeLog(MessageType.GENERAL, "I am Robat2");

    }
}

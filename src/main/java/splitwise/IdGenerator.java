package splitwise;

public class IdGenerator {
    private static volatile int id=0;
    static synchronized int getId(){
        return ++id;
    }

}

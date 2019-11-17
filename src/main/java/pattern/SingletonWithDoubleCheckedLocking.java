package pattern;

public class SingletonWithDoubleCheckedLocking {

    // The sole instance of the class. Note its marked volatile(never cached, available to all thread for read)
    private volatile static SingletonWithDoubleCheckedLocking onlyInstance;

    // Make the constructor private so its only accessible to members of the class.
    private SingletonWithDoubleCheckedLocking() {
    }

    public void fly() {
        System.out.println(this + "  Airforce one is flying...");
    }

     public static SingletonWithDoubleCheckedLocking getInstance() {
        if (onlyInstance == null) {
            synchronized (SingletonWithDoubleCheckedLocking.class) {
                if (onlyInstance == null) {
                    onlyInstance = new SingletonWithDoubleCheckedLocking();
                }
            }
        }
        return onlyInstance;
    }
}

class driver{
    public static void main(String []args){
        SingletonWithDoubleCheckedLocking s = SingletonWithDoubleCheckedLocking.getInstance();
        s.fly();

        SingletonWithDoubleCheckedLocking p = SingletonWithDoubleCheckedLocking.getInstance();
        p.fly();

    }
}
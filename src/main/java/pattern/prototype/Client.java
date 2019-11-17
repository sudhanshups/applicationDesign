package pattern.prototype;


interface Prototype {
    Object clone();
}

class ConcretePrototype implements Prototype {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}



public class Client {

    public static void main(String arg[]) {
        ConcretePrototype obj1 = new ConcretePrototype();
        ConcretePrototype obj2 = (ConcretePrototype) obj1.clone();

    }
}

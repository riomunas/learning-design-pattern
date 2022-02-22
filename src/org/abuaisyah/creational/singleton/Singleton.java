package org.abuaisyah.creational.singleton;
import java.io.Serializable;

public class Singleton implements Serializable {
    //this for resolve deseriliaze issue when the class structure is modified
    private static final long serialVersionUID = 1L;
    //volatile is to make sure this field is readable to any thread that use shared resource
    private static volatile Singleton instance;
    public String value;

    private Singleton(String value) {
        // The following code emulates slow initialization for demonstrate unsafe thread
        try {
            Thread.sleep(1000);
            this.value = value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstance(String value) {
        //speedup process if the instance is not null
        Singleton result = instance;
        //double checked for locking implementation
        if (result != null) {
            return result;
        }
        //synchronized make sure only one thread on one time that can access this proceess
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //resolve serializable issue
    protected Object readResolve() {
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton#%s -> %s;".formatted(System.identityHashCode(this), value);
    }
}

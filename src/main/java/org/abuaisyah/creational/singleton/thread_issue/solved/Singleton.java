package org.abuaisyah.creational.singleton.thread_issue.solved;

public class Singleton {
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
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

    @Override
    public String toString() {
        return "Singleton#%s -> %s;".formatted(System.identityHashCode(this), value);
    }
}

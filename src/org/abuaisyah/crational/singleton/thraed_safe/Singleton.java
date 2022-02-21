package org.abuaisyah.crational.singleton.thraed_safe;

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
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Singleton#%s -> %s;".formatted(System.identityHashCode(this), value);
    }
}

package org.abuaisyah.creational.singleton.billpugh;

public class Singleton {
    public String value;
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton() {}

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        var instance1 = Singleton.getInstance();
        var instance2 = Singleton.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

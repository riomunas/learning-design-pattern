package org.abuaisyah.creational.singleton.eager;

/**
 *  
 */
public class Singleton {
    private static volatile Singleton instance = new Singleton();

    private Singleton () {}

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        var instance1 = Singleton.instance;
        System.out.println(instance1.hashCode());
    }
}

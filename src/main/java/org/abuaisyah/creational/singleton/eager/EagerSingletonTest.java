package org.abuaisyah.creational.singleton.eager;

public class EagerSingletonTest {
    public static void main(String[] args) {
        var instance1 = Singleton.getInstance();
        var instance2 = Singleton.getInstance();

        System.out.println("Instance 1 : "+instance1.hashCode());
        System.out.println("Instance 2 : "+instance2.hashCode());
    }
}

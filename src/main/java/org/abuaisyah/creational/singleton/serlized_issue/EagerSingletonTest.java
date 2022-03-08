package org.abuaisyah.creational.singleton.serlized_issue;

import java.io.*;

public class EagerSingletonTest {
    public static void main(String[] args) {
//        try {
//            var instanceOne = Singleton.getInstance();
//            instanceOne.value = "rio";
//            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
//            out.writeObject(instanceOne);
//            System.out.println(instanceOne.hashCode() + " " + instanceOne.value);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.ser"));
            var instanceTwo = (Singleton) in.readObject();
            System.out.println(instanceTwo.hashCode() + " " + instanceTwo.value);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Singleton implements Serializable {
    public String value;

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    protected Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
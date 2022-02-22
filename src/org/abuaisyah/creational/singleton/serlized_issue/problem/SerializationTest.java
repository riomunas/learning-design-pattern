package org.abuaisyah.creational.singleton.serlized_issue.problem;

import java.io.*;

public class SerializationTest {
    static Singleton instanceOne = Singleton.getInstance("10");

    public static void main(String[] args) {
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instanceOne);
            out.close();

            instanceOne.setValue("20");
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            Singleton instanceTwo = (Singleton) in.readObject();
            in.close();

            System.out.println(instanceOne.getValue());
            System.out.println(instanceTwo.getValue());
      in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

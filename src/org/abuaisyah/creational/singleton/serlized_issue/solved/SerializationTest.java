package org.abuaisyah.creational.singleton.serlized_issue.solved;

import java.io.*;

public class SerializationTest {
    static Singleton instanceOne = Singleton.getInstance("0");

    public static void main(String[] args) {
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instanceOne);
            out.close();
            instanceOne.value = "20";
            System.out.println(instanceOne.value);

            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            Singleton instanceTwo = (Singleton) in.readObject();
            in.close();
            System.out.println(instanceTwo.value);
      in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
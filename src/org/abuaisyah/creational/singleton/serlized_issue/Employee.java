package org.abuaisyah.creational.singleton.serlized_issue;

import org.abuaisyah.creational.singleton.serlized_issue.solved.Singleton;

import java.io.*;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;

    public static void main(String[] args) {
        try {
            var instanceOne = new Employee();
            instanceOne.name = "rio";
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("fileemployee.ser"));
            out.writeObject(instanceOne);
            System.out.println(instanceOne.name);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream("fileemployee.ser"));
            var instanceTwo = (Employee) in.readObject();
            System.out.println(instanceTwo.name);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

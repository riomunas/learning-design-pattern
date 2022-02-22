package org.abuaisyah.creational.singleton.thread_issue.problem;

public class SingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Singleton.getInstance("FOO").toString());
        }).start();
        new Thread(() -> {
            System.out.println(Singleton.getInstance("BAR").toString());
        }).start();
    }
}

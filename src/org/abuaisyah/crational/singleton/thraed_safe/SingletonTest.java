package org.abuaisyah.crational.singleton.thraed_safe;

import org.abuaisyah.crational.singleton.thraed_safe.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("""
        If you see the same value, then singleton was reused (yay!)
        If you see different values, then 2 singletons were created (booo!!)
        RESULT:
        """);
//        new Thread(() -> {
//            System.out.println(Singleton.getInstance("FOO", 5000).toString());
//        }).start();
//        new Thread(() -> {
//            System.out.println(Singleton.getInstance("BAR", 500).toString());
//        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Singleton.getInstance("FOO").toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            System.out.println(Singleton.getInstance("BAR").toString());
        }).start();

    }
}

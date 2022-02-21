package org.abuaisyah.crational.singleton.non_thraed_safe;

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

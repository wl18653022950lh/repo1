package threadTest;

import static javafx.scene.input.KeyCode.O;

/**
 * @Author wl
 * @Date 2020/5/20 21:59
 * @Version 1.0
 */

public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                    System.out.println("Thread A get lock");
                        Thread.sleep(20);
                        System.out.println("Thread A do wait method");
                        lock.wait();
                        System.out.println("Thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread B is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("Thread B get lock");
                        Thread.sleep(10);
                        System.out.println("Thread B is sleeping 10 ms");
                        System.out.println("Thread B is done");
                        lock.notify();//lock.notifyAll()
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

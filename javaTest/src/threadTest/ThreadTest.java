package threadTest;

/**
 * @Author wl
 * @Date 2020/5/19 21:13
 * @Version 1.0
 */

public class ThreadTest {
    private static void attack(){
        System.out.println("fight");
        System.out.println("currentThread is:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
            attack();
            }
        };
        System.out.println("currentThread is:" + Thread.currentThread().getName());
        t.run();//currentThread is:main  fight  currentThread is:main
        t.start();//currentThread is:main  fight  currentThread is:Thread-0
    }
}

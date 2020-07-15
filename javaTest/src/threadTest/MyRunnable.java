package threadTest;

/**
 * @Author wl
 * @Date 2020/5/19 21:45
 * @Version 1.0
 */

public class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name){
        this.name = name;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start:" + this.name+",i=" + i);
        }
    }

    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable("Runnable1");
        MyRunnable mr2 = new MyRunnable("Runnable2");
        MyRunnable mr3 = new MyRunnable("Runnable3");
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
        t1.start();
        t2.start();
        t3.start();

    }
}

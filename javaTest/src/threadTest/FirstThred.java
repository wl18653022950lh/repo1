package threadTest;

/**
 * @Author wl
 * @pDate 2020/5/18 21:37
 * @Version 1.0
 */

public class FirstThred {
    public static void main(String[] args) {
        //创建自定义线程对象
        MyThread mt1 = new MyThread("Thread1");
        MyThread mt2 = new MyThread("Thread2");
        MyThread mt3 = new MyThread("Thread3");
        //开启新线程
        mt1.start();
        //在主方法中执行for循环
        for (int i = 0; i <10 ; i++) {
            System.out.println("main线程"+i);
        }
    }


}
class MyThread extends Thread {
    //定义指定线程名称的构造方法  
    public MyThread(String name) {
        //调用父类的String参数的构造方法，指定线程的名称        
        super(name);
    }
    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "：正在执行！" + i);
        }
    }
}
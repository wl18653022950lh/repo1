package threadTest;

/**
 * @Author wl
 * @Date 2020/5/20 11:22
 * @Version 1.0
 */

public class CycleWait implements Runnable{
    private String value;
    public void run(){
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we hava data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();
        //主线程等待法 需要自己实现循环等待的逻辑，如何等待的变量多，代码就会很臃肿；需要循环多久不确定，没法做更精准地控制
        while(cw.value == null){
            Thread.currentThread().sleep(100);
        }
        //使用join阻塞
        t.join();
        System.out.println("value=:" +cw.value);
    }

}

package myAlgorithm;

/**
 * @Author wl
 * @Date 2020/5/29 9:19
 * @Version 1.0
 */
//八皇后问题：任意两个皇后都不能处于同一行、同一列、或同一条斜线，问有多少种摆法
    //第一个皇后放到第一行第一列，第二个皇后放到第二行第二列，判断是否ok,不ok的话继续放到第二列，第三列，直到ok
public class Queen8 {
    //放置第n个皇后
    int max = 8;
    int[] array = new int[max];
    static int count=0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen = new Queen8();
        queen.check(0);
        System.out.printf("一共有%d解法",count);
        System.out.printf("一共判断冲突的次数%d次",judgeCount);
    }
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        //依次放入皇后，并判断是否有冲突
        for (int i = 0; i <max ; i++) {
            //先把当前这个皇后放到第n+1行第1列
            array[n] = i;
            if(judge(n)){//不冲突
                check(n+1);//继续放n+1个皇后
            }
            //如果冲突，i++
        }
    }

    private boolean judge(int n) {
        judgeCount++;
        //判断是否位于同一列
        for (int i = 0; i < n; i++) {
            if(array[n] == array[i]){
                return false;
            }
            //判断是否位于同一条斜线
            if(Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;

    }

    //将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }
}

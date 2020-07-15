package myAlgorithm;

public class Recursive {
    //大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。 n<=39
    //非递归实现
    public int Fibonacci1(int n) {
        int result = 0;
        int preNum1 = 0;
        int preNum2 = 1;
        if(n == 0){
            return preNum1;
        }
        if(n == 1){
            return preNum2;
        }
        if(n >= 2){
            for(int i = 2;i<=n;i++){
                result = preNum1 + preNum2;
                preNum1 = preNum2;
                preNum2 = result;
            }
        }
        return result;
    }

    //斐波那契数列 递归实现
    public int Fibonacci2(int n) {
        int result = 0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n >= 2){
            result = Fibonacci2(n-1)+Fibonacci2(n-2);
        }
        return result;
    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    //思路：n=1,只有一种跳法，n=2,两种，n=3，3种，n=4,5种，是斐波那契数列
    public int jumpSteps(int n) {
        int total = 0;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n >= 3){
            total = jumpSteps(n-1) + jumpSteps(n - 2);
        }
        return total;
    }


    //一只青蛙一次可以跳上1级台阶，可以跳上2级,……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //青蛙跳三级台阶相当于跳一级加上跳二级再加上直接跳上三级f(3) = f(1)+f(2)+1;f(2)=f(1)+1;即f(3) = 2f(2);即f(n) = 2f(n-1)
    public static int jumpSteps2(int n) {
        int totalMethod = 0;
        if(n == 1){
            return 1;
        }
        if(n >= 2){
            totalMethod = 2*jumpSteps2(n-1);
        }
        return totalMethod;
    }
    //我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    //思路：只考虑第一块如何放，横着还是竖着，比如当n = 4时，第一块竖着，相当于n=3的情况，第一块横着，相当于n=2的情况，所以f(n)=f(n-1)+f(n-2)
    public static int RectCover(int target) {
        int totalMethod = 0;
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        if(target > 2){
            totalMethod = RectCover(target-1)+RectCover(target-2);
        }
        return totalMethod;
    }
}

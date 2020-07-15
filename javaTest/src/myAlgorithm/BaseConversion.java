package myAlgorithm;

import static java.lang.Math.abs;

/**
 * @Author wl
 * @Date 2020/5/18 9:23
 * @Version 1.0
 */

public class BaseConversion {
    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public static int NumberOf1(int n) {
        //bitCount用于统计二进制中1的个数
        //return Integer.bitCount(n);
        int result = 0;// 记录数字中1的位数
        for (int i = 0; i < 32; i++) {//int占32bit
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("数字9的二进制表示中的1的个数:"+NumberOf1(9));//2
        System.out.println("result=:"+Power(2.0,2));
    }

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
    public static double Power(double base, int exponent) {
        if(base == 0){
            System.out.println("分母不能为0");
        }
        if(exponent == 0){
            return 1;
        }
        double result = base;
        int pow = abs(exponent);
        for(int i = 1;i<pow;i++){
            result = result * base;
        }
        if(exponent<0){
            result = 1.0/result;
        }

        return result;
    }




}

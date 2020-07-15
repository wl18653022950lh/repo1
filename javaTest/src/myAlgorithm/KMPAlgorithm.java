package myAlgorithm;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = KMPnext(str2);
        System.out.println(KMPAl(str1,str2,next));

    }
    public static int KMPAl(String str1,String str2,int[] next){
        for (int i = 0,j=0; i < str1.length(); i++) {
            //str2.charAt(j) != str1.charAt(i)时，需要从next[j-1]获取新的j
            //str2.charAt(j) == str1.charAt(i)时，退出
            //KMP算法的核心
            while(j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            //str2.charAt(j) == str1.charAt(i)时，部分匹配值加1
            if(str2.charAt(j) == str1.charAt(i)){
                j++;
            }
            if(j == str2.length()){//找到了
                return i-j+1;
            }
        }
        return -1;
    }

    //获取一个字符串的部分匹配表
    public static int[] KMPnext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        //如果字符串长度为1，部分匹配值就是0
        next[0] = 0;
        for (int i = 1,j=0; i < dest.length(); i++) {
            //当dest.charAt(j) != dest.charAt(i)时，需要从next[j-1]获取新的j
            //直到发现有dest.charAt(j) == dest.charAt(i)时，退出
            //KMP算法的核心
            while(j>0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j-1];
            }
            //当dest.charAt(j) == dest.charAt(i)时，部分匹配值加1
            if(dest.charAt(j) == dest.charAt(i)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}

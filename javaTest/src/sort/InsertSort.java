package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {8,7,6,2,4,9,1};
        System.out.println(Arrays.toString(insertSort2(array)));
    }
    public static int[]  insertSort1(int[] array){
        for (int i = 1; i < array.length; i++) {
            //定义待插入的元素
            int insertVal = array[i];
            int insertIndex = i-1;
            //给insertVal找到插入的位置
            //1.insertIndex>=0保证不越界
            //2.insertVal< array[insertIndex],说明带插入的数还没有找到位置
            //3.就需要将array[insertIndex]后移  数组就变为[8,8,6,2,4,9,1]
            while(insertIndex>=0 && insertVal < array[insertIndex]){
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }
            //退出while循环时，说明找到了位置，位置为insertIndex+1,为什么加1，因为开始的时候insertIndex = i-1
            array[insertIndex+1] = insertVal;
        }
        return array;
    }


    public static int[]  insertSort2(int[] array){
        for (int i = 1; i < array.length; i++) {
            //定义待插入的元素
            int insertVal = array[i];
            int j;
            //array[j]>insertVal,说明带插入的数还没有找到位置
            //3.就需要将array[j]后移  数组就变为[8,8,6,2,4,9,1]
            for (j = i-1; j >=0&&array[j]>insertVal; j--) {
                    array[j+1] = array[j];
            }
            //说明找到了位置
            array[j+1] = insertVal;
        }
        return array;
    }
}

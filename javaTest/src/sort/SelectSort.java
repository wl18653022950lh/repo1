package sort;

/**
 * @Author wl
 * @Date 2020/5/29 17:21
 * @Version 1.0
 */

public class SelectSort {
    //选择排序比冒泡排序时间复杂度要低
    public void selectSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i+1; j < array.length - 1; j++) {
                if(min>array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}

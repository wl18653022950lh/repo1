package sort;

/**
 * @Author wl
 * @Date 2020/5/29 17:11
 * @Version 1.0
 */

public class BubbleSort {
    public void bubbleSort(int[] array){
        boolean flag = false;//标识变量，表示是否交换过
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] >array[j+1]){
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;//重置flag，进行下次判断
            }
        }
    }
}

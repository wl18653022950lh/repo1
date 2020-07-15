package sort;

public class  ShellSort {
    public void shellSort(int[] array){
        for (int gap = array.length/2; gap >=1; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if(array[j] < array[j-gap]){
                    while(j-gap>=0 && temp < array[j-gap]){
                        //移动元素
                        array[j] = array[j-gap];
                        j-=gap;
                    }
                }
                //退出循环，说明找到了位置
                array[j] = temp;
            }
        }
    }
}

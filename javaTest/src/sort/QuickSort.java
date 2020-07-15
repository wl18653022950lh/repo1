package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 62, 3, 4, 1, 8, 9, 19};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void quickSort(int[] array) {
        if (array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if(start >end){
            return;
        }
        //选择第一个数为基准数
        int baseNum = array[start];
        int low = start;
        int high = end;
        while (low < high) {
            //如果右边的数比基准数大
            while (low < high && baseNum <= array[high]) {
                high--;
            }

            //如果左边的数比基准数小
            while (low < high && array[low] <= baseNum) {
                low++;
            }
            //退出循环，说明找到左边数比基准数大,右边数比基准数小，交换
            if(low<high){
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }

        }
        //low与high相遇
        array[start] = array[low];
        array[low] = baseNum;
        quickSort(array, start, low-1);
        quickSort(array, low + 1, end);
    }



}

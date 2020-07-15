package sort;

public class MergeSort {

    public  void mergeSort(int[] array,int low,int high){
        if(low>high){
            return;
        }
        int mid = (low+high)>>>1;
        //分解
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        //第一个数组的开始下标
        int s1 = low;
        //第二个数组的开始下标
        int s2 = mid+1;
        //用于存储归并后的临时数组
        int[] temp = new int[high-low+1];
        //临时数组的下标
        int index = 0;
        //将s1、s2元素放进临时数组中
        while(s1 <= mid && s2 <= high){
            if(array[s1]<array[s2]){
                temp[index++] = array[s1++];
            }else{
                temp[index++] = array[s2++];
            }
        }
        //将s1或s2中剩余元素放入临时数组中
        while(s1<=mid){
            temp[index++] = array[s1++];
        }

        while(s2<=high){
            temp[index++] = array[s2++];
        }

        //将临时数组中的元素放入原数组
        for (int i = 0; i < temp.length; i++) {
            array[i+low] = temp[index++];
        }

    }
}

package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr=new int[]{9,6,8,7,0,1,10,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] array){
        int temp = 0;
        //开始位置是最后一个非叶子节点
        int start = (array.length-1)/2;
        //调整为大顶堆
        for (int i = start; i >=0; i--) {
            adjustHeap(array,i,array.length);
        }
        //将数组中第一个元素与最后一个进行交换,再把前面的进行调整
        for (int i = array.length-1; i >0 ; i--) {
            temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array,0,i);
        }
    }

    private static void adjustHeap(int[] array, int i, int length) {
        //左子节点
        int leftNode = 2*i+1;
        //右子节点
        int rightNode = 2*i+2;
        //和两个子节点分别对比，找出最大的节点
        int max = i;
        if(leftNode<length && array[leftNode]>array[max]){
            max = leftNode;
        }
        if(rightNode<length && array[rightNode]>array[max]){
            max = rightNode;
        }
        //找出后交换
        if(max!=i){
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            //交换位置后可能会破坏之前排好的堆，所以需要重新调整
            adjustHeap(array,max,length);
        }
    }



}

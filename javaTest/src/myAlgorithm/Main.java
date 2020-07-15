package myAlgorithm;

import sun.font.FontRunIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int count = 1;
        int max = 1;
        int len = sc.nextInt();
        if(len <= 100000){
            int[] arr1 = new int[len];
            int[] arr2 = new int[len];
            for (int i = 0; i <len ; i++) {
                arr1[i] = sc.nextInt();
            }
            if(len < arr1.length){
                System.out.println(0);
            }
            for (int k = 0; k < len; k++) {
                arr2[k] = arr1[k];
                for (int m = k+1; m < len; m++) {
                    arr2[m] = arr1[m];
                    if(arr2[k]+1 == arr2[m]){
                        count+=1;
                        arr2[k] = arr2[m];
                    }
                }
                if(count > max){
                    max = count;
                }
                count = 1;
            }
            System.out.println(len - max);
        }*/
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[50];
        arr1[0] = 1;
        for (int i = 2; i <= 50; i++) {
            arr1[i-1] = 2*i-1;
        }
        int[] arr2 = new int[50];
        for (int j = 1; j <= 50 ; j++) {
            arr2[j-1] = j*2;
        }
        while(sc.hasNext()){
            String input_1 = sc.nextLine();
            int n = Integer.parseInt(input_1);
            String input_2 = sc.nextLine();
            String[] cutNumber = input_2.split(" ");
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int k = 0; k < cutNumber.length; k++) {
                int cur = Integer.parseInt(cutNumber[k]);
                if((cur & 1) ==0){
                    list2.add(cur);
                }else{
                    list1.add(cur);
                }
            }
            int[] list1Longest = getLongest(arr1,list1);
            int[] list2Longest = getLongest(arr2,list2);
            if(list1Longest[1]>list2Longest[1]){
                System.out.println(list1Longest[0]+" "+list1Longest[1]);
            }else if(list1Longest[1]<list2Longest[1]){
                System.out.println(list2Longest[0]+" "+list2Longest[1]);
            }else{
                if(list2Longest[0]<list1Longest[0]){
                    System.out.println(list2Longest[0]+" "+list2Longest[1]);
                }else{
                    System.out.println(list1Longest[0]+" "+list1Longest[1]);
                }
            }

        }
    }

    private static int[] getLongest(int[] arr1, ArrayList<Integer> list1) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr1.length; i++) {
            queue.add(arr1[i]);
        }
        Collections.sort(list1);
        int temp = -1;
        int longest = 0;
        int n = 0;
        while(!queue.isEmpty()&& n<list1.size()){
            int cutVal = list1.get(n);
            int curLen = 0;
            int curTemp = queue.peek();
            while(!queue.isEmpty()&& queue.peek()<cutVal){
                queue.poll();
                curLen++;
            }
            if(!queue.isEmpty()&& cutVal == queue.peek()){
                queue.poll();
            }
            if(curLen>longest){
                temp = curTemp;
                longest = curLen;
            }
            n++;
        }
        if(!queue.isEmpty()){
            if(queue.size()>longest){
                temp = queue.peek();
                longest = queue.size();
            }
        }
        int[] res = new int[2];
        res[0] = temp;
        res[1] = longest;
        return res;
    }

}

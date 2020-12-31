package sorting_algorithm;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={9,4,7,8,6,1,3,5,2};
        sort(arr);
        printArr(arr);
    }
    static void sort(int arr[]){
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }

    static void swap(int[] arr, int j, int i) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    static void printArr(int arr[]){
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1){
                System.out.print(arr[i]+",");
            }else{
                System.out.println(arr[i]+"}");
            }
        }
    }
}

package sorting_algorithm;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import util.PrintArr;
import util.Swap;

public class BubbleSort {
    static void sort(int arr[]){
        for(int i=arr.length-1;i>0;i--){
            findMax(arr,i);
        }
    }
    private static void findMax(int arr[] ,int n){
        for(int j=0;j<n;j++){
            if(arr[j]>arr[j+1])
                swap(arr,j,j+1);
        }
    }
    private static void swap(int[] arr, int j, int i) {
        Swap instance = Swap.getInstance();
        instance.swap(arr,j,i);
    }
    public static void main(String[] args) {
        PrintArr instance= PrintArr.getInstance();
        int arr[]={9,4,7,8,6,1,3,5,2,24};
        sort(arr);
        instance.display(arr);

    }
}

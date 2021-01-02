package sorting_algorithm;

import util.PrintArr;
import util.Swap;

public class InsertSort {
    public static void main(String[] args) {
        int arr[]={9,3,1,4,6,8,7,5,2,0};
        sort(arr);
        print(arr);
    }

    static void sort(int [] arr){
        for(int i=1;i<arr.length;i++){  //抽出第几张牌
            for(int j=i;j>0 && arr[j]<arr[j-1];j--){
                //if(arr[j]<arr[j-1]){
                    //swap(arr,j,j-1);
                findMax(arr,i);
                //}
            }
        }
    }
    static void  findMax(int arr[],int n){
        for(int i=0;i<n;i++){
            if(arr[i]>arr[i+1]){
                swap(arr,i,i+1);
            }
        }
    }

    static void swap(int arr[],int i,int j){
        Swap.swap(arr,i,j);
    }

    static void print(int arr[]){
        PrintArr.display(arr);
    }
}

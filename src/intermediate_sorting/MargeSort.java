package intermediate_sorting;

import util.PrintArr;
import util.Swap;

public class MargeSort {
    public static void main(String[] args) {
        int arr[]={1,4,6,7,10,3,5,8,9};
        sort(arr);
    }
    public static void sort(int arr[]){
        marge(arr);
    }

    static void marge(int arr[]){  //归并排序
        int mid=arr.length >>1;  //中间位置
        int temp[]=new int[arr.length];   //创建一个新的数组存储排序好的数据；
        int i=0;   //指针指在已经排好位置的第一个子数组的第一个位置；
        int j=mid+1;  //指针指在已经排好位置的第二个子数组的第一个位置；
        int k=0;  //指针指在新的数据第一个位置；

        while(i<=mid && j< arr.length){
            temp[k++]= arr[i]<=arr[j] ? arr[i++]:arr[j++];
            /*
            if(arr[i]<=arr[j]){
                //temp[k]=arr[i];
                temp[k++]=arr[i++]
                //i++;
                //k++;
            }else{
                //temp[k]=arr[j];
                temp[k++]=arr[j++];
                //j++;
                //k++;
            }
             */
        }

        while(i<=mid){  //检查前半截的循环
            temp[k++]=arr[i++];
        }
        while(j<arr.length){  //检查后半截的循环，没有直接赋值到新的数组
            temp[k++]=arr[j++];
        }
        print(temp);
    }

    static void swap(int arr[] ,int j,int i){
        Swap.swap(arr,j,i);
    }

    static void print(int arr[]){
        PrintArr.display(arr);
    }
}

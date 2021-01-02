package intermediate_sorting;

import util.PrintArr;
import util.Swap;

public class MergeSort_1 {
    public static void main(String[] args) {
        int arr[]={1,4,6,7,10,3,5,8,9};
        sort(arr,0,arr.length-1);
        print(arr);
    }
    public static void sort(int arr[],int left,int right){
        if(left==right){
            return ;
        }
        //分成两半
        int mid=left+(right-left)/2;  //0+4
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        //合并排序
        marge(arr,left,mid+1,right);
    }

    static void marge(int arr[],int leftPtr,int rightPtr,int rightBound){  //归并排序
        int mid=rightPtr-1;  //中间位置
        int temp[]=new int[rightBound-leftPtr+1];   //创建一个新的数组存储排序好的数据；
        int i=leftPtr;   //指针指在已经排好位置的第一个子数组的第一个位置；
        int j=rightPtr;  //指针指在已经排好位置的第二个子数组的第一个位置；
        int k=0;  //指针指在新的数据第一个位置；

        while(i<=mid && j<=rightBound){
            temp[k++]= arr[i]<=arr[j] ? arr[i++]:arr[j++];
        }

        while(i<=mid){  //检查前半截的循环
            temp[k++]=arr[i++];
        }
        while(j<=rightBound){  //检查后半截的循环，没有直接赋值到新的数组
            temp[k++]=arr[j++];
        }

        for(int m=0;m< temp.length;m++){
            arr[leftPtr+m] = temp[m];
        }
        //print(temp);
    }

    static void swap(int arr[] ,int j,int i){
        Swap.swap(arr,j,i);
    }

    static void print(int arr[]){
        PrintArr.display(arr);
    }
}

package simple_sorting;

/*
* 插入排序
一、概念及其介绍
插入排序(InsertionSort)，一般也被称为直接插入排序。

对于少量元素的排序，它是一个有效的算法。插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增 1 的有序表

。在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动。

二、适用说明
插入排序的平均时间复杂度也是 O(n^2)，空间复杂度为常数阶 O(1)，具体时间复杂度和数组的有序性也是有关联的。

插入排序中，当待排序数组是有序时，是最优的情况，只需当前数跟前一个数比较一下就可以了，这时一共需要比较 N-1 次，时间复杂度为 O(N)。最坏的情况是待排序数组是逆序的，此时需要比较次数最多，最坏的情况是 O(n^2)。
* */

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
package simple_sorting;

/*

冒泡排序（Bubble Sort） 最为简单的一种排序，通过重复走完数组的所有元素，通过打擂台的方式两个两个比较，
        直到没有数可以交换的时候结束这个数，再到下个数，直到整个数组排好顺序。因一个个浮出所以叫冒泡排序。双重循环时间 O(n^2)
算法描述：
1，比较相邻两个数据如果。第一个比第二个大，就交换两个数
2，对每一个相邻的数做同样1的工作，这样从开始一队到结尾一队在最后的数就是最大的数。
3，针对所有元素上面的操作，除了最后一个。
4，重复1~3步骤，知道顺序完成。



* */

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

package simple_sorting;

import util.PrintArr;

//二分法插入排序
public class BinaryInsertSort {
    public static void main(String[] args) {
        int arr[]={12,3,4,23,78,90};
        sort(arr);
        print(arr);
    }
    static void sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            //与后面做比较的值（待插入到前面的值）
            int temp=arr[i];
            int left=0;  //数组的第一个位置的角标
            int right=arr.length-1;  //数组最后一个位置的角标
            int mid=0;  //数组的中间位置指针
            //之所以是大于等于因为等于的时候并不知道放在这个数的右边还是左边
            //还需要在执行一次则知道是前面还是后面
            while (left <= right){
                mid=(left+right)/2;
                if(temp>arr[mid]){//小于中间的值
                    left=mid+1;
                }else{  //大于中间的值
                    right=mid-1;
                }
            }
            //while循环完毕，left和right重叠后把temp插入进去
            for(int j=i-1;j>=left;j--){
                arr[j+1]=arr[j];
            }
            if(left != i){
                arr[left]=temp;
            }
        }
    }

    static void print(int[] arr){
        PrintArr.display(arr);
    }
}

package advanced_sorting;

import java.util.Arrays;

public class CountSort_2 {
    public static void main(String[] args) {
        int arr[]={9,3,5,4,9,1,2,7,8,1,3, 6, 5, 3, 4, 0, 10, 9, 7, 9,11,12,11,19};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int arr[]){
        //1，获取数组中的最大值
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //2，创建一个计数组的数组容器
        int count[]=new int[max+1];

        for(int i=0;i<arr.length;i++){  //将原数组的数据统计到计数数组中，相同的数据++，获取计数数组
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));   //打印计数数组
        //3，将计数数组添加的累计计数数组中；
        for(int i=1;i<count.length;i++){  //将计数数组统计到新的计数累计数组中；
            count[i]=count[i]+count[i-1];
        }
        System.out.println(Arrays.toString(count));  //打印累加计数数组；
        //倒序遍历累计计数数组，添加到新的结果数组中
        int result[]=new int[arr.length];  //创建与原数组相同长度的新数组（结果数组）
        for(int i = arr.length-1;i >= 0;i--){
            result[--count[arr[i]]]=arr[i];
        }
        return result;
    }
}

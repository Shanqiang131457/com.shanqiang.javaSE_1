package advanced_sorting;

import util.PrintArr;
import util.Swap;

import java.util.Arrays;

//计数排序
public class CountSort {
    public static void main(String[] args) {
        int arr[]={9,3,5,4,9,1,2,7,8,1,3, 6, 5, 3, 4, 0, 10, 9, 7, 9,11,12,11,19};
        int result[]= sort_1(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] sort_1(int arr[]){
        int max=arr[0];   //定义数组中0角标的元素为最大值
        for(int i=0;i<arr.length;i++){  //遍历数组求取最大值
            if(max<arr[i]){
                max=arr[i];   //求出最大的值赋值给max
            }
        }
        int result[]=new int[arr.length];   //新的结果数组

        int count[]=new int[max+1];   //统计数组 0~max+1;

        for(int i=0;i<arr.length;i++){
            count[arr[i]] ++;   //将原数组的元素放入到计数数组中，相同的数据在计数数组++；
        }

        System.out.println(Arrays.toString(count));   //打印数组

        for(int i=0,j=0;i<count.length;i++){   //通过遍历统计数组放入到新数组（结果数组）
            while(count[i]--> 0){
                result[j++] = i;
            }
        }

        return result;
    }

    static int[] sort(int arr[]){  //排序
        int result[]=new int[arr.length];  //结果数组(新的数组)

        int count[]=new int[11];  //统计数组：0～10

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        System.out.println(Arrays.toString(count));

        for(int i=0,j=0;i< count.length;i++){  //将统计数组添加到新的数组
            while(count[i]-- > 0){
                result[j++] = i;
            }
        }
        return result;
    }


    static void swap(int arr[],int i,int j){  //交换数组的位置
        Swap.swap(arr,i,j);
    }

    static void print(int arr[]){   //打印数组
        PrintArr.display(arr);
    }
}

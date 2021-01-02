package sorting_algorithm;

import java.util.Arrays;
import java.util.Random;

public class DataChecker {
    public static void main(String[] args) {
        check();
    }
    public static int[] generateRandomArray() {
        Random r=new Random();
        int arr[]=new int[1000];  //创建一个数组
        for(int i=0;i<arr.length;i++){   //将随机数存储到数组中
            arr[i]=r.nextInt(10000);
        }
        return arr;
    }

    public static void check(){
        int count=0;
        while(count<=1000){
            int arr[]=generateRandomArray();  //系统的算法对着这个算
            int arr1[]=new int[arr.length];  //需将元数组拷贝一份，不然使用的是同一组数据，自己算法
            System.arraycopy(arr,0,arr1,0,arr.length);

            Arrays.sort(arr);
            //SelectionSort.selectSort(arr);
            //SelectionSort.selectSort1(arr);
            BubbleSort.sort(arr1);

            boolean same=true;
            for(int i=0;i<arr1.length;i++){
                if(arr[i] != arr1[i])
                    same=false;
            }
            System.out.println(same == true ? "right" : "wrong");
            count++;
        }
    }
}

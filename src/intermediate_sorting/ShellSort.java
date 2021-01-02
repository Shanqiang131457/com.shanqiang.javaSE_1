package intermediate_sorting;

import util.PrintArr;
import util.Swap;
import util.TimeLog;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr={9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        //sort(arr);
        //sort_1(arr);
        long start= System.currentTimeMillis();
        sort_2(arr);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        print(arr);
    }

    public static void sort_2(int arr[]){  //科学技术方法进行排序
        int h=1;
        while(h<=arr.length/3){
            h=h*3+1;
        }
        for(int gap=h;gap>0;gap=(gap-1)/3){
            for(int i=gap;i<arr.length;i++){
                for(int j=i;j>gap-1;j-=gap){
                   if(arr[j]<arr[j-gap]){
                       int temp=arr[j];
                       arr[j]=arr[j-gap];
                       arr[j-gap]=temp;
                   }
                }
            }
        }
    }

    static void sort_1(int arr[]){  //按数组的一半间隔进行排序
        for(int h=arr.length >>1;h>0;h/=2){   //间隔不断变化
            for(int i=h;i<arr.length;i++){  //按间隔比较
                for(int j=i;j>h-1;j-=h){
                    if(arr[j]<arr[j-h]){
                        swap(arr,j,j-h);
                    }
                }
            }
        }
    }

    public static void sort(int arr[]){  //按固定间隔进行排序
        for(int h=4;h>0;h/=2){   //间隔不断变化
            for(int i=h;i<arr.length;i++){  //按间隔比较
                for(int j=i;j>h-1;j-=h){
                    if(arr[j]<arr[j-h]){
                        swap(arr,j,j-h);
                    }
                }
            }
        }
    }



    static void swap(int arr[] ,int j,int i){
        Swap.swap(arr,j,i);
    }
    static void print(int arr[]){
        PrintArr.display(arr);
    }
}

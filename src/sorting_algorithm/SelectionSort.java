package sorting_algorithm;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[]={2,13,4,5,1,10,9,76,22};
        selectSort1(arr);
    }
    public static void selectSort(int arr[]){

    }
    public static void selectSort1(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                minPos=arr[j]<arr[minPos] ? j:minPos;
            }
            swap(arr,i,minPos);
        }
        printArr(arr);
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }
    public static void swap(int arr[] ,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

        /*
        for(int i=0;i<arr.length-1;i++){  //-1防止角标越界
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                minPos = arr[j]<arr[minPos] ? j : minPos;
            }
            System.out.println("minPos::"+minPos);
            swap(arr,i,minPos);
            System.out.println("经过第"+i+"次循环之后数组的内容：");
            printArr(arr);
        }

         */

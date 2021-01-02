package simple_sorting;

import util.PrintArr;
import util.Swap;

public class BubbleSort_1 {
    public static void main(String[] args) {
        int [] arr= {3,5,2,8,0,4,7,29,11};
        //sort(arr);
        sort1(arr);
        PrintArr instance = PrintArr.getInstance();
        instance.display(arr);
    }
    private static void sort1(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            boolean sorted=true;
            //System.out.println("第"+(i+1)+"躺：");
            for(int j=0;j<arr.length-1-i;j++){
                //System.out.println("第"+(j+1)+"次排序结果：");
                if(arr[j]>arr[j+1]){
                    Swap instance = Swap.getInstance();
                    instance.swap(arr,j,j+1);
                    sorted=false;
                }
            }
            if(sorted){
                break;
            }
        }
    }
    private static void sort(int arr[]){
        for(int i=0;i<arr.length-1;i++){  //每次循环，确定一个相对大大额数
            boolean flag=false;  //交换标志位
            for(int j=1;j<arr.length-i;j++){  //记住第几次交换
                if(arr[j-1]>arr[j]){   //如果前者大于后者，开始交换位置
                    Swap instance = Swap.getInstance();
                    instance.swap(arr,j-1,j);
                    flag=true;
                }
            }
            System.out.println("第"+(i+1)+"次排序结果：");
            PrintArr printArr = PrintArr.getInstance();
            printArr.display(arr);
            if(!flag){
                break;
            }
        }
    }
}

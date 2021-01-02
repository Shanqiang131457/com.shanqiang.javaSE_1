package simple_sorting;

import util.PrintArr;
import util.Swap;

public class InsertSort_1 {
    public static void main(String[] args) {
        int arr[]={9,3,1,4,6,8,7,5,2,0};
        sortPlus(arr);
        print(arr);
    }
    static void sortPlus(int arr[]){  //去掉swap
        for(int i=1;i<arr.length;i++){  //抽取第i张牌
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];  //定义一个存储变量存储需要比较牌
                    arr[j]=arr[j-1];   //调换位置，将比i大的牌一次往后挪；
                    arr[j-1]=temp;
                }
            }
        }
    }

    static void print(int arr[]){
        PrintArr.display(arr);
    }
}

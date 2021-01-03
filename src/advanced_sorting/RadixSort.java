package advanced_sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[]={421,240,115,532,9099,102,98299,305,430,124};
        int number = getNumber(arr);  //获取数组中最大值是几位数，将数值传入到排序中
        int[] result=sort(arr,number);
        System.out.println(Arrays.toString(result));
        //System.out.println(number);
    }
    static int[] sort(int arr[],int number){
        //1,创建结果数组，最后对原数组进行倒序遍历
        int result[]=new int[arr.length];
        //2，获取数组中的最大值和最小值，（最大值-最小值）+1=count[]数组的长度
        int max=arr[0];
        int min=arr[0];
        for(int i=1;i<arr.length;i++){  //遍历数组，获取最大值与最小值
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int d=max-min;
        int[] count=new int[d+1];  //创建一个count数组，计数
        //3，求数组中的每个数据的余数
        for(int i=0;i<number;i++){   //求余数
            int division=(int)Math.pow(10,i);
            //System.out.println(division);
            for(int j=0;j<arr.length;j++){
                int num = arr[j]/division % 10;
                //System.out.println(num+" ");
                count[num]++;
            }
            //System.out.println();
            //System.out.println(Arrays.toString(count));
            //4，累加数组，计数排序
            for(int m=1;m< count.length;m++){   //累加数组
                count[m]=count[m]+count[m-1];
            }
            //System.out.println(Arrays.toString(count));
            //5,倒着遍历原来的数组
            for(int n=arr.length-1;n>=0;n--){
                int num=arr[n]/division %10;
                result[--count[num]]=arr[n];
            }
            //6,拷贝结果数组
            System.arraycopy(result,0,arr,0,arr.length);
            Arrays.fill(count,0);
        }

        return arr;
    }
    static int getNumber(int arr[]){  //获取数组中最大值是几位数
        int max=arr[0];
        for(int i=1;i<arr.length;i++){  //遍历数组，求出最大值
            if(arr[i] > max){
                max=arr[i];
            }
            //System.out.println(max);
        }
        String str=String.valueOf(max);  //将int类型的数组转为String类型，然后获取长度
        int count=str.length();
        return count;
    }
}

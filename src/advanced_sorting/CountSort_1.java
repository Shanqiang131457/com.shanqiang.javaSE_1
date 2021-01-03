package advanced_sorting;

import java.util.Arrays;

//计数排序优化
public class CountSort_1 {
    public static void main(String[] args) {
        int arr[]={95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.println("原数组："+Arrays.toString(arr));
        int[] result = countSort(arr);
        System.out.println("新数组："+Arrays.toString(result));
    }

    static int[] countSort(int arr[]){
        //1,得到数列中的最大值与最小值，并算出差值d;
        //刚开始并不知道原数组0角标的数值为最大值还是最小值，假设最小值和最大值都是这个角标的元素
        int max=arr[0];
        int min=arr[0];
        for(int i=1;i<arr.length;i++){  //遍历数组求出最大值与最小值
            if(arr[i]>max){   //求出最大值
                max=arr[i];
            }
            if(arr[i]<min){  //求出最小值
                min=arr[i];
            }
            //System.out.println("max="+max+"\tmin="+min);
        }

        int d=max-min;  //求出最大值与最小值的差值，这个作为数组的长度+1,这个为统计数组的长度；
        //2，创建统计数组并计算统计对应的元素
        int count[]=new int[d+1];   //统计数组的长度值
        for(int i=0;i<arr.length;i++){
            count[arr[i]-min]++;   //元数组数据-最小值得到统计数组的角标值，求出相同值角标的个数，计数
        }
        //3，统计数组变形，后面的元素等于前面的元素之和
        int sum=0;  //计数相同数据不同的角标位置，++；
        for(int i=0;i<count.length;i++){
            sum += count[i];
            count[i] = sum;
        }
        //4,倒序的遍历原始数组，从统计数组找到正确的位置，输出到结果到新的数组
        int result[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            result[count[arr[i]-min]-1]=arr[i];
            count[arr[i]-min]--;
        }
        return result;
    }
}

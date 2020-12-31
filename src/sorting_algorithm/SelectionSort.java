package sorting_algorithm;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[]={2,13,4,5,1,10,9,76,22,34};
        //selectSort(arr);
        betterSelectSort(arr);
    }

    public static void betterSelectSort(int arr[]){  //优化代码，循环的时候分别超出最大值与最小值，查询速度快了一半
        //left指针指向无需边界起点，right指针指向终点，temp用作临时交换变量的值；
        int left,right,temp;
        //默认指向无序列表起点,角标位置
        left=0;
        //默认指向无序列表终点
        right=arr.length-1;
        //记录每轮找到最小值的下标
        int minPos=left;
        //记录每轮找到的最大值下标
        int maxPos=right;
        //当right>=left时，列表已经有序
        //记录循环次数
        int count=0;
        while(left<right){
            minPos=left;//每轮开始之前，默认是无序列表起点为最值
            maxPos=right;//每轮开始之前，默认是无序列表起点为最大值
            //指针i从左往右扫描，找出最小值，最大值
            for(int i=left;i<right;i++){
                minPos = arr[i]<arr[minPos] ? i:minPos;
                maxPos = arr[i]>arr[maxPos] ? i:maxPos;
               //if(arr[i]<arr[minPos]) {//通过比较，记录最小值的下标
                    //minPos = i;
                //}
                //if(arr[i]>arr[maxPos]){ //通过比较，记录最大值的下标
                    //maxPos=i;
                //}
            }

            count++;  //记录次数

            if(minPos == left && maxPos == right){
                System.out.println("第"+count+"轮值循环没有找到最值，无需交换");
            }else if(minPos == right && maxPos == left){
                //交换一次即可，交换两次的话，序列翻转相当于没有交换
                swap(arr,left,minPos);
                //temp=arr[left];
                //arr[left]=arr[minPos];
                //arr[minPos]=temp;
            }else{
                swap(arr,left,minPos);
                swap(arr,right,maxPos);
                /*
                //找出最小值，交换
                temp=arr[left];
                arr[left]=arr[minPos];
                arr[minPos]=temp;

                //找出最大值，交换
                temp=arr[right];
                arr[right]=arr[maxPos];
                arr[maxPos]=temp;

                 */
            }
            left++;
            right--;
        }
        printArr(arr);
    }

    public static void selectSort(int arr[]){  //普通选择排序代码，但是添加了哨兵
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minPos=i;
            //哨兵 ，记录是否找到最值，默认false
            boolean flag=false;
            for(int j=i+1;j<arr.length;j++){
               if(min<arr[j]){
                   min=arr[j];
                   minPos=j;
                   //找到最小值，设置为true；
                   flag=true;
               }
            }
            if(flag){
                arr[minPos]=arr[i];
                arr[i]=min;
            }
        }
        printArr(arr);
    }

    public static void selectSort1(int arr[]){  //普通选择排序代码
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

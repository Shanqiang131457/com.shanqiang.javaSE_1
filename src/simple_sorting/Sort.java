package simple_sorting;

public class Sort {
    public static void main(String[] args) {
        int[] arr={9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        display(arr);
        //selectSort(arr);
        //insertSort(arr);
        bubbleSort(arr);
        display(arr);
    }

    static void bubbleSort(int arr[]){  //冒泡排序，时间复杂度:O(N^2)  空间复杂度：O（1） 稳定情况：稳定   比较方式：相邻的数据进行比较
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    static void insertSort(int arr[]){ //插入排序，时间复杂度：O(N^1.3)  空间复杂度：O(1)  稳定情况：稳定  比较方式：通过插牌方式，拿j的数据与j-1数据进行比较
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]>arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }

    static void selectSort(int arr[]){  //选择排序，时间复杂度 O(N^2)  空间复杂度：O(1)  稳定情况：不稳定    比较方式：通过将0角标元素假设为最小值或者最大值，与第二个元素进行比较
        for(int i=0;i<arr.length-1;i++){  //外行控制次数
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){   //内行进行比较
                minPos = arr[j]<arr[minPos] ? j:minPos;
            }
            swap(arr,i,minPos);
        }
    }

    static void swap(int arr[],int i,int j){  //元素交换方式，定义第三方变量存储需要比较的值
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void display(int[] arr){  //打印数组元素
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]+"}");
        }
    }
}

package advanced_sorting;

public class QuickSort {
    public static void main(String[] args) {
        int arr[]={7,6,3,2,8,6,1,6,9,10,5,4,6,0};
        sort(arr,0,arr.length-1);
        print(arr);
    }

    static void sort(int arr[],int leftBound,int rightBound){
        if(leftBound>=rightBound){
            return ;
        }
        int mid=partition(arr,leftBound,rightBound);
        sort(arr,leftBound,mid-1);
        sort(arr,mid+1,rightBound);
    }

    static int partition(int arr[],int leftBound,int rightBound){
        int pivot=arr[rightBound];  //轴,数组最后一个位置
        int left=leftBound;  //左边第一个位置
        int right=rightBound-1;  //右边第一个位置    ==arr.length-1-1;
        while(left <= right){

            while (left <= right && arr[left] <= pivot){
                left++;
            }

            while(left <= right && arr[right] > pivot){
                right--;
            }

            //System.out.println("left="+left+"\t right="+right);

            if(left<=right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            //print(arr);
        }
        swap(arr,left,rightBound);

        return left;
    }

    static void swap(int arr[],int j,int i){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void print(int arr[]){
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]+"}");
        }
    }
}

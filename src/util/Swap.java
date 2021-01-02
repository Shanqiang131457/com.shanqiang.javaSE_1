package util;

public class Swap {
    private static final Swap INSTANCE=new Swap();

    private Swap(){};

    public static Swap getInstance(){
        return INSTANCE;
    }
     //交换数组中的位置
    public  static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

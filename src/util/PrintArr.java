package util;

public class PrintArr {
    private static final PrintArr INSTANCE=new PrintArr();

    private PrintArr(){}

    public static  PrintArr getInstance(){
        return INSTANCE;
    }

    //打印每次排序后的数组元素
    public static void display(int[] arr){
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.println(arr[i]+"}");
        }
    }
}

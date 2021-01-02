package intermediate_sorting;

public class Main {
    public static void main(String[] args) {
        int[] arr={9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        long startTime=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            //ShellSort.sort_2(arr);
            ShellSort.sort_1(arr);
        }
        long endTime=System.currentTimeMillis();
        long time=endTime-startTime;
        System.out.println(time);
    }
}

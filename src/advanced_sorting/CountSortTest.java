package advanced_sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CountSortTest {
    int[] generateRandomArray(){  //匿名内部类
        Random r=new Random();   //产生随机数对象

        int[] arr=new int[10000];  //创建一个int类型的数组，数组的长度为10000；

        for(int i=0;i<arr.length;i++){  //通过遍历的方式，将随机10个数字存储到数组中
            arr[i]=r.nextInt(10);
        }

        return arr;
    }

    @Test
    public void testSort(){
        int a[]=generateRandomArray();  //将元数组拷贝到一个新的数组中
        int result[]=CountSort.sort(a);   //将随机数组使用自己写的计数排序进行排序
        Arrays.sort(a);  //使用系统自带的方式进行排序
        boolean same=true;
        for(int i=0;i<a.length;i++){
            if(result[i] != a[i]){
                same=false;
            }
        }

        assertEquals(true,same);
    }
}

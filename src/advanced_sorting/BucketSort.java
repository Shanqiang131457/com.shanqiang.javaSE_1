package advanced_sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//桶排序
public class BucketSort {
    public static void main(String[] args) {
        //1，输入元素均在[0，10)这个区间内
        float arr[]={0.12f,2.2f,8.8f,7.6f,7.2f,7.3f,9.0f,1.6f,5.6f,2.4f};
        bucketSort(arr);
        printArray(arr);
    }

    static void bucketSort(float arr[]){
        //1，新建一个桶的集合
        ArrayList<LinkedList<Float>> buckets=new ArrayList<LinkedList<Float>>();
        for(int i=0;i<10;i++){
            //新建一个桶放在桶的集合中去
            //由于桶内的元素回频繁的插入，所以选择linkedList,作为桶的数据结构
            buckets.add(new LinkedList<Float>());
        }
        //将输入数据全部放入桶中并完成排序
        for (float data: arr) {
            int index=getBucketIndex(data);
            insertSort(buckets.get(index),data);
        }
        //将桶中元素全部取出来并放入arr中输出
        int index=0;
        for(LinkedList<Float> bucket: buckets){
            for(Float data : bucket){
                arr[index++] = data;
            }
        }
    }

    //计算得到输入元素应该放在那个桶内
    static int getBucketIndex(float data){
        //这里的例子比较淡淡，仅使用浮点数的整数部分作为桶的索引值
        //实际开发中需要根据场景具体设计
        return (int) data;
    }

    //我们选择插入排序作为桶内元素的排序方法，每当有一个元素到来时，我们都用这个方法将其插入恰当的位置
    static void insertSort(List<Float> bucket, float data){
        ListIterator<Float> fit = bucket.listIterator();
        boolean insertFlag=true;
        while(fit.hasNext()){
            if(data<=fit.next()){
                fit.previous();  //把迭代器的位置便宜上一个位置
                fit.add(data);   //把数据插入到迭代器当前的位置
                insertFlag=false;
                break;
            }
        }
        if(insertFlag){
            bucket.add(data);  //否则把数据插入到链表末端
        }
    }
    //打印数组
    static void printArray(float[] arr){
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1){
                System.out.print(arr[i]+",");
            }else{
                System.out.println(arr[i]+"}");
            }
        }
    }
}

package advanced_sorting;

import java.util.Arrays;

/**
* 基数排序LSD模式，排序字符串
*
 * @param 'array'原数组
 * @return 排序后的数组
* */
public class RadixSort_1 {
    public static void main(String[] args) {
        //String[] array={"shanqinag","liupinabc","qinyonfen","jiangwenq"};
        String[] array={"s","a"};
        String[] strings = radixSort(array);
        printArray(strings);


    }

    //ascii码的取值范围
    private static final int ASCII_RANGE=128;
    static String[] radixSort_1(String[] arr){
       //元素最长位数
       int maxLength=0;
       for(int i=0;i<arr.length;i++){   //遍历字符串数组最长的字符串
           if(arr[i].length()>maxLength){
               maxLength=arr[i].length();
           }
       }

       //排序结果数组
        String[] sortedArr=new String[arr.length];

      //从个位开始比较，一直比较到最高位
      for(int k=maxLength-1;k>=0;k--){
          int[] countArr=new int[ASCII_RANGE];
          for(int i=0;i<arr.length;i++){
              int index=getCharIndex(arr[i],k);
              countArr[index]++;
          }
          //统计数组变化
          int sum=0;
          for(int i=0;i<countArr.length;i++){
              sum += countArr[i];
              countArr[i]=sum;
          }

          //倒序遍历原始序列，进行排序
          for(int i=arr.length-1;i>=0;i--){
              int index=getCharIndex(arr[i],k);
              sortedArr[countArr[index]-1]=arr[i];
              countArr[index]--;
          }

          //把每一轮的结果复制给arr
          arr=sortedArr.clone();
      }
      return arr;
    }
    //获取字符串第k位字符所对应的ascii码序号
    private static int getCharIndex(String str,int k){
        //w位数不足的位置补0
        if(str.length()<k+1){
            return 0;
        }
        return str.charAt(k);
    }

    static String[] radixSort(String[] array){  //有问题
        //结果数组resultArray

        String[] resultArray=new String[array.length];

        //计数数组
        int[] countArray=new int[10];

        //找出最大数的位数是多少位
        int numberSize=1;
        for(int i=0;i<array.length;i++){
            int size=array[i].length();
            if(size > numberSize){
                numberSize=size;
            }
            System.out.println("numbersize="+numberSize);
        }


        //循环最大数的位数次
        for(int i=numberSize-1;i>=0;i--){

            for(int j=0;i<array.length;j++){//将数组放到计数数组中
                int num=array[j].charAt(i);
                countArray[num]++;    //countArray[77],
            }

            for(int j=1;j<countArray.length;j++){  //将计数数组放到累积数组中
                countArray[j]=countArray[j]+countArray[j-1];
            }

            for(int k = array.length-1; k >= 0 ;k--){   //将累加数组放入到结果数组中，并且倒序遍历
                int num=array[k].charAt(i);
               //resultArray[--countArray[num]]=array[k];
                resultArray[countArray[num]-1]=array[k];
                countArray[num]--;
            }

            //将结果拷贝到原数组中
            System.arraycopy(resultArray,0,array,0,resultArray.length);
            //每循环一次将统计数组清空
            Arrays.fill(countArray,0);
        }
        return resultArray;
    }
    static void printArray(String[] array){
        System.out.print("{");
        for(int i=0;i<array.length;i++){
            if(i != array.length-1){
                System.out.print(array[i]+",");
            }else{
                System.out.println(array[i]+"}");
            }
        }
    }
}

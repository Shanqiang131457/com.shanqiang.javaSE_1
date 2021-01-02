package util;

public class TimeLog {
    private static final TimeLog INSTANCE=new TimeLog();

    private TimeLog(){};

    public static TimeLog getInstance(){
        return INSTANCE;
    }

    public static long beforeTime(){   //开始时间
        long start=System.currentTimeMillis();
        return start;
    }
   public static  long afterTime(){  //结束时间
        long end=System.currentTimeMillis();
        return end;
    }

}

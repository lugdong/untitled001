package dong.Threadprocon;

import java.util.concurrent.locks.Lock;

public class Desk {
    public static int count=10;  //最多执行多少次
    public static int isfood=0;  //是否有可消费数据

    public static Object obj_lock=new Object();  //锁对象

}

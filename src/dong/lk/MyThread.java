package dong.lk;

public class MyThread  extends Thread{

    @Override
    public void run() {
        for (int i=0;i<10;i++)
        System.out.println("mythread进程"+Thread.currentThread().getName());
    }
}

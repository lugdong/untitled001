package dong.lk;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程："+Thread.currentThread().getName());
        return Thread.currentThread().getName()+"执行完成";
    }
}

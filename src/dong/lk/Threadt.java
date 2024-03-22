package dong.lk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Threadt {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      /*  MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread1.start();
        myThread.start();
          */

        MyCallable myCallable = new MyCallable();

        FutureTask<String> stringFutureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(stringFutureTask);
        thread.start();
        String name = stringFutureTask.get();
        System.out.println(name);
        for (int i = 0; i < 10; i++) {
            
        }

    }
}

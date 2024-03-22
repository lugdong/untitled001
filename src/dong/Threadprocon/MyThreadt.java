package dong.Threadprocon;

public class MyThreadt {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();

        Thread t1 = new Thread(consumer,"消费者");
        Thread t2= new Thread(producer, "生产者");
        t1.start();
        t2.start();


    }
}

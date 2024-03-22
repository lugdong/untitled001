package dong.Threadprocon;

public class Producer implements Runnable{

    @Override
    public void run() {
        while (true){
            synchronized (Desk.obj_lock){
                if (Desk.count==0){
                    break;
                }
                if(Desk.isfood==0){
                      Desk.isfood=1;
                    System.out.println("可生产次数："+Desk.count+"，食物目前剩余："+Desk.isfood);
                    Desk.obj_lock.notify();
                }   else {
                    try {
                        Desk.obj_lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}

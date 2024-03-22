package dong.Threadprocon;


  //consumer
public class Consumer implements Runnable{
    @Override
    public void run() {
        while (true)
        synchronized (Desk.obj_lock){
        if(Desk.count==0) {
            break;            //如果没有次数了，就退出
        }  else {
            if(Desk.isfood==1) {   //如果可以继续吃
                Desk.count--;        //可用次数减一
                System.out.println("还可以吃:" + Desk.count + "次"+"食物目前剩余:"+Desk.isfood);
                Desk.isfood=0;         //食物减一
                Desk.obj_lock.notify();  //通知/唤醒 生产者
            }else {
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


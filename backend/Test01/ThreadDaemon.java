package backend.Test01;


class MyThread1 extends Thread{
@Override
public void run() {
        for(long
        i=0;
        i<1000000000L;
        i++) { }
        }
        }
class MyThread2 extends Thread{
    MyThread1 myThread1;
    public MyThread2(MyThread1 myThread1) {
        this.myThread1=myThread1;
    }
    @Override
    public void run() {
        try { myThread1.join(3000); }
        catch (InterruptedException e) {
            System.out.println(" --join() 중 interrupt 발생--");
        }
        for(long
            i=0;
            i<1000000000L;
            i++) { }
    }
}
public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2(myThread1);
        myThread1.start();
        System.out.println("MyThread1 Start State : " + myThread1.getState()); //RUNNABLE
        System.out.println("MyThread2 Start State : " + myThread2.getState());
        myThread2.start();
        System.out.println("MyThread1 2_Start State : " + myThread1.getState()); //RUNNABLE
        System.out.println("MyThread2 2_Start State : " + myThread2.getState());
        myThread2.interrupt();
        myThread2.sleep(100); //시간지연

        System.out.println("MyThread1 State : " + myThread1.getState()); //RUNNABLE
        System.out.println("MyThread2 State : " + myThread2.getState()); //TIMED_WAITING
//        myThread2.interrupt();


    }
}

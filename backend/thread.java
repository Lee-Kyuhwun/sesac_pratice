package backend;

public class thread {
    public static void main(String[] args) {
        Thread.State state;

        Thread thread = new Thread(){
            @Override
            public void run(){
                for(long i =0 ;i<100000000L; i++) {}
            }
        };

        state = thread.getState();
        System.out.println("state = " + state);

        thread.start();
        state = thread.getState();
        System.out.println("state = " + state);

        try {
            thread.join();
            state = thread.getState();
            System.out.println("state = " + state);
        }catch (InterruptedException e){
            state = thread.getState();
            System.out.println("state = " + state);
        }

    }
}

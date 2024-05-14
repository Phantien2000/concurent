package test;

public class App {
    public static void main( String[] args ) {
        Thread[] subThreads = new Thread[5];

        Thread mainThread = Thread.currentThread();
        System.out.println("Main thread's name:" + mainThread.getName());

        for(int i=0; i<subThreads.length; i++) {
            subThreads[i] = new SimpleThread(i);
        }

        System.out.println("Start sub-threads:");
        for(int i=0; i<subThreads.length; i++) {
            subThreads[i].start();
        }

        System.out.println("Main thread has been done!");
    }
}

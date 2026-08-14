package com.java.problem.multithreading.volatileExample;

public class VolatileExample {
    //Declaring the flag as volatile ensures that changes to 'running'
    //in one thread are immediately visible to other threads
    private volatile boolean running = true;

    //Method executed by the worker thread
    public void runTask(){
        System.out.println("WorkerThread : starting execution...");
        int counter = 0;

        while (running){
            counter+=1;
        }

        System.out.println("WorkerThread : Detected stop signal. Final counter value:"+ counter);
    }

    //called by the main thread to stop the worker thread
    public void stopTask(){
        running = false;
    }

    public static void main(String [] args){
        VolatileExample volatileExample = new VolatileExample();

        Thread workerThread = new Thread(()->{
           volatileExample.runTask();
        },"WorkerThread");
        workerThread.start();

        try {
            Thread.sleep(2000); //Main thread sleeps for 2sec
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Mainthread : stopping the worker thread");
        volatileExample.stopTask(); //signal the worker thread to stop

        //wait for worker thread to finish execution
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Multithread execution finished");
    }
}

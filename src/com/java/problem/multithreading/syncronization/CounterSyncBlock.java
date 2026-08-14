package com.java.problem.multithreading.syncronization;

public class CounterSyncBlock {
    private int count = 0;

    //Explicit lock object for finer control
    private final Object lock = new Object();

    public void increment(){
        //Non critical part runs without locking
        System.out.println("Non synchronized part (pre-processing): "+ Thread.currentThread().getName());

        synchronized (lock){
            System.out.println("Synchronized block - start increment:"+ Thread.currentThread().getName());
            count+=1;
            System.out.println("Synchronized block - Counter value after increment: "+count);
            System.out.println("Synchronized block - End increment:" + Thread.currentThread().getName());
        }

        System.out.println("Non synchronized part (post-processing):"+ Thread.currentThread().getName());
    }

    public int getCount(){
        return count;
    }

    public static void main(String [] args){
        CounterSyncBlock counter = new CounterSyncBlock();
        int numberOfThreads = 5;

        Thread[] threads = new Thread[numberOfThreads];
        for (int i=0; i<numberOfThreads; i+=1){
            threads[i] = new Thread(()->{
                counter.increment();
            }, "Thread-"+(i+1));

            threads[i].start();
        }

        for (int i=0; i<numberOfThreads; i+=1){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Final counter value: "+counter.getCount());
    }
}

package com.java.problem.multithreading.syncronization;

public class SynchronizedMethod {
    private int count = 0;

    public synchronized void increment(){
        System.out.println("Synchronized method - start increment: "+ Thread.currentThread().getName());

        //Critical section updating shared counter
        count+=1;
        System.out.println("Synchronized method - Counter value after increment: "+count);
        System.out.println("Synchronized method - End increment: "+ Thread.currentThread().getName());
    }

    public int getCount(){
        return  count;
    }

    public static void main(String [] args){
        SynchronizedMethod synchronizedMethod = new SynchronizedMethod();
        int numberOfThreads = 3;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i=0; i<numberOfThreads; i+=1){
            threads[i] = new Thread(()->{
                synchronizedMethod.increment();
            }, "Thread-"+(i+1));

            threads[i].start();
        }

        //wait for all threads to complete
        for (int i=0; i<numberOfThreads; i+=1){
            try{
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final counter value: "+synchronizedMethod.getCount());
    }
}

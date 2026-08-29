package com.java.problem.multithreading.atmoicExample;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {
    //AtomicInteger counter provides atomic methods for thread safe operations
    private final AtomicInteger counter = new AtomicInteger(0);

    //This method atomically increments the counter and prints updated value
    public void increment(){
        int newValue = counter.incrementAndGet(); // Atomically increments by one and returns the new value
        System.out.println(Thread.currentThread().getName() + " incremented counter to: "+ newValue);
    }

    public int getCounter(){
        return counter.get();
    }

    public static void main(String [] args){
        final AtomicCounterExample counter = new AtomicCounterExample();
        int numberOfThreads = 10;

        //Each thread will perform 100 increments
        int incrementPerThread = 100;

        Thread[] threads = new Thread[numberOfThreads];
        for (int i=0; i<numberOfThreads; i+=1){
            threads[i] = new Thread(()->{
                for (int j=0; j<incrementPerThread; j+=1){
                    counter.increment();
                }
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

        System.out.println("Final counter value: "+ counter.getCounter());
    }
}

package com.java.problem.multithreading.threadSafeCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    public static void main(String [] args){
        AtomicInteger counter = new AtomicInteger(0);

        Runnable incrementTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000; i+=1){
                    counter.incrementAndGet();
                }
            }
        };

        Runnable decrementTask = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000; i+=1){
                    counter.decrementAndGet();
                }
            }
        };

        Thread increment = new Thread(incrementTask);
        Thread decrement = new Thread(decrementTask);

        increment.start();
        decrement.start();

        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final counter value: "+counter.get());
    }
}

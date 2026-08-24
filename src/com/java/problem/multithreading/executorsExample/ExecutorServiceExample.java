package com.java.problem.multithreading.executorsExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String [] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        executorService.execute(()->{
//            System.out.println("Task 1 is executing by "+ Thread.currentThread().getName());
//        });
//
//        executorService.execute(()->{
//            System.out.println("Task 2 is executing by "+ Thread.currentThread().getName());
//        });
//
//        executorService.execute(()->{
//            System.out.println("Task 3 is executing by "+ Thread.currentThread().getName());
//        });

        for(int i=1; i<=100; i+=1){
            executorService.execute(()->{
                System.out.println("Task is executing by "+ Thread.currentThread().getName());
            });
        }
//        System.out.println("Main thread continues");
    }
}

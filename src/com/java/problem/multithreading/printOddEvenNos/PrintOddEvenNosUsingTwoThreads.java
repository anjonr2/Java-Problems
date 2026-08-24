package com.java.problem.multithreading.printOddEvenNos;

public class PrintOddEvenNosUsingTwoThreads {
    public static void main(String []args){
        Thread evenThread = new Thread(()->{
            for (int i=1; i<=100; i+=1){
                if(i % 2 ==0){
                    System.out.println(" "+i);
                }
            }
        }, "evenThread");

        Thread oddThread = new Thread(()->{
            for (int i=1; i<=100; i+=1){
                if(i % 2 !=0){
                    System.out.println(" "+i);
                }
            }
        }, "oddThread");

        evenThread.start();
        oddThread.start();
    }
}

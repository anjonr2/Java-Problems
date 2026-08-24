package com.java.problem.multithreading.printOddEvenNos;

/*
Print numbers from 1 to 30 in order. Odd numbers and even numbers should be printed
in two different threads
 */

public class OddEvenNoPrintImpl {
    public static void main(String [] args){
        Thread odd = new Thread(()->{
            //print only odd numbers from 1 to 30
            for (int i=1; i<=29; i+=2){
                System.out.println("Odd Thread: "+i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Odd Thread");

        Thread even = new Thread(()->{
            //Prints even numbers from 2 to 30
            for (int i=2; i<=30; i+=2){
                System.out.println("Even Thread: "+i);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Even Thread");

        odd.start();

        /* Thread.sleep() method is called so that after odd thread starts , then only even thread starts */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        even.start();
    }
}

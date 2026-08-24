package com.java.problem.multithreading.threadCreation;

public class ExtendingThreadClassDemo {
    public static void main(String [] args){
        MyThread t1= new MyThread();
        t1.start();

        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start();

        Thread t3 = new Thread(()->System.out.println("Thread is running"));
        t3.start();
    }
}

//Thread class Extend
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running");
    }
}

//Thread using Runnable interface
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}
/*
t1.start() ---> JVM asks OS to create a new thread ---> Thread gets stack space and program counter
t1.start() ---> internally calls run method and executes the code inside run method
Thread t1 is executed by CPU
 */
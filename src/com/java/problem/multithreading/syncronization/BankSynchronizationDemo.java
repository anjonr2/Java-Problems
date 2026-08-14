package com.java.problem.multithreading.syncronization;

public class BankSynchronizationDemo {
    private double balance;

    public BankSynchronizationDemo(double intialBalance){
        this.balance = intialBalance;
    }

    public void deposit(double amount){
        double newBalance = balance + amount;
        System.out.println("Thread "+ Thread.currentThread().getName() + " is running with updated balance : "+newBalance);
        //simulating some processing time for deposit operation
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();;
        }

        balance = newBalance;
    }

    public void withdraw(double amount){

        if(balance>=amount){
            double newBalance = balance - amount;
            System.out.println("Thread "+ Thread.currentThread().getName() + " is running with updated balance : "+newBalance);
            //Simulating some processing time for withdraw operation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            balance = newBalance;
        }
    }

    public synchronized void synchronizedDeposit(double amount){
        double newBalance = balance + amount;
        System.out.println("Thread "+ Thread.currentThread().getName() + " is running with updated balance : "+newBalance);
        //simulating some processing time for deposit operation
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();;
        }

        balance = newBalance;

        System.out.println(Thread.currentThread().getName()+ "is running with updated balance "+ balance);
    }

    public synchronized void synchronizedWithdraw(double amount){

        if(balance>=amount){
            double newBalance = balance - amount;
            System.out.println("Thread "+ Thread.currentThread().getName() + " is running with updated balance : "+newBalance);
            //Simulating some processing time for withdraw operation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            balance = newBalance;

            System.out.println(Thread.currentThread().getName()+ "is running with updated balance "+ balance);
        }
    }

    public double getBalance(){
        return balance;
    }

    //Simulating a scenario where multiple threads trying to withdraw and deposit
    //money into same bank account concurrently
    public static void main(String [] args){
        BankSynchronizationDemo bankAccount = new BankSynchronizationDemo(100);

        Thread deposit1 = new Thread(()->{
           bankAccount.synchronizedDeposit(40);
        },"deposit1");

        Thread deposit2 = new Thread(()->{
            bankAccount.synchronizedDeposit(50);
        },"deposit2");

        Thread withdraw1 = new Thread(()->{
            bankAccount.synchronizedWithdraw(30);
        }, "withdraw1");

        Thread withdraw2 = new Thread(()->{
            bankAccount.synchronizedWithdraw(50);
        },"withdraw2");

        deposit1.start();;
        deposit2.start();
        withdraw1.start();
        withdraw2.start();

        try {
            deposit1.join();
            deposit2.join();
            withdraw1.join();
            withdraw2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final balance "+bankAccount.getBalance());
    }
}

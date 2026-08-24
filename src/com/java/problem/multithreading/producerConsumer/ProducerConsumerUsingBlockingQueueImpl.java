package com.java.problem.multithreading.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingBlockingQueueImpl {
    public static void main(String[] args){
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(()->{
            for (int i=1; i<=10; i+=1){
                try{
                    queue.put(i);

                    System.out.println("Produced: "+ i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        Thread consumer = new Thread(()->{
            for (int i=1; i<=10; i+=1){
                try{
                  int value = queue.take();

                  System.out.println(" Consumed: "+value);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

/*
Here
queue.put(i)
automatically waits if the queue is full
And queue.take()
automatically waits if the queue is empty

 */
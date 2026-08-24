package com.java.problem.multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImpl {
    static class SharedBuffer{
        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity;

        public SharedBuffer(int capacity){
            this.capacity = capacity;
        }

        public synchronized void produce(int value) throws InterruptedException {
            while (queue.size() == capacity){
                wait();
            }

            queue.offer(value);
            System.out.println(Thread.currentThread().getName() + " produced: "+ value);

            notifyAll();
        }

        public synchronized int consume() throws InterruptedException{
            while (queue.isEmpty()){
                wait();
            }

            int value = queue.poll();

            System.out.println(Thread.currentThread().getName() + " consumed: "+ value);

            notifyAll();

            return value;
        }
    }

    public static void main(String [] args){
        SharedBuffer buffer = new SharedBuffer(5);

        Thread producer = new Thread(()->{
            for (int i=1; i<=10; i+=1){
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "Producer");

        Thread consumer = new Thread(()->{
            for (int i=1; i<=10; i+=1){
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}

/*
Code explanation

important part here is

public synchronized void produce(int value)
Because the method is synchronized , the producer thread acquires lock on sharedbuffer object

Then :
while (queue.size() == capacity) {
    wait();
}

if the queue is full, producer waits

What happens internally
Suppose :

capacity = 5

queue = [1,2,3,4,5]

Producer calls :
wait();

The producer :
1. releases SharedBuffer lock
2. enters WAITING state

Now the consumer can acquire the same lock

Consumer executes
int value = queue.poll();

Suppose :
queue = [1,2,3,4,5]

Consumer remvoes
1 from the queue

Now :
queue = [2,3,4,5]

Then
notifyAll() is called by consumer

The producer is notified
It doesn't immediately execute

It must first reacquire the SharedBuffer lock again
Once it gets the lock, it returns from

wait()
and checks the condition again


 */
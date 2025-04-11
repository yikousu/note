package com.algorithm.basic.queue;

import java.util.concurrent.*;

/**
 * 问题背景： 多线程场景下，如果两个线程同时访问同一个队列，容易发生数据竞争。
 * Java 提供了线程安全的队列：BlockingQueue，常用于生产者-消费者模型。
 * 队列满时，put() 会阻塞
 * 队列空时，take() 会阻塞
 * 内部自动加锁，无需手动加锁[ReentrantLock]
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // 生产者线程
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("生产：" + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        };

        // 消费者线程
        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int val = queue.take();
                    System.out.println("消费：" + val);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        };

        new Thread(producer).start();
        new Thread(consumer).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

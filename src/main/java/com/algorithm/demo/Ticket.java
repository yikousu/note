package com.algorithm.demo;

public class Ticket implements Runnable {
    private int tickets = 10;

    public static void main(String[] args) {
        Ticket thread = new Ticket();
        new Thread(thread, "张2").start();
        new Thread(thread, "李四").start();
        new Thread(thread, "王五").start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets <= 0) {
                    break;
                }
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "抢到了第" + tickets-- + "张票");
            }
        }
    }
}
package com.algorithm.basic.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列（Priority Queue） 使用 Java 自带 PriorityQueue
 */

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); // 大顶堆

        pq.offer(5);
        pq.offer(1);
        pq.offer(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // 输出：1 3 5
        }
    }
}

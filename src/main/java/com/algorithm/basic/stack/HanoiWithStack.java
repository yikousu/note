package com.algorithm.basic.stack;

import java.util.Stack;

public class HanoiWithStack {
    public static void main(String[] args) {
        int n = 3; // 盘子的数量
        Stack<Integer> source = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();
        Stack<Integer> target = new Stack<>();

        // 初始化源柱子：从大到小放入盘子
        for (int i = n; i >= 1; i--) {
            source.push(i);
        }

        // 打印初始状态
        printTowers(source, auxiliary, target);

        // 开始移动
        move(n, source, auxiliary, target, "A", "B", "C");

        // 打印最终状态
        printTowers(source, auxiliary, target);
    }

    /**
     * 递归移动汉诺塔
     */
    public static void move(int n, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target,
                            String sourceName, String auxiliaryName, String targetName) {
        if (n == 1) {
            int disk = source.pop();
            target.push(disk);
            System.out.printf("Move disk %d from %s to %s\n", disk, sourceName, targetName);
            return;
        }
        move(n - 1, source, target, auxiliary, sourceName, targetName, auxiliaryName);
        move(1, source, auxiliary, target, sourceName, auxiliaryName, targetName);
        move(n - 1, auxiliary, source, target, auxiliaryName, sourceName, targetName);
    }

    /**
     * 打印当前柱子的状态
     */
    public static void printTowers(Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target) {
        System.out.println("A: " + source);
        System.out.println("B: " + auxiliary);
        System.out.println("C: " + target);
        System.out.println("--------------");
    }
}

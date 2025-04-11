package com.algorithm.basic.stack;

/**
 * 汉诺塔（Tower of Hanoi）
 * <p>
 * 有三根柱子：A、B、C。
 * 在柱子 A 上按从大到小叠放着若干个圆盘（最底下最大，最上面最小）。
 * 现在要把所有盘子从柱子 A 移动到柱子 C，但必须遵守以下规则：
 * 一次只能移动一个盘子；
 * 任何时候都不能将大盘子放在小盘子上；
 * 借助中间柱子 B 作为辅助。
 */

public class Hanoi {
    /**
     * n：表示需要移动的盘子数量。
     * from：表示起始柱子的名称。
     * via：表示中间柱子的名称。
     * to：表示目标柱子的名称。
     */
    public static void move(int n, String from, String via, String to) {
        if (n == 1) {
            System.out.println("将圆盘 1 从 " + from + " 移动到 " + to);
        } else {
            // 将上面的 n - 1 个盘子从起始柱子借助目标柱子移动到中间柱子。
            move(n - 1, from, to, via);
            System.out.println("将圆盘 " + n + " 从 " + from + " 移动到 " + to);
            // 将之前移动到中间柱子的 n - 1 个盘子借助起始柱子移动到目标柱子。
            move(n - 1, via, from, to);
        }
    }

    public static void main(String[] args) {
        int n = 3; // 盘子的数量
        move(n, "A", "B", "C");
    }
}
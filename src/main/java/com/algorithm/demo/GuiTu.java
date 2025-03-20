package com.algorithm.demo;

// 模拟龟兔赛跑
public class GuiTu implements Runnable {
    private static String winner;

    // 判断游戏结束
    public static boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName();// 跑到终点了要更新winner
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GuiTu race = new GuiTu();
        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 判断游戏结束？
            boolean flag = gameOver(i);
            if (flag) {
                return;
            }
            // 模拟兔子睡觉   只睡几次
            if (Thread.currentThread().getName().equals("兔子") && (i % 30) == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 输出
            String name = Thread.currentThread().getName();
            System.out.println(name + "--->跑了" + i + "步");
        }
    }
}

package com.algorithm.hot100;

import java.util.Stack;

/**
 * @author hac
 * @date 2024/11/28 17:26
 */
public class T394 {


    public static void main(String[] args) {
        T394 obj = new T394();
    }

    public int largestRectangleArea(int[] heights) {
        // 创建一个栈，用来存储柱子的下标
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0; // 存储最大的矩形面积
        for (int i = 0; i <= heights.length; i++) {
            // 当栈不为空，且当前柱子比栈顶柱子矮时
            // 或者遍历到最后一个柱子后的一个虚拟柱子（高度为0），以确保栈会被清空
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int h = heights[stack.pop()];
                // 如果栈为空，说明栈顶柱子是当前区间中的最小柱子，所以宽度是从0到当前i
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            // 将当前柱子的下标压入栈
            stack.push(i);
        }
        return maxArea;
    }
}

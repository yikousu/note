package com.algorithm.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hac
 * @date 2024/6/24 15:30
 */
public class T239 {
    public static int getMax(int[] nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 自己写的 因为每一个窗口找最值我用的遍历 O(n)  超时  必须O(n)->O(1)
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (k == 1) return nums;
        int[] res = new int[nums.length];
        int j = 0;
        int currentMaxIndex = 0;
        int rightValue = nums[0];
        for (int i = 0; i + k - 1 < nums.length; i++) {
            rightValue = nums[i + k - 1];
            if (j > 0 && rightValue > nums[currentMaxIndex]) {
                res[j++] = rightValue;
                currentMaxIndex = i + k - 1;
            } else {
                int maxIndex = getMax(nums, Math.max(currentMaxIndex, i), i + k - 1);
                res[j++] = nums[maxIndex];
                currentMaxIndex = maxIndex;
            }

        }
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = res[i];
        }
        return result;
    }

    // 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧
    // 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
    // 本题难点： 如何在每次窗口滑动后，将 “获取窗口内最大值” 的时间复杂度从 O(k) 降低至 O(1) 。
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();// 存窗口内元素  单调队列 【非严格递减】
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])//
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        int k = 2;
        int[] res = maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + "\t");
        }
    }
}

package com.algorithm.hot100;

public class T11 {

    // 暴力  超时
    public static int maxArea2(int[] height) {
        int res = 0;
        int width = 1;
        for (int i = 0; i < height.length; i++) {
            width = 1;
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * width);
                width++;
            }
        }
        return res;
    }

    // 双指针优化
    public static int maxArea(int[] height) {
        int res = 0;
        int l = 0, h = height.length - 1;
        int width = h;
        while (l < h) {
            res = Math.max(Math.min(height[l], height[h]) * width, res);
            // 取等  不然后死循环了
            if (height[l] >= height[h]) {
                h = h - 1;
            } else if (height[l] <= height[h]) {
                l = l + 1;
            }
            width--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }
}

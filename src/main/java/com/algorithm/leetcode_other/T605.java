package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/8/29 20:33
 */
public class T605 {
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // 如果当前位置是 0 且前后位置也为空（边界条件也要考虑）
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                // 放置花朵
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) && (flowerbed.length - 1 == i || flowerbed[i + 1] == 0)
            ) {

                count++;
                flowerbed[i] = 1;
            }

        }

        return count >= n;
    }

}

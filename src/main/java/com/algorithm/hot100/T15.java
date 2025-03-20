package com.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class T15 {
    // 输入：nums = [-1,0,1,2,-1,-4]
    // 输出：[[-1,-1,2],[-1,0,1]]
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
//                List<Integer> res = new ArrayList<>(Arrays.asList(nums));


                ArrayList<List<Integer>> lists = new ArrayList<>();
//                lists.add(res);
                return lists;
            }
        }


        return null;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}

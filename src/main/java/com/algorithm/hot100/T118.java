package com.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hac
 * @date 2024/9/4 19:01
 */
public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = res.get(i - 1);

            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(list.get(j - 1) + list.get(j));
            }
            temp.add(1);
            res.add(temp);

        }


        return res;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        // 第一行固定为 [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        // 从第二行开始生成
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = res.get(i - 1); // 上一行
            List<Integer> row = new ArrayList<>();

            // 每行的第一个元素是 1
            row.add(1);
            // 中间的元素是上一行的两个元素相加
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            // 每行的最后一个元素是 1
            row.add(1);
            res.add(row);
        }
        return res;
    }
}

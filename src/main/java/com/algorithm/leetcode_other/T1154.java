package com.algorithm.leetcode_other;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author hac
 * @date 2024/8/25 23:51
 */
public class T1154 {
    public static int dayOfYear(String date) {
        LocalDate tempDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return tempDate.getDayOfYear();
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
    }
}

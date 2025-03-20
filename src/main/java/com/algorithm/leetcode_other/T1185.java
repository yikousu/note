package com.algorithm.leetcode_other;

import java.time.LocalDate;

/**
 * @author hac
 * @date 2024/8/25 23:41
 */
// 主要利用LocalDate
public class T1185 {
    public static String dayOfTheWeek1(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String week = date.getDayOfWeek().toString();
        return week.substring(0, 1).toUpperCase() + week.substring(1, week.length()).toLowerCase();
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        LocalDate date = LocalDate.of(year, month, day);
        String week = date.getDayOfWeek().toString();
        for (String s : weeks) {
            if (week.equalsIgnoreCase(s)) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(25, 8, 2024));
    }
}

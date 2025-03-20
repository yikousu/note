package com.algorithm.leetcode_other;

/**
 * @author hac
 * @date 2024/9/1 18:24
 */
public class T1071 {
    public String gcdOfStrings1(String str1, String str2) {
        if (str1.charAt(0) != str2.charAt(0)) return "";

        String res = "";
        StringBuilder sb = new StringBuilder();
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));

                String string = sb.toString();
                int length = str1.length() / string.length();
                StringBuilder temp = new StringBuilder();
                for (int i1 = 0; i1 < length; i1++) {
                    temp.append(string);
                }

                int length1 = str2.length() / string.length();
                StringBuilder temp1 = new StringBuilder();
                for (int i1 = 0; i1 < length1; i1++) {
                    temp1.append(string);
                }
                if (str1.equals(temp.toString()) && str2.equals(temp1.toString())) {
                    res = string;
                }
            }
        }
        return res;
    }

    public String gcdOfStrings(String str1, String str2) {
        // 如果两个字符串首字符不同，直接返回空字符串
        if (str1.charAt(0) != str2.charAt(0)) return "";

        int gcdLength = findGCD(str1.length(), str2.length());

        // 判断是否存在公共字符串
        String substring = str1.substring(0, gcdLength);
        StringBuilder temp1 = new StringBuilder();
        for (int i = 0; i < str1.length() / gcdLength; i++) {
            temp1.append(substring);
        }
        StringBuilder temp2 = new StringBuilder();
        for (int i = 0; i < str2.length() / gcdLength; i++) {
            temp2.append(substring);
        }

        return str1.equals(temp1.toString()) && str2.equals(temp2.toString()) ? substring : "";
    }

    public int findGCD(int a, int b) {
        // a ÷ b  =  余数
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


}

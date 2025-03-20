package com.algorithm.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T20 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        // 防止: "){"
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }


    public static void main(String[] args) {
        String s = "{}";
        System.out.println(isValid(s));

    }
}

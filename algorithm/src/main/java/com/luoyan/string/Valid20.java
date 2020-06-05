package com.luoyan.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid20 {

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if ( s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('(', ')');
        mapping.put('[', ']');
        mapping.put('{', '}');

        Stack<Character> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mapping.containsKey(c)) {
                stacks.push(mapping.get(c));
            } else {
                if (stacks.isEmpty()) {
                    return false;
                }
                Character pop = stacks.pop();
                if (!pop.equals(c)) {
                    return false;
                }
            }
        }
        return stacks.isEmpty();
    }

}

package com.luoyan.alg;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));

    }

    public static int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        char[] array = s.toCharArray();
        boolean isMinus = false;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                if (isMinus) {
                    res += map.get(array[i]) - map.get(array[i - 1]);
                } else {
                    res += map.get(array[i]);
                }
            } else {
                if (map.get(array[i]) < map.get(array[i + 1])) {
                    isMinus = true;
                } else {
                    if (isMinus) {
                        res += map.get(array[i]) - map.get(array[i - 1]);
                        isMinus = false;
                    } else {
                        res += map.get(array[i]);
                    }
                }
            }
        }
        return res;
    }

    public static int romanToInt2(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        char[] array = s.toCharArray();
        int preVal = map.get(array[0]);
        for (int i = 1; i < array.length; i++) {
            int val = map.get(array[i]);
            if (preVal < val) {
                res -= preVal;
            } else {
                res += preVal;
            }
            preVal = val;
        }
        res += preVal;
        return res;
    }


    public static int romanToInt3(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        char[] array = s.toCharArray();
        int preVal = getValue(array[0]);
        for (int i = 1; i < array.length; i++) {
            int val = getValue(array[i]);
            if (preVal < val) {
                res -= preVal;
            } else {
                res += preVal;
            }
            preVal = val;
        }
        res += preVal;
        return res;
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;

        }
    }

}

package com.luoyan.alg;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

}

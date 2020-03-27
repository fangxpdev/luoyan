package com.luoyan.array;

import java.util.*;

public class ThreeSum15 {

    public static void main(String[] args) {

//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{-2,0,0,2,2};

        List<List<Integer>> lists = threeSum2(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    /**
     * 暴力解法   时间太长  无法提交
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<String> key = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        String a = nums[i] + "" + nums[j] + "" + nums[k];
                        if (key.contains(a)) {
                            continue;
                        }
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        key.add(a);
                        result.add(temp);
                    }
                }
            }
        }

        return result;
    }


    /**
     * 双指针
     * https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int k = 0; k < nums.length - 2; k++) {

            if (nums[k] > 0) {
                break;
            }

            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int temp = nums[k] + nums[i] + nums[j];
                if (temp == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;

                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }

                    continue;
                }
                if (temp < 0) {
                    i++;
                    continue;
                }
                if (temp > 0) {
                    j--;
                    continue;
                }
            }

        }

        return res;
    }


}

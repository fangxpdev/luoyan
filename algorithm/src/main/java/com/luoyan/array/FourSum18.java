package com.luoyan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums = new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2};

        List<List<Integer>> lists = fourSum2(nums, -9);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {


        Arrays.sort(nums);


        return kSum(nums, target, 4, 0);

    }


    /**
     * @param nums   原数组
     * @param target
     * @param k      需要找出的元素个数
     * @param index  数组开始下标
     * @return
     */
    public static ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index >= nums.length) {
            return res;
        }

        if (k == 2) {
            int left = index, right = nums.length - 1;
            while (left < right) {

                int temp = nums[left] + nums[right];
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[left]);
                    r.add(nums[right]);
                    res.add(r);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }

            }
        } else {
            for (int i = index; i < nums.length - k + 1; i++) {

                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);

                if (temp != null) {
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    //skip duplicated numbers
                    i++;
                }

            }
        }

        return res;

    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) {  //corner case
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                break;
            }
            int max1 = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max1 < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = len - 1;

                int min = nums[i] + nums[j] + nums[left] + nums[left + 1];
                if (min > target) {
                    continue;
                }

                int max = nums[i] + nums[j] + nums[right - 1] + nums[right];
                if (max < target) {
                    continue;
                }

                while (left < right) {

                    int cur = nums[i] + nums[j] + nums[left] + nums[right];

                    if (cur < target) {
                        left++;
                    } else if (cur > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }

                }

            }
        }
        return res;

    }


}

package com.lonton.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字 <p/>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。<p/>
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。<p/>
 *
 * @author 张利红
 */
public class Q448FindAllNumbersDisappearedInAnArray {
    /**
     * 找到所有数组中消失的数字
     *
     * @param nums 数组
     * @return 消失数字组成的集合
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // 检查输入数组是否为null
        if (nums == null) {
            return res;
        }

        // 遍历 nums 数组
        for (int i = 0; i < nums.length; i++) {
            // 将 nums 中出现的数字作为下标，将对应位置上的数字取反
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // 再遍历一次 nums 数组
        for (int i = 0; i < nums.length; i++) {
            // 将未出现的数（正数）加入到结果集合中
            if (nums[i] > 0) {
                res.add(i + 1);
            }
            nums[i] = Math.abs(nums[i]);
        }

        return res;
    }
}

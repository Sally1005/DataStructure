package com.lonton.leetcode.med;


import java.util.ArrayList;
import java.util.List;

/**
 * 442. 找到数组中重复的数字 <p/>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内,<p/>
 * 且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。<p/>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。<p/>
 *
 * @author 张利红
 */

public class Q442FindAllDuplicatesInAnArray {
    /**
     * 找到所有数组中重复的数字
     *
     * @param nums 数组
     * @return 重复的数字组成的集合
     */
    public List<Integer> findDuplicates(int[] nums) {
        // 创建一个List用于存储出现两次的整数
        List<Integer> result = new ArrayList<>();
        // 遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // 计算当前数字应该在的下标
            int index = Math.abs(nums[i]) - 1;
            // 如果当前数字已经出现过一次，即当前下标对应的数字为负数
            if (nums[index] < 0) {
                // 将当前数字加入到结果List中
                result.add(Math.abs(nums[i]));
            }
            // 将当前下标对应的数字取相反数，表示当前数字已经出现过一次
            nums[index] = -nums[index];
        }
        // 返回结果List
        return result;
    }
}

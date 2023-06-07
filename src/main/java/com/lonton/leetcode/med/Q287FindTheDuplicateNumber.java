package com.lonton.leetcode.med;


/**
 * 287. 寻找重复数. <p/>
 * 给定一个包含 n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。<p/>
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。<p/>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。<p/>
 * <p>
 * 思路：<p/>
 * 二分查找法;<p/>
 * 将数组中的数字按照中位数分成两部分，分别统计每个部分中小于等于中位数的数字个数，<p/>
 * 如果某一部分中小于等于中位数的数字个数大于中位数，说明重复数字在这个部分中。<p/>
 *
 * @author 张利红
 */

public class Q287FindTheDuplicateNumber {
    /**
     * 寻找重复数
     *
     * @param nums 数组
     * @return 重复的数字
     */
    public int findDuplicate(int[] nums) {
        // 左指针从1开始，右指针从数组长度-1开始，因为数字在[1, n]范围内
        int left = 1, right = nums.length - 1;
        while (left < right) {
            // 取中间值
            int mid = left + (right - left) / 2;
            // 记录小于等于中间值的数字个数
            int count = 0;
            // 遍历数组
            for (int num : nums) {
                // 如果数字小于等于中间值
                if (num <= mid) {
                    count++;
                }
                // 如果小于等于中间值的数字个数大于中间值
                if (count > mid) {
                    // 重复数字在左半部分，将右指针移动到中间值
                    right = mid;
                    break;
                }
            }
            if (count <= mid) {
                // 重复数字在右半部分，将左指针移动到中间值+1
                left = mid + 1;
            }
        }
        // 返回重复数字
        return left;
    }
}


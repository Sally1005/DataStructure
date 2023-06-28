package com.lonton.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度 <p/>
 * 数组的度定义为元素出现的最高频率，给定一个非空且只包含非负数的整数数组 nums，<p/>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。<p/>
 * <p>
 * 思路：<p/>
 * 1. 首先使用三个HashMap来存储数组中每个数字的频数、第一次出现的索引和最后一次出现的索引;<p/>
 * 2. 再遍历数组，计算每个数字的频数，并更新它们的第一次和最后一次出现的索引;<p/>
 * 3. 找到数组的最大度（最大频数）;<p/>
 * 4. 最后，再次遍历数组，找到与最大度相同的子数组,计算并更新最短子数组的长度;<p/>
 * 5. 最终结果是具有相同度的最短连续子数组的长度。
 *
 * @author 张利红
 */
public class Q697DegreeOfAnArray {

    /**
     * 最小子数组（与原数组的度一致）
     *
     * @param nums 原数组
     * @return 与原数组度一致的最小子数组的原数组的个数
     */
    public int findShortestSubArray(int[] nums) {
        // 创建三个HashMap来存储每个数字的频数、第一次出现的索引和最后一次出现的索引
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        // 遍历数组，计算频数并更新第一次和最后一次出现的索引
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 获取num在frequency中原来的值，若不存在，则在原来的基础上频数+1
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            lastIndex.put(num, i);
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
        }

        // 原数组的最大度
        int maxDegree = 0;
        // 最短子数组的长度
        int minLength = Integer.MAX_VALUE;

        // 找到数组的最大度（最大频数）
        for (int num : nums) {
            // 当前数字的频数
            int degree = frequency.get(num);
            if (degree > maxDegree) {
                maxDegree = degree;
            }
        }

        // 计算并更新最短子数组的长度
        for (int num : nums) {
            int degree = frequency.get(num);
            if (degree == maxDegree) {
                // 子数组的长度
                int length = lastIndex.get(num) - firstIndex.get(num) + 1;
                // 保持minLength长度最小
                if (length < minLength) {
                    minLength = length;
                }
            }
        }

        return minLength;
    }

}

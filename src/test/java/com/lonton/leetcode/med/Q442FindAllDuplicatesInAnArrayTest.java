package com.lonton.leetcode.med;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 442. 测试找到所有数组中重复的数字
 * <ol>
 * <li> 给定数组 nums = [4, 3, 2, 7, 8, 2, 3, 1]中有两个数字重复，期望返回重复的数字的集合为 expected = [2, 3];
 * <li> 给定数组 nums = [1, 1, 2, 2, 3, 3]中所有数字都重复，期望返回集合 expected = [1, 2, 3];
 * <li> 给定数组 nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]中无重复数字，期望返回重复的数字的集合 expected = []。
 * </ol>
 *
 * @author 张利红
 */
public class Q442FindAllDuplicatesInAnArrayTest {
    private final Q442FindAllDuplicatesInAnArray solution = new Q442FindAllDuplicatesInAnArray();

    @Test
    public void testFindTwoDuplicates() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = Arrays.asList(2, 3);
        List<Integer> actual = solution.findDuplicates(nums);
        Assertions.assertEquals(expected, actual, "给定数组中有两个数字重复，期望返回重复的数字的集合错误。");
    }

    @Test
    public void testFindAllDuplicates() {
        int[] nums = {1, 1, 2, 2, 3, 3};
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = solution.findDuplicates(nums);
        Assertions.assertEquals(expected, actual, "给定数组中所有数字都重复，期望返回所有数字的集合错误。");
    }

    @Test
    public void testFindDuplicatesEmpty() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> expected = Arrays.asList();
        List<Integer> actual = solution.findDuplicates(nums);
        Assertions.assertEquals(expected, actual, "给定数组中没有数字重复，期望返回空集合错误。");
    }
}

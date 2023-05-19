package com.lonton.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 645. 测试错误的集合
 * <ol>
 *     <li> 传入数组 {1, 2, 2, 4}，期望函数返回数组 {2, 3}；
 *     <li> 传入数组 {1, 2, 3, 4}，期望函数返回 null；
 *     <li> 传入数组 {1, 2, 3}和索引0和2，期望swap函数交换数组中这两个索引的元素，返回{3, 2, 1}。
 * </ol>
 *
 * @author 张利红
 */

public class Q645SetMismatchTest {

    @Test
    public void testFindErrorNumsPositive() {
        int[] nums = {1, 2, 2, 4};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, new Q645SetMismatch().findErrorNums(nums),
                "当整数数组中存在缺失和重复数字的情况下，与预期结果有误。");
    }

    @Test
    public void testFindErrorNumsNegative() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertNull(new Q645SetMismatch().findErrorNums(nums),
                "当整数数组中不存在缺失和重复数字的情况下，与预期结果有误。");
    }

    @Test
    public void testSwap() {
        int[] nums = {1, 2, 3};
        new Q645SetMismatch().swap(nums, 0, 2);
        int[] expected = {3, 2, 1};
        Assertions.assertArrayEquals(expected, nums,
                "当交换数组索引时，返回的数组与预期结果有误。");
    }
}

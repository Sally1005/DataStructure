package com.lonton.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 448. 测试找到所有数组中消失的数字
 * <ol>
 * <li> 给定数组 nums = [4, 3, 2, 7, 8, 2, 3, 1]中有两个数字消失，期望返回消失的数字的集合为 expected = [5,6];
 * <li> 给定一个空数组 nums = []，期望返回空集合 expected = [];
 * <li> 给定数组 nums = [1, 2, 3, 4, 5, 6]中所有数字都存在，期望返回空集合 expected = [];
 * <li> 给定一个 null 数组，期望返回空集合 expected = [];
 * <li> 给定数组 nums = [1, 1, 2, 2, 3, 3]中有重复数字，期望返回消失的数字的集合 expected = [4,5,6]。
 * </ol>
 *
 * @author 张利红
 */
public class Q448FindAllNumbersDisappearedInAnArrayTest {

    @Test
    public void testFindDisappearedNumbers() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = Arrays.asList(5, 6);
        List<Integer> actual = new Q448FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        assertEquals(expected, actual, "给定数组中有两个数字消失，期望返回消失的数字的集合错误。");
    }

    @Test
    public void testFindDisappearedNumbersEmptyArray() {
        int[] nums = {};
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new Q448FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        assertEquals(expected, actual, "给定一个空数组，期望返回的不是空集合。");
    }

    @Test
    public void testFindDisappearedNumbersAllNumbersPresent() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new Q448FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        assertEquals(expected, actual, "给定数组中所有数字都存在，期望返回的不是空集合。");
    }


    @Test
    public void testFindDisappearedNumbersNullArray() {
        int[] nums = null;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new Q448FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        assertEquals(expected, actual, "给定一个 null 数组，期望返回的不是空集合。");
    }

    @Test
    public void testFindDisappearedNumbersDuplicateNumbers() {
        int[] nums = {1, 1, 2, 2, 3, 3};
        List<Integer> expected = Arrays.asList(4, 5, 6);
        List<Integer> actual = new Q448FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        assertEquals(expected, actual, "给定数组中有重复数字，期望返回消失的数字的集合错误。");
    }

}

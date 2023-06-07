package com.lonton.leetcode.med;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 287. 测试寻找重复数
 * <ol>
 * <li> 给定数组 nums = [1, 1, 2, 3, 4]重复数字在左半部分时，期望返回重复数 expected = 1;
 * <li> 给定数组 nums = [2, 3, 4, 5, 6, 7, 8, 9, 1, 1]重复数字在右半部分时，期望返回重复数 expected = 1;
 * <li> 给定数组 nums = [1, 1, 1, 1, 1]重复数字都相同时，期望返回重复数 expected = 1;
 * </ol>
 *
 * @author 张利红
 */
public class Q287FindTheDuplicateNumberTest {
    private final Q287FindTheDuplicateNumber solution = new Q287FindTheDuplicateNumber();
    @Test
    public void testLeft() {

        int[] nums = {1, 1, 2, 3, 4};
        int expected = 1;
        int actual = solution.findDuplicate(nums);
        Assertions.assertEquals(expected, actual, "当重复数字在左半部分时,期望返回重复数错误。");

    }

    @Test
    public void testRight(){
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9, 1, 1};
        int expected = 1;
        int actual = solution.findDuplicate(nums);
        Assertions.assertEquals(expected, actual, "当重复数字在右半部分时,期望返回重复数错误。");

    }
    @Test
    public void testSame(){
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 1;
        int actual = solution.findDuplicate(nums);
        Assertions.assertEquals(expected, actual, "当所有数字都相同时,期望返回重复数错误。");

    }
}

package com.lonton.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 283. 移动零
 * <ul>
 * <li> 将数组 [0, 1, 0, 3, 12] 变为[1, 3, 12, 0, 0]；
 * <li> 将数组 [0] 变为[ 0]。
 * </ul>
 *
 * @author 张利红
 */
public class Q283MoveZeroesTest {
    @Test
    public void test() {
        Q283MoveZeroes zeroes = new Q283MoveZeroes();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        zeroes.moveZeroes(arr);
        Assertions.assertArrayEquals(
                new int[]{1, 3, 12, 0, 0}, arr,
                " 当数组包含多个不为0的元素时，移动0错误。");
    }

    @Test
    public void testOnlyZero() {
        Q283MoveZeroes zeroes = new Q283MoveZeroes();
        int[] arr = new int[]{0};
        zeroes.moveZeroes(arr);
        Assertions.assertArrayEquals(
                new int[]{0}, arr,
                " 当数组只有0时，移动0错误。");
    }
}

package com.lonton.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 485. 测试计算最大连续 1 的个数 <p/>
 * <ul>
 * <li> 输入：nums = [1,1,0,1,1,1]
 * <li> 输出：3
 * <li> 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * </ul>
 *
 * @author 张利红
 */
public class Q485MaxConsecutiveOnesTest {
    @Test
    public void test() {
        Q485MaxConsecutiveOnes consecutiveOnes = new Q485MaxConsecutiveOnes();
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int actual = consecutiveOnes.findMaxConsecutiveOnes(arr);
        Assertions.assertEquals(3,actual,"测试计算最大连续 1 的个数错误。");
    }
}

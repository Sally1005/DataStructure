package com.lonton.leetcode.easy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 697. 测试数组的度 <p/>
 * 输入数组： nums = [1,2,2,3,1,4,2]，预期输出：6。<p/>
 * 解释：<p/>
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。<p/>
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 *
 * @author 张利红
 */
public class Q697DegreeOfAnArrayTest {
    @Test
    public void test() {
        Q697DegreeOfAnArray shortSubArray = new Q697DegreeOfAnArray();
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        int result = shortSubArray.findShortestSubArray(nums);
        Assertions.assertEquals(6, result, "所计算出的最短子数组的长度与预期结果不符。");
    }
}

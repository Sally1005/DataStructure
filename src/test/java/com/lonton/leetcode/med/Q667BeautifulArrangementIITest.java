package com.lonton.leetcode.med;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 667. 测试优美的排列 II
 * <ol>
 *     <li>  当 k = 1时，将原数组 [1,2,3,4,5,6]构造成答案列表 expected = [1,2,3,4,5,6];
 *     <li>  当 k = 3时，将原数组 [1,2,3,4,5,6]构造成答案列表 expected = [1,6,2,3,4,5];
 *     <li>  当 k = 4时，将原数组 [1,2,3,4,5,6]构造成答案列表 expected = [6,1,5,2,3,4]。
 * </ol>
 *
 * @author 张利红
 */
public class Q667BeautifulArrangementIITest {
    Q667BeautifulArrangementII test = new Q667BeautifulArrangementII();

    @Test
    public void testConstructArray() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expected, test.constructArray(6, 1));
    }

    @Test
    public void testWithOddNumber() {
        int[] expected = {1, 6, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, test.constructArray(6, 3));
    }

    @Test
    public void testWithEvenNUmber() {
        int[] expected = {6, 1, 5, 2, 3, 4};
        Assertions.assertArrayEquals(expected, test.constructArray(6, 4));
    }
}

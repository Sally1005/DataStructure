package com.lonton.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 566. 重塑矩阵
 * <ul>
 * <li> 合理： 输入：mat = [[1,2],[3,4]], r = 1, c = 4,输出：[[1,2,3,4]]；
 * <li> 不合理：输入：mat = [[1,2],[3,4]], r = 2, c = 4,输出：[[1,2],[3,4]]。
 * </ul>
 *
 * @author 张利红
 */
public class Q566ReshapeTheMatrixTest {
    @Test
    public void test() {
        Q566ReshapeTheMatrix matrix = new Q566ReshapeTheMatrix();
        int[][] arr = new int[][]{{1, 2}, {3, 4}};
        int[][] reshape = matrix.matrixReshape(arr, 1, 4);
        Assertions.assertArrayEquals(
                new int[][]{{1, 2, 3, 4}}, reshape,
                " 当矩阵重塑合理时，重塑矩阵失败。");
    }

    @Test
    public void testNotReasonable() {
        Q566ReshapeTheMatrix matrix = new Q566ReshapeTheMatrix();
        int[][] arr = new int[][]{{1, 2}, {3, 4}};
        matrix.matrixReshape(arr, 2, 4);
        Assertions.assertArrayEquals(
                new int[][]{{1, 2}, {3, 4}}, arr,
                " 当矩阵重塑不合理时，重塑矩阵失败。");
    }
}

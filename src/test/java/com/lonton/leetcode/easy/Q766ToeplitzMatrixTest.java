package com.lonton.leetcode.easy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 776. 测试托普利茨矩阵 <p/>
 * <ul>
 *    <li>输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]，输出：true。
 *    <li>在上述矩阵中, 其对角线为:
 *         "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"，各条对角线上的所有元素均相同。
 *    <li>输入：matrix = [[1,2],[2,2]]，输出：false。
 *    <li>在上述矩阵中, 其对角线为:
 *        对角线 "[1, 2]" 上的元素不同。
 * </ul>
 *
 * @author 张利红
 */
public class Q766ToeplitzMatrixTest {

    @Test
    public void testIsToeplitzMatrixTrue() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        boolean actual = new Q766ToeplitzMatrix().isToeplitzMatrix(matrix);
        Assertions.assertTrue(actual,"该矩阵不是托普利茨矩阵。");
    }

    @Test
    public void testIsToeplitzMatrixFalse() {
        int[][] matrix = {{1, 2}, {2, 2}};
        boolean actual = new Q766ToeplitzMatrix().isToeplitzMatrix(matrix);
        Assertions.assertFalse(actual,"该矩阵是托普利茨矩阵。");
    }
}

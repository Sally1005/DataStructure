package com.lonton.leetcode.med;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 074. 测试搜索二维矩阵
 * <ol>
 *     <li> 找到目标数，判断预期值是否为 true；
 *     <li> 未找到目标数，判断预期值是否为 false；
 *     <li> 矩阵为空情况,判断预期值是否为 false;
 *     <li> 矩阵为 null 情况,判断预期值是否为 false。
 * </ol>
 *
 * @author 张利红
 */
public class Q074Search2DMatrixTest {

    @Test
    public void testSearchMatrix_Positive() {
        int[][] matrix = {{1, 3, 5, 7}, {9, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        Assertions.assertTrue(new Q074Search2DMatrix().searchMatrix(matrix, target), "当搜索二维矩阵找到目标数时，与预期结果有误。");
    }

    @Test
    public void testSearchMatrix_Negative() {
        int[][] matrix = {{1, 3, 5, 7}, {9, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 13;
        Assertions.assertFalse(new Q074Search2DMatrix().searchMatrix(matrix, target), "当搜索二维矩阵未找到目标数时，与预期结果有误。");
    }

    @Test
    public void testSearchMatrix_MatrixEmpty() {
        int[][] matrix = new int[0][];
        int target = 10;
        Assertions.assertFalse(new Q074Search2DMatrix().searchMatrix(matrix, target), "当搜索二维矩阵为空情况下，与预期结果有误。");
    }

    @Test
    public void testSearchMatrix_MatrixNull() {
        int[][] matrix = null;
        int target = 10;
        Assertions.assertFalse(new Q074Search2DMatrix().searchMatrix(matrix, target), "当搜索二维矩阵为 null 情况下，与预期结果有误。");
    }
}

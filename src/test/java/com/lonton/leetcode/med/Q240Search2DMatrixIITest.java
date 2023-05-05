package com.lonton.leetcode.med;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 240. 测试搜索二维矩阵 II
 * <ol>
 *     <li> 找到目标数，判断预期值是否为 true；
 *     <li> 未找到目标数，判断预期值是否为 false；
 *     <li> 矩阵为空情况,判断预期值是否为 false;
 *     <li> 矩阵为 null 情况,判断预期值是否为 false。
 * </ol>
 *
 * @author 张利红
 */
public class Q240Search2DMatrixIITest {

    @Test
    public void testSearchMatrix_Positive() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}};
        int target = 5;
        Assertions.assertTrue(new Q240Search2DMatrixII().searchMatrix(matrix, target), "当搜索二维矩阵找到目标数时，与预期结果有误。");
    }

    @Test
    public void testSearchMatrix_Negative() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}};
        int target = 20;
        Assertions.assertFalse(new Q240Search2DMatrixII().searchMatrix(matrix, target), "当搜索二维矩阵未找到目标数时，与预期结果有误。");
    }

    @Test
    public void testSearchMatrix_MatrixEmpty() {
        int[][] matrix = new int[0][];
        int target = 10;
        Assertions.assertFalse(new Q240Search2DMatrixII().searchMatrix(matrix, target), "当搜索二维矩阵为空情况下，与预期结果有误。");
    }

    @Test
    public void testSearchMatrix_MatrixNull() {
        int[][] matrix = null;
        int target = 10;
        Assertions.assertFalse(new Q240Search2DMatrixII().searchMatrix(matrix, target), "当搜索二维矩阵为 null 情况下，与预期结果有误。");
    }
}

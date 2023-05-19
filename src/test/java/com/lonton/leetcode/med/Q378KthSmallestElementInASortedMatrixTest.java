package com.lonton.leetcode.med;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 378. 测试有序矩阵中第 k 小元素
 * <ol>
 *     <li> 测试kthSmallest方法是否能够正确返回第k小的元素；
 *     <li> 测试当数组中所有元素都相同时，是否能够正确返回第k个元素；
 *     <li> 测试不同大小的矩阵是否能够正确返回第k个元素;
 *     <li> 测试当k值超出数组元素个数时，是否能够正常处理异常;
 *     <li> 测试当传入的数组为空时，是否能够正常处理异常。
 * </ol>
 *
 * @author 张利红
 */
public class Q378KthSmallestElementInASortedMatrixTest {

    @Test
    public void testKthSmallest() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int k = 2;
        Assertions.assertEquals(2, new Q378KthSmallestElementInASortedMatrix().kthSmallest(matrix, k),
                "当测试kthSmallest方法是否能够正确返回第k小的元素时，与预期结果有误。");
    }

    @Test
    public void testKthSmallestWithSameNumbersInMatrix() {
        int[][] matrix = {{1, 1}, {1, 1}};
        int k = 4;
        Assertions.assertEquals(1, new Q378KthSmallestElementInASortedMatrix().kthSmallest(matrix, k),
                "当测试当数组中所有元素都相同时，是否能够正确返回第k个元素时，与预期结果有误。");
    }

    @Test
    public void testKthSmallestWithDifferentSizeMatrix() {
        int[][] matrix = {{1, 2, 4}, {3, 5, 7}, {6, 8, 9}};
        int k = 5;
        Assertions.assertEquals(5, new Q378KthSmallestElementInASortedMatrix().kthSmallest(matrix, k),
                "当测试不同大小的矩阵是否能够正确返回第k个元素时，与预期结果有误。");
    }

    @Test
    public void testKthSmallestWithKOutOfRange() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int k = 5;
        // 断言IllegalArgumentException是否会被抛出
        try {
            new Q378KthSmallestElementInASortedMatrix().kthSmallest(matrix, k);
            // 如果没有抛出异常，将抛出AssertionFailedError
            Assertions.fail("Expected IllegalArgumentException to be thrown, but nothing was thrown.");
        } catch (IllegalArgumentException e) {
            // 如果抛出了IllegalArgumentException，则断言成功
            Assertions.assertEquals("k is out of range", e.getMessage(),
                    "当测试当传入的数组为空时，是否能够正常处理异常时，与预期结果有误。");
        }
    }

    @Test
    public void testKthSmallestWithMatrixOutOfRange() {
        int[][] matrix = {{}};  // 数组为空
        int k = 2;
        // 断言IllegalArgumentException是否会被抛出
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Q378KthSmallestElementInASortedMatrix().kthSmallest(matrix, k);
        }, "当测试当传入的数组为空时，是否能够正常处理异常，与预期结果有误。");
    }
}




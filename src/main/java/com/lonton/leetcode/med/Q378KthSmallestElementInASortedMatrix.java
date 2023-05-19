package com.lonton.leetcode.med;

/**
 * 378. 有序矩阵中第 k 小元素 <p/>
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。<p/>
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * @author 张利红
 */
public class Q378KthSmallestElementInASortedMatrix {
    /**
     * @param matrix 原矩阵
     * @param k      排序 k
     * @return 第 k 小元素
     */
    public int kthSmallest(int[][] matrix, int k) {
        // 原矩阵行
        int m = matrix.length;
        // 原矩阵列
        int n = matrix[0].length;
        // 检查k是否超过矩阵的元素数
        if (k > m * n) {
            throw new IllegalArgumentException("k is out of range");
        }
        // 矩阵首项
        int start = matrix[0][0];
        // 矩阵尾项
        int end = matrix[m - 1][n - 1];
        // 终止条件
        while (start <= end) {
            //找到中间值
            int mid = start + (end - start) / 2;
            // 计数器归零
            int flag = 0;
            // 遍历整个矩阵，统计小于等于中间值mid的元素个数
            for (int[] ints : matrix) {
                for (int i = 0; i < n && ints[i] <= mid; i++) {
                    flag++;
                }
            }
            //判断flag与k的大小关系，更新start和end的值
            if (flag < k) start = mid + 1;
            else end = mid - 1;
        }
        //返回start作为矩阵中第k小的元素
        return start;
    }
}

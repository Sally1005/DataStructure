package com.lonton.leetcode.easy;

/**
 * 776. 托普利茨矩阵 <p/>
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则,返回 false。<p/>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵<p/>
 * 思路：<p/>
 * 遍历矩阵中的每个元素，然后判断其与其右下方元素是否相等。<p/>
 * 如果存在不相等的情况，则该矩阵不是托普利茨矩阵，返回false。<p/>
 * 若所有元素都满足条件，则返回true。<p/>
 * 因为托普利茨矩阵的定义是对角线上的元素相等，最后一行和最后一列不需要进行比较。
 *
 * @author 张利红
 */
public class Q766ToeplitzMatrix {

    /**
     * 托普利茨矩阵
     *
     * @param matrix 矩阵
     * @return 是否为托普利茨矩阵
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 获取矩阵的行数
        int m = matrix.length;
        // 获取矩阵的列数
        int n = matrix[0].length;
        // 遍历矩阵中的每个元素
        for (int i = 0; i < m - 1; i++) { // 循环控制变量i从0到m-2，因为最后一行不需要比较
            for (int j = 0; j < n - 1; j++) { // 循环控制变量j从0到n-2，因为最后一列不需要比较
                // 判断当前元素与其右下方元素是否相等
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    // 如果不相等，则返回false，表示不是托普利茨矩阵
                    return false;
                }
            }
        }
        // 如果所有元素都满足条件，则返回true，表示是托普利茨矩阵
        return true;
    }
}

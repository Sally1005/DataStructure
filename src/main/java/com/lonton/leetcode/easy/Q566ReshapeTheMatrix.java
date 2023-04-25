package com.lonton.leetcode.easy;

/**
 * 566. 重塑矩阵 <p/>
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。<p/>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。 <p/>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。<p/>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。<p/>
 * 思路：<p/>
 * <ol>
 * <li> 两种情况：可行，则遍历输出；
 * <li> 不可行，则返回输出原始矩阵（若元素多于矩阵新矩阵的个数（r * c）则不可行，少于的情况在二维数组中还可以自动补0）
 * </ol>
 *
 * @author 张利红
 */
public class Q566ReshapeTheMatrix {
    /**
     * 重塑矩阵
     *
     * @param mat 原二维数组
     * @param r   重构的矩阵的行数
     * @param c   重构的矩阵的列数
     * @return 重构矩阵 /原始矩阵
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 原数组的行
        int m = mat.length;
        // 原数组的列（因为是矩阵，每一行的个数都相等，即使一行缺少元素，也会补零自动对齐）
        int n = mat[0].length;
        // 不可行且不合理，输出原始矩阵
        if (m * n != r * c) {
            return mat;
        }
        // 创建新的二维数组
        int[][] reshapeArr = new int[r][c];
        // 声明 下标初始值
        int index = 0;
        // 从上至下，从左至右，以行遍历顺序填充二维数组
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 每一行有多少个元素除以矩阵的列数即可
                reshapeArr[i][j] = mat[index / n][index % n];
                index++;
            }
        }
        return reshapeArr;
    }
}

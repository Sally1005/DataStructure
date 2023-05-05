package com.lonton.leetcode.med;

/**
 * 240. 搜索二维矩阵 II<p/>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *  <li>每行中的整数从左到右按升序排列。
 *  <li>每列的元素从上到下升序排列。
 *
 * @author 张利红
 */
public class Q240Search2DMatrixII {
    /**
     * 搜索二维矩阵 II
     *
     * @param matrix 二维矩阵
     * @param target 目标数
     * @return 布尔值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 如果矩阵为空，则无法查找，直接返回 false
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 原二维数组的行/列
        int n = matrix.length, m = matrix[0].length;
        // 从右上角（即第一行末尾开始）进行判断，可以发现是一棵二叉树
        int i = 0, j = m -1;
        while(i < n && j >= 0){
            // 当搜索到的值等于目标数时，则返回true
            if(matrix[i][j] == target) return true;
            // 当搜索到的值大于目标数时，则说明在左侧
            if(matrix[i][j] >= target) j--;
                // 当搜索到的值小于目标数时，则说明在下侧
            else i++;
        }
        return false;
    }
}

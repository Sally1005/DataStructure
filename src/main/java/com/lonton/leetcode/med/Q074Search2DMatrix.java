package com.lonton.leetcode.med;
/**
 * 074. 搜索二维矩阵<p/>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *  <li>每行中的整数从左到右按升序排列。
 *  <li>每行的第一个整数大于前一行的最后一个整数。
 *
 * @author 张利红
 */
public class Q074Search2DMatrix {
    /**
     * 搜索二维矩阵
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
        // 原二维数组行
        int n = matrix.length;
        // 原二维数组列
        int m = matrix[0].length;
        // 看作一维数组开始位置
        int l = 0;
        // 看作一维数组终端位置
        int r = m * n - 1;
        while(l < r){
            int  mid = l +(r - l)/2;
            // 如果搜索到的值大于目标数，控制右边界，说明在左边
            if(matrix[mid/m][mid%m] >= target){r = mid;}
            // 否则在左边，控制左边界
            else l = mid + 1;
        }
        return matrix[r/m][r%m] == target;
    }
}

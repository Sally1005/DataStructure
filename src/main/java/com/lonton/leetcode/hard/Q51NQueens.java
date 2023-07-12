package com.lonton.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后 <p>
 * <ul>
 *     <li>按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *     <li>n皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *     <li>给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *     <li>每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * </ul>
 * 思路：<p>
 * <ol>
 *     <li>首先创建一个 N*N 的棋盘，可以用二维数组来表示盘格的每个位置；
 *     <li>从第一行开始，逐行放置皇后。对于每一行，依次尝试在每一列放置皇后，并检查是否满足约束条件（即该位置的行、列和对角线上【行、列值相加相等】都没有其他皇后）；
 *     <li>若满足约束条件，该位置标记为 1，则表示有皇后，递归处理下一行；
 *     <li>若不满足约束条件，该位置标记为 0，则表示为空，回溯上一行，尝试其他的列位置；
 *     <li>当所有行都放置了皇后时，问题得以解决。
 * </ol>
 *
 * @author 张利红
 */

public class Q51NQueens {
    // 创建一个 N*N 的棋盘
    private int[][] chessboard;
    // 棋盘大小
    private int N;
    // 存储每一行皇后的位置
    private int[] queens;

    /**
     * 求解 N皇后问题的方法
     *
     * @param n 皇后个数
     * @return 存储所有解的列表
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        chessboard = new int[n][n];
        queens = new int[n];
        N = n;
        // 从第一行开始，递归回溯穷举所有可能结果
        backtrack(0, result);
        return result;
    }

    /**
     * 递归回溯
     *
     * @param row    行
     * @param result 存储所有解的列表
     */
    private void backtrack(int row, List<List<String>> result) {
        // 完成返回
        if (row == N) {
            result.add(generateSolution());
            return;
        }

        // 遍历列
        for (int col = 0; col < N; col++) {
            if (isValidPosition(row, col)) {
                // 位置有效，标记为1
                chessboard[row][col] = 1;
                // 将第row行的皇后放置在第col列
                queens[row] = col;
                // 递归处理下一行
                backtrack(row + 1, result);
                // 重置标记
                chessboard[row][col] = 0;
            }
        }
    }

    /**
     * 判断行列位置上的皇后是否有效
     *
     * @param row 行
     * @param col 列
     * @return 判断行列位置上的皇后是否有效
     */
    private boolean isValidPosition(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 检查是否在同一列上有一个皇后
            if (chessboard[i][col] == 1) {
                return false;
            }
            // 检查是否在同一对角线上有一个皇后
            if (Math.abs(row - i) == Math.abs(col -  queens[i])) {
                return false;
            }
        }
        // 通过所有的检查，返回true表示当前位置合法
        return true;
    }

    /**
     * 生成结果字符串
     *
     * @return 符合条件的字符串集合
     */
    private List<String> generateSolution() {
        List<String> solution = new ArrayList<>();
        // 遍历行
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(); // 单线程（异步）
            // 遍历列
            for (int j = 0; j < N; j++) {
                // 'Q' 和 '.' 分别代表了皇后和空位
                sb.append(chessboard[i][j] == 1 ? "Q" : ".");
            }
            // 将字符串添加到符合条件的字符串集合中
            solution.add(sb.toString());
        }
        return solution;
    }
}

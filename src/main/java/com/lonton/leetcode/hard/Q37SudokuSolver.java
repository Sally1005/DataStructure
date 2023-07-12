package com.lonton.leetcode.hard;


/**
 * 37. 解数独<p>
 * <ul>
 *     <li>编写一个程序，通过填充空格来解决数独问题。数独的解法需 遵循如下规则：
 *     <li>数字 1-9 在每一行只能出现一次。
 *     <li>数字 1-9 在每一列只能出现一次。
 *     <li>数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *     <li>数独部分空格内已填入了数字，空白格用 '.' 表示。
 * </ul>
 * 思路：<p>
 * <ol>
 *     <li>首先创建一个 9*9 的数独盘面，可以用二维数组来表示盘格的每个位置，数组元素的值表示该位置的数字；
 *     <li> 从数独盘面的左上角开始，依次尝试填入数字1-9，并检查是否满足约束条件（即该位置的行、列和3x3小宫格内都没有相同的数字）；
 *     <li>若满足约束条件，将数字填入该位置，并递归地处理下一个位置；
 *     <li>若不满足约束条件，则回溯到上一个位置，尝试其他的数字；
 *     <li>当所有行都都填入了数字时，问题得以解决。
 * </ol>
 *
 * @author 张利红
 */
public class Q37SudokuSolver {
    /**
     * 解数独
     *
     * @param board 初始数独盘
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    /**
     * 递归判断是否解决数独
     *
     * @param board 初始数独盘
     * @return 是否解决数独
     */
    private boolean solve(char[][] board) {
        // 遍历行
        for (int row = 0; row < 9; row++) {
            // 遍历列
            for (int col = 0; col < 9; col++) {
                // 若数独盘位置为空，尝试添加1-9的数值到空白处
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        // 若满足数独规则，则添加到空白处
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            // 若已解决数独，返回true
                            if (solve(board)) {
                                return true;
                                // 若未能解决数独，将当前位置重新置为空格
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    // 若填入数字1到9都无法解决数独，返回false
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断填入数字是否满足数独规则
     *
     * @param board 初始数独盘
     * @param row   行
     * @param col   列
     * @param num   已有字符
     * @return 填入数字是否满足数独规则
     */
    private boolean isValid(char[][] board, int row, int col, char num) {
        // 遍历行
        for (int i = 0; i < 9; i++) {
            // 检查当前行是否已经存在数字 num
            if (board[i][col] == num) {
                return false;
            }
            // 检查当前列是否已经存在数字 num
            if (board[row][i] == num) {
                return false;
            }
            // 检查当前 3x3 小方格内是否已经存在数字 num
            // !!!行/列偏移量[(3 * (row / 3) / (3 * (col / 3)] + 行/列增量[(i / 3) / (i % 3)]
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}

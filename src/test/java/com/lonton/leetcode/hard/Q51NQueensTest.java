package com.lonton.leetcode.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 51. 测试 N 皇后
 * <ol>
 *     <li>当n=1时，只有一种解决方案,输出为 [["Q"]];
 *     <li>当n=2时，无解，因为皇后总会互相攻击,输出为 [[ ]];
 *     <li>当n=3时，无解，因为皇后总会互相攻击,输出为 [[ ]];
 *     <li>当n=4时，有两种解决方案,输出为 [[".Q..", "...Q", "Q...", "..Q."],["..Q.", "Q...", "...Q", ".Q.."]];
 *     <li>当n=5时，有五种解决方案,输出为 [["Q....", "..Q..", "....Q", ".Q...", "...Q."],......];
 *     <li>当n=6时，有六种解决方案,输出为 [[".Q....", "...Q..", ".....Q", "Q.....", "..Q...", "....Q."],......];
 *     <li>当n=7时，有40种解决方案;
 *     <li>当n=8时，有92种解决方案;
 *     <li>当n=9时，有352种解决方案。
 * </ol>
 *
 * @author 张利红
 */

public class Q51NQueensTest {

    Q51NQueens queens = new Q51NQueens();

    @Test
    public void test1() {
        List<List<String>> one = queens.solveNQueens(1);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Q")
        );
        Assertions.assertEquals(expected, one, "当n=1时,N皇后输出与预期不符。");
    }

    @Test
    public void test2() {
        List<List<String>> zero = queens.solveNQueens(2);
        Assertions.assertEquals(0, zero.size(), "当n=2时,N皇后输出与预期不符。");
    }

    @Test
    public void test3() {
        List<List<String>> zero = queens.solveNQueens(3);
        Assertions.assertEquals(0, zero.size(), "当n=3时,N皇后输出与预期不符。");
    }

    @Test
    public void test4() {
        List<List<String>> two = queens.solveNQueens(4);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        );
        Assertions.assertEquals(expected, two, "当n=4时,N皇后输出与预期不符。");
    }

    @Test
    public void test5() {
        List<List<String>> ten = queens.solveNQueens(5);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Q....", "..Q..", "....Q", ".Q...", "...Q."),
                Arrays.asList("Q....", "...Q.", ".Q...", "....Q", "..Q.."),
                Arrays.asList(".Q...", "...Q.", "Q....", "..Q..", "....Q"),
                Arrays.asList(".Q...", "....Q", "..Q..", "Q....", "...Q."),
                Arrays.asList("..Q..", "Q....", "...Q.", ".Q...", "....Q"),
                Arrays.asList("..Q..", "....Q", ".Q...", "...Q.", "Q...."),
                Arrays.asList("...Q.", "Q....", "..Q..", "....Q", ".Q..."),
                Arrays.asList("...Q.", ".Q...", "....Q", "..Q..", "Q...."),
                Arrays.asList("....Q", ".Q...", "...Q.", "Q....", "..Q.."),
                Arrays.asList("....Q", "..Q..", "Q....", "...Q.", ".Q...")
        );
        Assertions.assertEquals(expected, ten, "当n=5时,N皇后输出与预期不符。");
    }

    @Test
    public void test6() {
        List<List<String>> four = queens.solveNQueens(6);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q....", "...Q..", ".....Q", "Q.....", "..Q...", "....Q."),
                Arrays.asList("..Q...", ".....Q", ".Q....", "....Q.", "Q.....", "...Q.."),
                Arrays.asList("...Q..", "Q.....", "....Q.", ".Q....", ".....Q", "..Q..."),
                Arrays.asList("....Q.", "..Q...", "Q.....", ".....Q", "...Q..", ".Q....")
        );
        Assertions.assertEquals(expected, four, "当n=6时,N皇后输出与预期不符。");
    }

    @Test
    public void test7() {
        List<List<String>> result = queens.solveNQueens(7);
        Assertions.assertEquals(40, result.size(), "当n=7时,N皇后输出与预期不符。");
    }

    @Test
    public void test8() {
        List<List<String>> result = queens.solveNQueens(8);
        Assertions.assertEquals(92, result.size(), "当n=8时,N皇后输出与预期不符。");
    }

    @Test
    public void test9() {
        List<List<String>> result = queens.solveNQueens(9);
        Assertions.assertEquals(352, result.size(), "当n=9时,N皇后输出与预期不符。");
    }

}

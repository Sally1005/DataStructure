package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试判断二叉树是否是高度平衡的二叉树 <p/>
 * 将数组 [3,9,20,null,null,15,7] 构建成树，并判断该树是否为高度平衡的二叉树
 * 输出：true
 *
 * @author 张利红
 */
public class Q110BalancedBinaryTreeTest {
    @Test
    public void test() {
        Integer[] root = new Integer[]{3, 9, 20, null, null, 15, 7};
        boolean result = new Q110BalancedBinaryTree().isBalanced(BinaryTree.arrayToTree(root));

        Assertions.assertTrue(result, "NotTrue!");
    }
}

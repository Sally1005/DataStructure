package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


@Slf4j
public class Q101SymmetricBinaryTreeTest {
    /**
     *            1
     *          /  \
     *       2       2
     *     /  \    /  \
     *    3    4  4     3
     */
    @Test
    public void test() {
        /**
         * 输入：root = [1,2,2,3,4,4,3]
         * 输出：true
         */
        // 构建二叉树
        Q101SymmetricBinaryTree.TreeNode treeNode = new Q101SymmetricBinaryTree.TreeNode(1,
               new Q101SymmetricBinaryTree.TreeNode(2, new Q101SymmetricBinaryTree.TreeNode(3), new Q101SymmetricBinaryTree.TreeNode(4)),
                new Q101SymmetricBinaryTree.TreeNode(2, new Q101SymmetricBinaryTree.TreeNode(4), new Q101SymmetricBinaryTree.TreeNode(3))
        );

        // 断点
        boolean expected = true;
        boolean actual = Q101SymmetricBinaryTree.isSymmetric(treeNode);
        log.info("是镜像树吗-{}",actual);
        Assertions.assertSame(expected,actual);
    }
}

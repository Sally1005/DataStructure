package com.lonton.leetcode;

import org.junit.Test;

import static com.lonton.leetcode.Q226InvertBinaryTree.invertTree;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 测试翻转二叉树 <p/>
 * 输入：root = [2,1,3] <p/>
 * 输出：[2,3,1]
 * @author 张利红
 */
public class Q226InvertBinaryTreeTest {

    @Test
    public void test() {

        // 构建二叉树
        Q226InvertBinaryTree.TreeNode root = new Q226InvertBinaryTree.TreeNode(2);
        root.left = new Q226InvertBinaryTree.TreeNode(1);
        root.right = new Q226InvertBinaryTree.TreeNode(3);
        invertTree(root);

        // 断言
        assertEquals(1, root.right.val,"NotEquals");
        assertEquals(2, root.val,"NotEquals");
        assertEquals(3, root.left.val,"NotEquals");


    }
}

package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 654. 测试求最大二叉树
 * <ol>
 * <li>（空树）：将数组 [ ],构建成二叉树,并判断是否符合预期输出[null]。
 * <li>（仅根节点）：将数组 [1],构建成二叉树,并判断是否符合预期输出[1,null,null]。
 * <li>（左树左枝）：将数组 [2,4,3,5],构建成二叉树,并判断是否符合预期输出[5,4,null,2,3,null]。
 * <li>（右树右枝）：将数组 [3,2,1],构建成二叉树,并判断是否符合预期输出[3,null,2,null,1]。
 * <li>（右树左枝）：将数组 [5,2,3,4 ],构建成二叉树,并判断是否符合预期输出[5,null,4,3,null,2,null]。
 * <li>（左树右枝）：将数组 [5,4,2,6],构建成二叉树,并判断是否符合预期输出[6,5,null,null,4,null,2]。
 * <li>（左树右树）：将数组 [3,2,1,6,0,5],构建成二叉树,并判断是否符合预期输出[6,3,5,null,2,0,null,null,1]。
 * </ol>
 *
 * @author 张利红
 */
public class Q654MaximumBinaryTreeTest {
    @Test
    public void testWithEmptyTree() {
        Assertions.assertNull(
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{}),
                "当二叉树构建为空树时，求最大二叉树计算错误。"
        );
    }
    @Test
    public void testWithSingleNumber() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{1});
        Assertions.assertEquals(
                root,
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{1}),
                "当二叉树构建仅有根节点时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testLeftSubtreeWithLeftBranch() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{5,4,null,2,3});
        Assertions.assertEquals(
                root,
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{2, 4, 3, 5}),
                "当二叉树构建为左树左枝时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testRightSubtreeWithRightBranch() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{3,null,2,null,1});
        Assertions.assertEquals(
                root,
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1}),
                "当二叉树构建为右树右枝时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testRightSubtreeWithLeftBranch() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{5,null,4,3,null,2});
        Assertions.assertEquals(
                root,
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{5, 2, 3, 4}),
                "当二叉树构建为右树左枝时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testLeftSubtreeWithRightBranch() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{6,5,null,null,4,null,2});
        Assertions.assertEquals(
                root,
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{5, 4, 2, 6}),
                "当二叉树构建为左树右枝时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testLeftSubtreeWithRightSubtree() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{6,3,5,null,2,0,null,null,1});
        Assertions.assertEquals(
                root,
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}),
                "当二叉树构建为均有左树右树时，求最大二叉树计算错误。"
        );
    }

}





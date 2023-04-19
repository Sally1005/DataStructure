package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * 226. 测试翻转二叉树
 * <ol>
 * <li> 将数组 [4,2,7,1,3,6,9] 构建成树(满子节点),并判断翻转后二叉树节点是否符合预期。
 * <li> 将数组 [4,2,7,1] 构建成树(半子节点),并判断翻转后二叉树节点是否符合预期。
 * </ol>
 *
 * @author 张利红
 */
public class Q226InvertBinaryTreeTest {

    @Test
    public void testFullChildNode() {

        // 构建二叉树
        Integer[] nums = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode<Integer>  root1 = new TreeNode<Integer>().arrayToTree(nums);

        // 翻转树
        new Q226InvertBinaryTree().invertTree(root1);

        // 断言
        Assertions.assertEquals(2, root1.getRight().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(1, root1.getRight().getRight().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(3, root1.getRight().getLeft().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(4, root1.getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(7, root1.getLeft().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(9, root1.getLeft().getLeft().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(6, root1.getLeft().getRight().getVal(), " 翻转后树的节点与预期不相等。");
    }
    @Test
    public void testHalfChildNode() {

        // 构建二叉树
        Integer[] nums2 = new Integer[]{4, 2, 7, 1};
        TreeNode<Integer>  root2 = new TreeNode<Integer>().arrayToTree(nums2);

        // 翻转树
        new Q226InvertBinaryTree().invertTree(root2);

        // 断言

        Assertions.assertEquals(2, root2.getRight().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(1, root2.getRight().getRight().getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(4, root2.getVal(), " 翻转后树的节点与预期不相等。");
        Assertions.assertEquals(7, root2.getLeft().getVal(), " 翻转后树的节点与预期不相等。");
    }
}

package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * 101. 测试二叉树是否为对称的树
 * <ul>
 * <li> 将数组 nums = [1,2,2,3,4,4,3] 构建成二叉树，并检验 二叉树是否为对称的树，预期值为true。
 * </ul>
 *
 * @author 张利红
 */
public class Q101SymmetricBinaryTreeTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        TreeNode root = new TreeNode<>().arrayToTree(nums);

        Assertions.assertTrue(new Q101SymmetricBinaryTree().isSymmetric(root),
                "该树不是镜像树。");
    }
}

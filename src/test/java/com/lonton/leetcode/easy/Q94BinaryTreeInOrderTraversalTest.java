package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试二叉树中序遍历 <p/>
 * 将数组 nums = [1,null,2,3] 构建成二叉树，并判断输出的值是否为预期的[1,3,2]。
 *
 * @author 张利红
 */

public class Q94BinaryTreeInOrderTraversalTest {
    @Test
    public void test() {
        Integer[] nums = new Integer[]{1, null, 2, 3};
         TreeNode root = TreeNode.arrayToTree(nums);

        Assertions.assertArrayEquals(new Integer[]{1, 3, 2},
                Q94BinaryTreeInOrderTraversal.inorderTraversal(root).toArray(),
                "比对失败，二叉树中序遍历出的数组有问题。");
    }

}

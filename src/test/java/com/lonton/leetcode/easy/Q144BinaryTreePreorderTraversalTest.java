package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 144. 测试二叉树前序遍历
 * <ul>
 * <li> 将数组 nums = [1,null,2,3] 构建成二叉树，并判断输出的值是否为预期的[1,2,3]。
 * </ul>
 *
 * @author 张利红
 */
public class Q144BinaryTreePreorderTraversalTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, null, 2, 3};
        TreeNode<Integer>  root = TreeNode.arrayToTree(nums);

        Assertions.assertArrayEquals(new Integer[]{1, 2, 3},
               new Q144BinaryTreePreorderTraversal().preorderTraversal(root).toArray(),
                "比对失败，二叉树前序遍历出的数组有问题。");
    }

}

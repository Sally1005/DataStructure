package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试求完全二叉树的节点个数  <p/>
 * 示例1：将数组 [1,2,3,4,5,6],构建成一棵完全二叉树,并判断完全二叉树的节点个数为 6；
 * 示例2：将数组 [1,2,3,4,5,6,7],构建成一棵完全二叉树,并判断完全二叉树的节点个数为 7；
 * 示例3：将数组 [],构建成一棵完全二叉树,并判断完全二叉树的节点个数为 0。
 *
 * @author 张利红
 */
public class Q222CountCompleteTreeNodesTest {

    @Test
    public void test1() {
        // 构建完全二叉树
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
        TreeNode root = TreeNode.arrayToTree(nums);

        int result = new Q222CountCompleteTreeNodes().countNodes(root);

        // 断言
        Assertions.assertEquals(6, result, "完全二叉树的节点个数计算错误。");
    }

    @Test
    public void test2() {
        // 构建完全二叉树
        Integer[] nums2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root2 = TreeNode.arrayToTree(nums2);

        int result2 = new Q222CountCompleteTreeNodes().countNodes(root2);

        // 断言
        Assertions.assertEquals(7, result2, "完全二叉树的节点个数计算错误。");

    }

    @Test
    public void test3() {
        // 构建完全二叉树
        Integer[] nums3 = new Integer[0];
        TreeNode root3 = TreeNode.arrayToTree(nums3);

        int result3 = new Q222CountCompleteTreeNodes().countNodes(root3);

        // 断言
        Assertions.assertEquals(0, result3, "完全二叉树的节点个数计算错误。");
    }
}

package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 222. 测试求完全二叉树的节点个数
 * <ol>
 * <li> (不满完全二叉树）：将数组 [1,2,3,4,5,6],构建成一棵完全二叉树,并判断完全二叉树的节点个数为 6；
 * <li> (满完全二叉树）：将数组 [1,2,3,4,5,6,7],构建成一棵完全二叉树,并判断完全二叉树的节点个数为 7；
 * <li> (空完全二叉树）：将数组 [],构建成一棵完全二叉树,并判断完全二叉树的节点个数为 0。
 * <li> (完全二叉树为null）：判断完全二叉树的节点个数为 0。
 * </ol>
 *
 * @author 张利红
 */
public class Q222CountCompleteTreeNodesTest {
    @Test
    public void testNotFUllBinaryTree() {
        // 构建完全二叉树
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6};
        TreeNode root = new TreeNode<>().arrayToTree(nums);

        int result = new Q222CountCompleteTreeNodes().countNodes(root);

        // 断言
        Assertions.assertEquals(6, result, "当完全二叉树为不满完全二叉树时的节点个数计算错误。");
    }

    @Test
    public void testFUllBinaryTree() {
        // 构建完全二叉树
        Integer[] nums2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root2 = new TreeNode<>().arrayToTree(nums2);

        int result2 = new Q222CountCompleteTreeNodes().countNodes(root2);

        // 断言
        Assertions.assertEquals(7, result2, "当完全二叉树为满完全二叉树时的节点个数计算错误。");

    }

    @Test
    public void testEmpty() {
        // 构建完全二叉树
        Integer[] nums3 = new Integer[0];
        TreeNode root3 = new TreeNode<>().arrayToTree(nums3);

        int result3 = new Q222CountCompleteTreeNodes().countNodes(root3);

        // 断言
        Assertions.assertEquals(0, result3, "当完全二叉树为空完全二叉树时的节点个数计算错误。");
    }

    @Test
    public void testNull() {

        int result4 = new Q222CountCompleteTreeNodes().countNodes(null);

        // 断言
        Assertions.assertEquals(0, result4, "当完全二叉树为null时的节点个数计算错误。");
    }
}

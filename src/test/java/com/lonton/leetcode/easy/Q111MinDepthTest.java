package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 111. 测试求二叉树的最小深度
 * <ol>
 * <li> 将数组 nums1 = [3,9,20,null,null,15,7] 构建为二叉树，并校验二叉树最小深度是否为 2。
 * <li> 将数组 nums2 = [2,null,3,null,4,null,5,null,6]构建为二叉树,并校验二叉树最小深度是否为 5。
 * <li> 将数组 nums3 = [2,null,3,null,4,1,5,null,7]构建为二叉树,并校验二叉树最小深度是否为 4。
 * </ol>
 *
 * @author 张利红
 */
public class Q111MinDepthTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums1 = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> tree1 = new TreeNode<Integer>().arrayToTree(nums1);

        Assertions.assertEquals(2, new Q111MinDepth().minDepth(tree1),
                " 比对失败，最小深度计算错误错误。");

        Integer[] nums2 = new Integer[]{2, null, 3, null, 4, null, 5, null, 6};
        TreeNode<Integer>  tree2 = new TreeNode<Integer>().arrayToTree(nums2);

        Assertions.assertEquals(5, new Q111MinDepth().minDepth(tree2),
                "比对失败，最小深度计算错误错误。");

        Integer[] nums3 = new Integer[]{2, null, 3, null, 4, 1, 5, null, 7};
        TreeNode<Integer>  tree3 = new TreeNode<Integer>().arrayToTree(nums3);

        Assertions.assertEquals(4, new Q111MinDepth().minDepth(tree3),
                "比对失败，最小深度计算错误错误。");
    }

}

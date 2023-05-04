package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 530. 测试 求 二叉搜索树的最小绝对差，即 求 二叉搜索树节点最小距离
 * <ol>
 * <li> 将数组 nums = [4,2,6,1,3] 构建成二叉树，并判断输出的值是否为预期值 1。
 * <li> 将数组 nums2 = [1,0,48,null,null,12,49] 构建成二叉树，并判断输出的值是否为预期值 1。
 * </ol>
 *
 * @author 张利红
 */
public class Q530MinimumAbsoluteDifferenceInBSTTest {

    @Test
    public void testLeftBST() {
        Integer[] nums = new Integer[]{4, 2, 6, 1, 3};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);

        Assertions.assertEquals(1,
                new Q530MinimumAbsoluteDifferenceInBST().minDiffInBST(root),
                "比对失败，二叉搜索树的最小绝对差求取值有误。");
    }

    @Test
    public void testRightBst() {
        Integer[] nums = new Integer[]{1, 0, 48, null, null, 12, 49};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);

        Assertions.assertEquals(1,
               new Q530MinimumAbsoluteDifferenceInBST().minDiffInBST(root),
                "比对失败，二叉搜索树的最小绝对差求取值有误。");
    }
}


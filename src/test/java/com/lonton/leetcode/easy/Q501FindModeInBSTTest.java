package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试 求 二叉搜索树中的众数<p/>
 * 示例1：将数组 nums = [1,null,2,2] 构建成二叉树，并判断输出的值是否为预期值 2。
 * 示例2：将数组 nums2 = [] 构建成二叉树，并判断输出的值是否为预期值 []。
 *
 * @author 张利红
 */
public class Q501FindModeInBSTTest {

    @Test
    public void test() {
        Integer[] nums = new Integer[]{1, null, 2, 2};
        TreeNode root = TreeNode.arrayToTree(nums);

        Assertions.assertArrayEquals(new int[]{2},
                Q501FindModeInBST.findMode(root),
                "比对失败，叉搜索树中的众数求值有误。");
    }

    @Test
    public void test2() {
        Integer[] nums = new Integer[0];
        TreeNode root = TreeNode.arrayToTree(nums);

        Assertions.assertArrayEquals(new int[0],
                Q501FindModeInBST.findMode(root),
                "比对失败，叉搜索树中的众数求值有误。");
    }
}

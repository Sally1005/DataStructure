package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * 654. 最大二叉树<p/>
 * 给定一个不重复的整数数组 nums 。
 * 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。<p/>
 * 思路：<p/>
 * 1. 首先是确定根节点位置(等同于在一组数组中找到最大值或者是最大值索引); <p/>
 * 2. 然后再在余下的左边数组和右边数组中继续递归 确定左子树和右子树。 <p/>
 *
 * @author 张利红
 */
public class Q654MaximumBinaryTree {

    /**
     * 求最大二叉树
     *
     * @param nums 不重复的整数数组
     * @return 最大二叉树
     */
    public TreeNode<Integer> constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxValueIndex = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValueIndex = i;
                maxValue = nums[i];
            }
        }
        // 递归构建二叉树
        TreeNode<Integer> root = new TreeNode<>(maxValue);
        // 复制数组，比较提交结果，可以看到运行时间会变长，内存减少了
        root.setLeft(constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxValueIndex)));
        root.setRight(constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxValueIndex + 1, nums.length)));
        return root;
    }

}

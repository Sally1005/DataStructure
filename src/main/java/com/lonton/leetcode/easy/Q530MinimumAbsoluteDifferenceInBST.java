package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题 求 530. 二叉搜索树的最小绝对差 同 783. 二叉搜索树节点最小距离 <p/>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。<p/>
 * 差值是一个正数，其数值等于两值之差的绝对值。<p/>
 * 思路：<p/>
 * 递归 <p/>
 * !!! 看清题目，指的是“任意两不同节点值”,而不是相邻的两个节点的值。看错后再递归，总会有十几个测试案例无法通过。<p/>
 * 根据BST的特性，中序遍历后的树，即为一个有序的升序数组。<p/>
 * 在此基础上只需遍历集合，比较数组中前后两个数的大小再和前一次的最小绝对差比较即可。<p/>
 *
 * @author 张利红
 */
public class Q530MinimumAbsoluteDifferenceInBST {
    /**
     * 求BST最小绝对差
     *
     * @param root 根节点
     * @return 最小绝对差
     */
    public int minDiffInBST(TreeNode<Integer>  root) {
        int minDiff = Integer.MAX_VALUE;
        List<Integer> val = new ArrayList<>();
        // 中序遍历
        new Q094BinaryTreeInOrderTraversal().inorder(root, val);
        // 找最小绝对差
        for (int i = 0; i < val.size() - 1; i++) {
            minDiff = Math.min(val.get(i + 1) - val.get(i), minDiff);
        }
        return minDiff;
    }
}

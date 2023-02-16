package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 404. 左叶子之和 <p/>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。<p/>
 *
 * @author 张利红
 */
public class Q404SumOfLeftLeaves extends TreeNode {

    /**
     * 左叶子之和
     *
     * @param root 根节点
     * @return 所有左叶子之和
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 叶子节点
        if (root.getLeft() != null && root.getLeft().getLeft() == null && root.getLeft().getRight() == null) {
            return (Integer)root.getLeft().getVal() + (Integer)sumOfLeftLeaves(root.getRight());
        }
        return sumOfLeftLeaves(root.getLeft()) + sumOfLeftLeaves(root.getRight());
    }
}

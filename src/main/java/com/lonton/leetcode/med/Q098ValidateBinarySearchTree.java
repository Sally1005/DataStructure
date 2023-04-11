package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 98. 验证二叉搜索树 <p/>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。<p/>
 * 有效 二叉搜索树定义如下：<p/>
 * 节点的左子树只包含 小于 当前节点的数。<p/>
 * 节点的右子树只包含 大于 当前节点的数。<p/>
 * 所有左子树和右子树自身必须也是二叉搜索树。<p/>
 * 思路：<p/>
 * 递归 <p/>
 * 分别判断左子树和右子树是否满足构建成二叉搜索树条件
 *
 * @author 张利红
 */
public class Q098ValidateBinarySearchTree {
    /**
     * 验证二叉搜索树
     *
     * @param root 根节点
     * @return 是否为有效二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * @param node 当前节点
     * @param min  最小值
     * @param max  最大值
     * @return 验证是否为二叉搜索树
     */
    public boolean valid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        // 当前节点小于最小值 或 当前节点大于最大值
        if ((Integer) node.getVal() <= min || (Integer) node.getVal() >= max) {
            return false;
        }
        // 递归判断左、右子树
        return valid(node.getLeft(), min, (Integer) node.getVal()) && valid(node.getRight(), (Integer) node.getVal(), max);
    }
}

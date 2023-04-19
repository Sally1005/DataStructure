package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 111. 二叉树的最小深度<p/>
 * 二叉树的深度为根节点到最近叶子节点的最长路径上的节点数。<p/>
 *
 * @author 张利红
 */
public class Q111MinDepth{
    /**
     * 求二叉树的最小深度
     *
     * @param root 根节点
     * @return 二叉树的最小深度值
     */
    public int minDepth(TreeNode<Integer> root) {
        // 根节点为null,空树
        if (root == null) {
            return 0;
        }
        // 递归左子树的深度
        int leftMinDepth = minDepth(root.getLeft());
        // 递归右子树的深度
        int rightMinDepth = minDepth(root.getRight());
        // 左右子树均不为空
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        // 左空右不空，返回左子树深度
        if (root.getLeft() == null && root.getRight() != null) {
            return rightMinDepth + 1;
        }
        // 右空左不空，返回右子树深度
        if (root.getLeft() != null && root.getRight() == null) {
            return leftMinDepth + 1;
        }
        // 比较左右子树的深度
        return (leftMinDepth > rightMinDepth) ? (rightMinDepth + 1) : (leftMinDepth + 1);
    }

}

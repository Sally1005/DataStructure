package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 437. 路径总和 III<p/>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。<p/>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。<p/>
 * 思路：
 * 直接递归，但是由于起始节点不一定都是从根节点开始。如果恰好有一个节点值等于targetSum，这条链还需要继续往下计算节点值。
 *
 * @author 张利红
 */
public class Q437PathSumIII {
    // 路径数目
    private int res = 0;

    /**
     * 求路径数目
     *
     * @param root      根节点
     * @param targetSum 节点目标和
     * @return 路径数目
     */
    public int pathSum(TreeNode<Integer> root, int targetSum) {
        if (root != null) {
            recurve(root, targetSum);
            pathSum(root.getLeft(), targetSum);
            pathSum(root.getRight(), targetSum);
        }
        return res;
    }

    /**
     * 递归计算
     *
     * @param treeNode 任意起点节点
     * @param sum      节点值之和
     */
    public void recurve(TreeNode<Integer> treeNode, long sum) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.getVal() == sum) {
            res++;
        }
        recurve(treeNode.getLeft(), sum - treeNode.getVal());
        recurve(treeNode.getRight(), sum - treeNode.getVal());
    }
}

package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 112. 路径总和 <p/>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。 <p/>
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。 <p/>
 * 如果存在，返回 true ；否则，返回 false 。<p/>
 * 叶子节点 是指没有子节点的节点。<p/>
 * 思路：
 * 递归计算每一条路径和，将路径总和和 targetSum 进行比较。
 *
 * @author 张利红
 */
public class Q112PathSum {

    /**
     * 判断是否有路径总和
     *
     * @param root      根节点
     * @param targetSum 目标和
     * @return boolean
     */
    public  boolean hasPathSum(TreeNode<Integer>  root, int targetSum) {
        // flag[0] = 0 路径总和不等  = 1 有路径总和相等
        int[] flag = {0};
        recurve(root, 0, targetSum, flag);
        return flag[0] == 1;
    }

    /**
     * 递归计算
     *
     * @param treeNode  当前递归到的节点
     * @param preSum    递归到当前节点之前的所有父节点之和
     * @param targetSum 目标和
     * @param flag      结果值
     */
    static void recurve(TreeNode<Integer>  treeNode, Integer preSum, int targetSum, int[] flag) {
        // flag[0] == 1 或当前递归到的节点为空，直接跳出方法
        if (flag[0] == 1 || treeNode == null) {
            return;
        }
        preSum += treeNode.getVal();
        // 左递归路径值
        recurve(treeNode.getLeft(), preSum, targetSum, flag);
        // 右递归路径值
        recurve(treeNode.getRight(), preSum, targetSum, flag);
        // 判断是否找到等于目标和的路径 (叶子节点)
        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            if (preSum == targetSum) {
                flag[0] = 1;
            }
        }
    }
}

package com.lonton.leetcode.med;

/**
 * 437. 路径总和 III<p/>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。<p/>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。<p/>
 * 思路：
 * 直接递归，但是由于起始节点不一定都是从根节点开始。如果恰好有一个节点值等于targetSum，这条链还需要继续往下计算节点值。
 * @author 张利红
 */
public class Q437PathSumIII {

    // 路径数目
    static int res = 0;
    /**
     * 求路径数目
     * @param root 根节点
     * @param targetSum 节点目标和
     * @return 路径数目
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root != null){
            recurve(root,targetSum);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        return res;
    }

    /**
     * 递归计算
     * @param treeNode 任意起点节点
     * @param sum 节点值之和
     */
    public static void recurve(TreeNode treeNode, long sum){
        if(treeNode == null){
            return;
        }
        if (treeNode.val == sum){
            res ++;
        }
        recurve(treeNode.left,sum- treeNode.val);
        recurve(treeNode.right,sum- treeNode.val);
    }









    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * <br/>
     * 树中节点数目在范围 [0, 1000] 内<br/>
     * -100 <= Node.val <= 1000
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

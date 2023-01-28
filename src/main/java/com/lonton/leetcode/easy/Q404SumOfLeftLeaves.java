package com.lonton.leetcode.easy;

/**
 * 404. 左叶子之和 <p/>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。<p/>
 * @author 张利红
 */
public class Q404SumOfLeftLeaves {

    /**
     * 左叶子之和
     * @param root 根节点
     * @return 所有左叶子之和
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 树中节点数目在范围 [1, 1000] 内<br/>
     * -1000 <= Node.val <= 1000
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

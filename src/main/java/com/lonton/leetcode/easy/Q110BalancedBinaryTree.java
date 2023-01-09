package com.lonton.leetcode.easy;
/**
 * 110. 给定一个二叉树，判断它是否是高度平衡的二叉树。<p/>
 * 一棵高度平衡二叉树定义为：<p/>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。<p/>
 * 思路：<p/>
 * 与求二叉树的最大深度类似，差别在于需要对每一层的每个节点的左边深度和右边深度做比较 <p/>
 * 需要及时记录每个节点左右子树的差值
 * @author 张利红
 */
public class Q110BalancedBinaryTree {
    /**
     * 判断它是否是高度平衡的二叉树
     * @param root 根节点
     * @return 是否
     */
    public boolean isBalanced(TreeNode root) {
        // flag[0] = 0 是平衡高度的二叉树  =1 非衡高度的二叉树
        int flag[]= {0};
        maxDepth(root, flag);
        return flag[0] == 0;
    }
    /**
     * 求二叉树的最大深度
     * @param root 根节点
     * @return 二叉树的最大深度值
     */
    public  int maxDepth(TreeNode root,int[] flag){
        // 根节点为null,空树
        if(root == null){
            return 0;
        }
        // 递归左子树的深度
        int leftMaxDepth = maxDepth(root.left,flag);
        // 递归右子树的深度
        int rightMaxDepth = maxDepth(root.right,flag);
        // 比较左右两个子树的高度差的绝对值，对flag重新赋值
        if (leftMaxDepth - rightMaxDepth > 1 || rightMaxDepth - leftMaxDepth > 1) {
            flag[0] = 1;
        }
        // 比较左右子树的深度
        return  (leftMaxDepth > rightMaxDepth) ? (leftMaxDepth + 1 ): (rightMaxDepth + 1) ;
    }



    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * <br/>
     * 树中节点数目在范围 [0, 0, 5000] 内
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

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

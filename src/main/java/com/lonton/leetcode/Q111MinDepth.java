package com.lonton.leetcode;
/**
 * 二叉树的最小深度
 * 二叉树的深度为根节点到最近叶子节点的最长路径上的节点数。
 * @author 张利红
 */
public class Q111MinDepth {
    /**
     * 求二叉树的最小深度
     * @param root 根节点
     * @return 二叉树的最小深度值
     */
    public  int minDepth(TreeNode root){
        // 根节点为null,空树
        if(root == null){
            return 0;
        }
        // 递归左子树的深度
        int leftMinDepth = minDepth(root.left);
        // 递归右子树的深度
        int rightMinDepth = minDepth(root.right);
        // 左右子树均不为空
        if(root.left == null && root.right == null){
            return 1;
        }
        // 左空右不空，返回左子树深度
        if(root.left == null && root.right != null){
            return  rightMinDepth + 1 ;
        }
        // 右空左不空，返回右子树深度
        if(root.left != null && root.right == null){
            return  leftMinDepth + 1 ;
        }
        // 比较左右子树的深度
        return (leftMinDepth > rightMinDepth) ? (rightMinDepth + 1) : (leftMinDepth + 1);


    }



    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * <br/>
     * 树中节点数目在范围 [0, 100] 内<br/>
     * -100 <= Node.val <= 100
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

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

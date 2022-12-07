package com.lonton.leetcode;

/**
 * 101. 对称的树 <p/>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @author 张利红
 */
public class Q101SymmetricBinaryTree {

    /**
     * 判断是否为对称的树
     * <br/>
     * @return boolean
     * <br/>
     * 主要是判断左右子树是否对称，由示例图行可知：<br/>
     * 左子树的遍历规律可以视为 “根-左-右”,右子树的遍历规律可以视为 “根-右-左”
     */
    public static boolean isSymmetric(TreeNode root){
        StringBuffer result1 = new StringBuffer();
        StringBuffer result2 = new StringBuffer();
        nextNode(root.left,result1,1);
        nextNode(root.right,result2,2);
        return result1.toString().equals(result2.toString());


    }

    public static void nextNode(TreeNode root, StringBuffer s,int type) {
        // 判断根节点是否存在，
        if(root == null){
            return;
        }else {
            s.append(root.val).append("-");
        }
        if(type == 1){
            // 判断是否有左节点
            if (root.left != null) {
                nextNode(root.left, s,1);
            }else {
                s.append("-");
            }
            // 判断是否有右节点
            if (root.right != null) {
                nextNode(root.right, s,1);
            }else {
                s.append("-");
            }
        }else {
            // 判断是否有右节点
            if (root.right != null) {
                nextNode(root.right, s,1);
            }else {
                s.append("-");
            }
            // 判断是否有左节点
            if (root.left != null) {
                nextNode(root.left, s,1);
            }else {
                s.append("-");
            }
        }

    }
















    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 两棵树上的节点数目都在范围 [1, 1000] 内<br/>
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }
}

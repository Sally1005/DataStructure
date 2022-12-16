package com.lonton.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历 <p/>
 * @author 张利红
 */
public class Q94BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
         // 定义list集合，存储返回对象
        List<Integer> vals = new ArrayList<>();
        if(root == null){
            return vals;
        }
         // 递归遍历数据
        inorder(root, vals);
        return vals;
    }


    /**
     * 递归遍历下一个节点 <br/>
     * 左->根->右 <br/>
     * @param root 根节点 <br/>
     * @param vals list集合容器
     */
    public static void inorder(TreeNode root, List<Integer> vals) {
         // 判断是否有左节点
        if (root.left != null) {
            inorder(root.left, vals);
        }
         // 判断当前左节点是否遍历完或者说是左节点根本不存在
        vals.add(root.val);
         // 判断是否有右节点
        if (root.right != null) {
            inorder(root.right, vals);
        }
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

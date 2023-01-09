package com.lonton.leetcode.easy;


import com.lonton.binarytree.pojo.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 226. 翻转二叉树 <p/>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。<p/>
 * 思路：<p/>
 * 在遍历过程中将左右节点位置的值进行交换，类似于冒泡排序。
 * @author 张利红
 */
public class Q226InvertBinaryTree {

    /**
     * 翻转二叉树
     * @param root 根节点
     * @return 根节点
     */
//    public static TreeNode invertTree(TreeNode root) {
//        // 遍历
//        preorder(root);
//        return root ;
//
//    }
//
//    /**
//     * 递归遍历下一个节点
//     * @param root 根节点
//     */
//    static void preorder(TreeNode root){
//        // 根节点为空
//        if (root == null){
//            return ;
//        }
//        // 临时存储左(右)节点值
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        // 遍历
//        preorder(root.left);
//        preorder(root.right);
//
//    }

    public static TreeNode invertTree(TreeNode root) {

        if(root != null) {
            swap(root);
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    /**
     * 节点交换
     * @param root
     * @return
     */
    private static TreeNode swap(TreeNode root) {
        // 临时存储左(右)节点值
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

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

package com.lonton.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径 <p/>
 * 给你一个二叉树的根节点 ，按 任意顺序，返回所有从根节点到叶子节点的路径。<p/>
 * 思路：<p/>
 * 分为两种情况，一种是当前节点为叶子节点，则直接输出；二是非叶子节点，则继续进行递归。
 * @author 张利红
 */
public class Q257AllPathsToBinaryTrees {

    /**
     * 二叉树所有路径
     * @param root 根节点
     * @return list集合
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(root,list,sb);
        return list;
    }

    /**
     * 深度优先遍历
     * @param root 根节点
     * @param list 集合
     * @param sb 字符串缓冲
     */
    public static void dfs(TreeNode root ,List<String> list , StringBuffer sb ){
        if(root == null){
            return;
        }
        sb.append("->").append(root.val);

        // 叶子节点
        if (root.left == null && root.right == null){
            list.add(sb.substring(2));
        }

        dfs(root.left,list,new StringBuffer(sb));
        dfs(root.right,list,new StringBuffer(sb));
    }










    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 树中节点数目在范围 [1, 100] 内<br/>
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

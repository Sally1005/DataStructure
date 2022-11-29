package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 100. 相同的树 <p/>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。<p/>
 * @author 张利红
 */
@Slf4j
public class _100_SameTree {
    /**
     * 判断是否为相同的树
     * <br/>
     * @return boolean
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuffer result1 = new StringBuffer();
        StringBuffer result2 = new StringBuffer();
        // 将遍历的根节点放入字符串缓冲区内
        nextNode(p,result1);
        nextNode(q,result2);
        return result1.toString().equals(result2.toString());

    }

    /**
     * 递归遍历下一个节点 <br/>
     * @param root 根节点 <br/>
     * @param s 字符串缓冲区
     */
    public static void nextNode(TreeNode root, StringBuffer s) {
        // 判断根节点是否存在，
        if(root == null){
            return;
        }else {
            s.append(root.val).append("-");
        }
        // 判断是否有左节点
        if (root.left != null) {
            nextNode(root.left, s);
        }else {
            s.append("-");
        }
        // 判断是否有右节点
        if (root.right != null) {
            nextNode(root.right, s);
        }else {
            s.append("-");
        }
    }



    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 两棵树上的节点数目都在范围 [0, 100] 内<br/>
     * -104 <= Node.val <= 104
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

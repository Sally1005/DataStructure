package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 100. 相同的树 <p/>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。<p/>
 * @author 张利红
 */
@Slf4j
public class Q100SameTree {
    /**
     * 判断是否为相同的树
     * <br/>
     * @return boolean
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
         // 如果两棵树的根节点都为空，那么它们为相同的树
        if(p == null && q == null){
            return true;
        }
         // 如果两棵树要么一棵树根节点为空，要么另一棵树根节点不为空，不是相同的树（上面已对都为空的情况进行判断）
        if(p == null || q == null){
            return false;
        }
         // 排除不相等的情况，再讨论两棵树相同情况下的条件
      return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));

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

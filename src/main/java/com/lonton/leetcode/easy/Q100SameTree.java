package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树 <p/>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。<p/>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。<p/>
 *
 * @author 张利红
 */
public class Q100SameTree extends TreeNode {
    /**
     * 判断是否为相同的树
     * <br/>
     *
     * @return boolean
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        /**
         * 法一：递归
         */
//        // 如果两棵树的根节点都为空，那么它们为相同的树
//        if (p == null && q == null) {
//            return true;
//        }
//        // 如果两棵树要么一棵树根节点为空，要么另一棵树根节点不为空，不是相同的树（上面已对都为空的情况进行判断）
//        if (p == null || q == null) {
//            return false;
//        }
//        // 排除不相等的情况，再讨论两棵树相同情况下的条件
//        return (p.getVal() == q.getVal() && isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight()));


        /**
         * 法二： 迭代（荐）
         */
        // 如果两棵树的根节点都为空，那么它们为相同的树
        if (p == null && q == null) return true;
        // 如果两棵树的任何一个根节点为空，那么它们不相同
        if (p == null || q == null) return false;
        // 创建一个队列，两两比较节点，相同的则弹出
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 根节点入队,队列先进先出
        queue.add(p);
        queue.add(q);
        // 当队列为空时，结束循环
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 防止空指针异常
            if (left == null && right == null) continue;

            if (left == null || right == null) return false;
            if (left.getVal() != right.getVal()) return false;
            queue.add(left.getLeft());
            queue.add(right.getLeft());
            queue.add(left.getRight());
            queue.add(right.getRight());
        }
        return true;
    }

}

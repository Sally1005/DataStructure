package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 222. 完全二叉树的节点个数 <p/>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。<p/>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。<p/>
 * 思路：<p/>
 * 考虑四种情况：
 * 1. 节点为空；
 * 2. 为满二叉树（完全二叉树的特殊情况）---比较左右子树的高度是否相等----满二子树的节点公式 2*k-1，(k为以根节点为树的高度)；
 * 3. 不满完全二叉树 ----左子树的节点个数（上一层的右子树肯定是满的）+ 递归右子树的节点个数 + 1(根节点)。
 * 4. 完全二叉树为null
 *
 * @author 张利红
 */
public class Q222CountCompleteTreeNodes {
    /**
     * 求完全二叉树的节点个数
     *
     * @param root 根节点
     * @return 完全二叉树的节点个数
     */
    public int countNodes(TreeNode<Integer> root) {
        if (root == null) return 0;

        TreeNode<Integer> left = root.getLeft();
        TreeNode<Integer> right = root.getRight();
        int leftHeight = 0;
        int rightHeight = 0;
        while (left != null) {
            left = left.getLeft();
            leftHeight++;
        }
        while (right != null) {
            right = right.getRight();
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            // 位运算示例： 3 << 2 ---在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
            return (2 << leftHeight) - 1;
        }

        return countNodes(root.getLeft()) + countNodes(root.getRight()) + 1;

        // 极为精简的递归代码
        // return  root == null ? 0: countNodes(root.getLeft()) + countNodes(root.getRight()) + 1;
    }
}

package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 104. 二叉树的最大深度 ~~ 求树的高度 <p/>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。<p/>
 * 树的深度和高度的区别：<p/>
 * 对于整棵树来说，最深的叶结点的深度就是树的深度；树根的高度就是树的高度。这样树的高度和深度是相等的。<p/>
 * 对于树中相同深度的每个结点来说，它们的高度不一定相同，这取决于每个结点下面的叶结点的深度。<p/>
 * 树的深度 = 层数（从上至下）<p/>
 * 树的高度 = 层数 + 1（从下至上)<p/>
 *
 * @author 张利红
 */
public class Q104MaxDepth  {
    /**
     * 求二叉树的最大深度
     *
     * @param root 根节点
     * @return 二叉树的最大深度值
     */
    public int maxDepth(TreeNode<Integer> root) {
        // 根节点为null,空树
        if (root == null) {
            return 0;
        }
        // 递归左子树的深度
        int leftMaxDepth = maxDepth(root.getLeft());
        // 递归右子树的深度
        int rightMaxDepth = maxDepth(root.getRight());
        // 比较左右子树的深度
        return (leftMaxDepth > rightMaxDepth) ? (leftMaxDepth + 1) : (rightMaxDepth + 1);

    }

}

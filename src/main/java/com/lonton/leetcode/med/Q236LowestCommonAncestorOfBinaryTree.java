package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 236. 二叉树的最近公共祖先<p/>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” <p/>
 * 思路：<p/>
 * 递归 <p/>
 * 1. 根节点为空或者根节点等于p 或者q，返回root；<p/>
 * 2. 递归左右子树，查找左右子树中是否包含p、q；<p/>
 * 1) 左右子树中包含p、q,则当前节点为其最近公共祖先；<p/>
 * 2） 都在左子树中，左子节点即为其最近公共祖先；<p/>
 * 3） 都在右子树中，右子节点即为其最近公共祖先；<p/>
 * 4） 左右子树中均不包含p、q,则返回null。<p/>
 *
 * @author 张利红
 */
public class Q236LowestCommonAncestorOfBinaryTree {

    /**
     * 求二叉树的最近公共祖先
     *
     * @param root 根节点
     * @param p    节点 p
     * @param q    节点 q
     * @return 二叉树的最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode rightNode = lowestCommonAncestor(root.getRight(), p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        if (leftNode != null) {
            return leftNode;
        }

        if (rightNode != null) {
            return rightNode;
        }

        return null;
    }
}

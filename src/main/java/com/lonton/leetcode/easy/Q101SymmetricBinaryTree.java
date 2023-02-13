package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 101. 对称的树 <p/>
 * 给你一个二叉树的根节点 root，检查它是否轴对称。
 *
 * @author 张利红
 */
public class Q101SymmetricBinaryTree extends TreeNode {
    /**
     * 判断是否为对称的树（镜像树）
     * <br/>
     *
     * @return boolean
     */
    public static boolean isSymmetric(TreeNode root) {
        // 如果一棵树的根节点为空，那么它为镜像树
        if (root == null) {
            return true;
        }
        // 将左右子节点视为一棵新树，参照Q100比较两棵树是否相同做一点修改
        return isSym(root.getLeft(), root.getRight());
    }

    /**
     * 判断两棵树是否为镜像树
     *
     * @param p 左子树根节点
     * @param q 右子树根节点
     * @return boolean
     */
    public static boolean isSym(TreeNode p, TreeNode q) {
        // 两节点均为空，镜像对称
        if (p == null && q == null) {
            return true;
        }
        // 如果两棵树要么一棵树根节点为空，要么另一棵树根节点不为空，不是镜像树（上面已对都为空的情况进行判断）
        if (p == null || q == null) {
            return false;
        }
        // 讨论两棵树对称情况下的条件
        return (p.getVal() == q.getVal() && isSym(p.getLeft(), q.getRight()) && isSym(p.getRight(), q.getLeft()));
    }

}

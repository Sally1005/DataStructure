package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 700. 二叉搜索树中的搜索 <p/>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * @author 张利红
 */
public class Q700SearchBST extends TreeNode {
    /**
     * 搜索二叉树中的整数值
     *
     * @param root 根节点
     * @param val  整数值 val
     * @return 返回以节点值等于 val为根的子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if ((Integer)root.getVal() == val) return root;
        // 整数值小于根节点数值，递归往左找
        if ((Integer)root.getVal() > val) {
            return searchBST(root.getLeft(), val);
        }
        // 整数值大于根节点数值，递归往右找
        return searchBST(root.getRight(), val);
    }
}

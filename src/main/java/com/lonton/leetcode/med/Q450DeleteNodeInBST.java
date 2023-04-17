package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 450. 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，<p>
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。<p>
 * 思路：<p>
 * <ol>
 *     <li> 未找到目标节点或根节点为空；
 *     <li> 找到目标节点。为叶子节点（左空 & 右空）；
 *     <li> （左空 & 右非空）；
 *     <li> （左非空 & 右空）；
 *     <li> （左非空 & 右非空）。
 * </ol>
 *
 * @author 张利红
 */
public class Q450DeleteNodeInBST {
    /**
     * 删除二叉搜索树中的元素
     *
     * @param root 根节点
     * @param key  目标删除元素
     * @return （更新后）根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 根节点为空或者遍历完树还未找到要删除的目标元素
        if (root == null) {
            return null;
        }
        // 递归地向左子树删除元素
        if (key < (int) root.getVal()) {
            root.setLeft(deleteNode(root.getLeft(), key));
            // 递归地向右子树删除元素
        } else if (key > (int) root.getVal()) {
            root.setRight(deleteNode(root.getRight(), key));
        } else {
            // 找到要删除的节点 为叶子节点（左空 & 右空）
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            }
            // 节点只有一个
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            // 节点有两个子节点，找到右子树的最小节点
            root.setVal(minValue(root.getRight()));

            // 删除右子树的最小节点
            root.setRight(deleteNode(root.getRight(), (int) root.getVal()));
        }
        return root;
    }

    /**
     * 返回右子树下较小的值
     *
     * @param root 根节点
     * @return 较小的节点值
     */
    int minValue(TreeNode root) {
        int minv = (int) root.getVal();
        while (root.getLeft() != null) {
            minv = (int) root.getLeft().getVal();
            root = root.getLeft();
        }
        return minv;
    }
}

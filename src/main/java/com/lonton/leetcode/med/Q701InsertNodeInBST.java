package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 701. 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。<p>
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。<p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * @author 张利红
 */
public class Q701InsertNodeInBST {
    /**
     * 插入二叉搜索树
     *
     * @param root 根节点
     * @param val  插入值
     * @return 根节点
     */
    public TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.getVal() > val) {
            root.setLeft(insertIntoBST(root.getLeft(), val));
        }
        if (root.getVal() < val) {
            root.setRight(insertIntoBST(root.getRight(), val));
        }
        return root;
    }
}

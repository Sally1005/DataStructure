package com.lonton.leetcode.med;


import com.lonton.leetcode.common.TreeNode;

/**
 * 669. 修剪二叉搜索树。 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。<p>
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。<p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。<p>
 * 思路：<p>
 * <ol>
 *     <li> 树为空，返回null；
 *     <li> 不在修剪的范围内：（1）根节点大于high,返回左子树；（2）根节点小于low,返回右子树；
 *     <li> 在修剪的范围内，递归修剪左右子树
 * </ol>
 *
 * @author 张利红
 */
public class Q669TrimBST {
    /**
     * 修剪二叉搜索树
     *
     * @param root 根节点
     * @param low  最小边界
     * @param high 最大边界
     * @return 修剪好的二叉搜索树的新的根节点
     */
    public TreeNode<Integer> trimBST(TreeNode<Integer> root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.getVal() > high) {
            return trimBST(root.getLeft(), low, high);
        }
        if (root.getVal() < low) {
            return trimBST(root.getRight(), low, high);
        }
        root.setLeft(trimBST(root.getLeft(), low, high));
        root.setRight(trimBST(root.getRight(), low, high));
        return root;
    }
}

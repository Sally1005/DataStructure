package com.lonton.leetcode.med;


import com.lonton.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树<p/>
 * 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。如果存在多个答案，您可以返回其中 任何 一个。<p/>
 * 思路：<p/>
 * 1. 在前序遍历序列中,第一个元素为树的根节点;<p/>
 * 2. 在后序遍历序列中,最后一个元素为树的根节点,所以根据前序和后序遍历无法确定唯一的一棵二叉树;<p/>
 * 3. 默认左子树存在，则在前序遍历中的第二个元素即为左子树的根节点;<p/>
 * 4. 由于后序遍历的顺序为左——>右——>根,即可以确定左子树的范围;<p/>
 * 5. 在前序遍历中，根节点为left,左子树的根节点left+1,左子树的下标范围为[left+1,left+1+左子树节点的个数],
 *    右子树的下标范围为[left+1+左子树节点的个数+1,right]。<p/>
 *
 * @author 张利红
 */
public class Q889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    // 存储后序遍历节点信息
    private final Map<Integer, Integer> map = new HashMap<>();
    // 前序遍历数组
    private int[] preorder;

    /**
     * 从前序与后序遍历序列构造二叉树
     *
     * @param postorder 后序遍历数组
     * @param preorder  前序遍历数组
     * @return 二叉树
     */
    public TreeNode<Integer> buildTree(int[] preorder, int[] postorder) {
        // 初始化全局变量值
        this.preorder = preorder;
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        // 前序遍历中设置索引
        return getTreeNode(0, preorder.length - 1, 0);
    }

    /**
     * 构建二叉树
     *
     * @param start     前序遍历开始下标
     * @param end       前序遍历结束下标
     * @param postStart 后序遍历开始下标
     * @return 构建好的二叉树
     */
    private TreeNode<Integer> getTreeNode(int start, int end, int postStart) {
        // 上一个节点是叶子节点
        if (start > end) {
            return null;
        }
        // 整棵树的根节点
        TreeNode<Integer> root = new TreeNode<>(preorder[start]);
        if (start == end){
            return root;
        }
        // 左子树的根节点下标
        int lRootIndex = preorder[start + 1];
        // 获取左子树的根节点在后序数组中的位置，并求出左子树的节点个数
        int lSize = map.get(lRootIndex) - postStart + 1;
        root.setLeft(getTreeNode(start + 1, start + lSize, postStart));
        root.setRight(getTreeNode(start + lSize + 1, end, postStart + lSize));
        return root;
    }
}

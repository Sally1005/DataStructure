package com.lonton.leetcode.med;


import com.lonton.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树<p/>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。<p/>
 * 思路：<p/>
 * 1. 在前序遍历序列中,第一个元素为树的根节点;<p/>
 * 2. 在中序遍历序列中,根节点的左边为左子树,右边为右子树;<p/>
 * 3. 在前序遍历中将第一个下标的值在中序遍历中找到;<p/>
 * 4. 在中序遍历中,根节点下标为index,左子树的下标范围为[left,index-1],右子树的下标范围为[index+1,right]。<p/>
 *
 * @author 张利红
 */
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // 存储中序遍历节点信息
    private Map<Integer, Integer> map = new HashMap<>();
    // 前序遍历索引
    private int preIndex = 0;
    // 中序遍历数组
    private int[] inorder;
    // 前序遍历数组
    private int[] preorder;

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder  中序遍历数组
     * @param preorder 前序遍历数组
     * @return 二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化全局变量值
        this.inorder = inorder;
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 前序遍历中设置索引
        return getTreeNode(0, preorder.length - 1, preorder);
    }

    /**
     * 构建二叉树
     *
     * @param left  左
     * @param right 右
     * @return 二叉树
     */
    private TreeNode getTreeNode(int left, int right, int[] preorder) {
        // 上一个节点是叶子节点
        if (left > right) {
            return null;
        }
        // 根节点
        int val = preorder[preIndex];
        //获取根节点在中序数组中的位置
        int index = map.get(val);
        //生成根节点
        TreeNode root = new TreeNode(val);
        // 寻找根节点的左子树和右子树时公用的索引
        preIndex++;
        // 从左子树先生成，因为preIndex索引是从后续数组中从前往后遍历的
        root.setLeft(getTreeNode(left, index - 1, preorder));
        root.setRight(getTreeNode(index + 1, right, preorder));
        return root;
    }
}

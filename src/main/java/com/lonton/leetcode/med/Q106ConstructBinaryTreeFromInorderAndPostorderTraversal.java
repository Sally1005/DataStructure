package com.lonton.leetcode.med;


import com.lonton.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树<p/>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。<p/>
 * 思路：<p/>
 * 1. 在后序遍历序列中,最后一个元素为树的根节点;<p/>
 * 2. 在中序遍历序列中,根节点的左边为左子树,右边为右子树;<p/>
 * 3. 在后序遍历中将最后一个下标的值在中序遍历中找到;<p/>
 * 4. 在中序遍历中,根节点下标为index,左子树的下标范围为[left,index-1],右子树的下标范围为[index+1,right]。<p/>
 *
 * @author 张利红
 */
public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    // 存储中序遍历节点信息
    private static Map<Integer, Integer> map = new HashMap<>();
    // 后序遍历索引
    private static int posIndex;
    // 中序遍历数组
    private static int[] inorder;
    // 后序遍历数组
    private static int[] postorder;

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return 二叉树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 初始化全局变量值
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        posIndex = postorder.length - 1;
        // 后序遍历中设置索引
        return getTreeNode(0, postorder.length - 1);
    }

    /**
     * 构建二叉树
     *
     * @param left  左节点
     * @param right 右节点
     * @return 二叉树
     */
    private static TreeNode getTreeNode(int left, int right) {
        // 上一个节点是叶子节点
        if (left > right) {
            return null;
        }
        // 根节点
        int val = postorder[posIndex];
        //获取根节点在中序数组中的位置
        int index = map.get(val);
        //生成根节点
        TreeNode root = new TreeNode(val);
        // 寻找根节点的左子树和右子树时公用的索引，用来标记下一个根节点的问题（右子树中的根节点or左子树中的根节点）
        posIndex--;
        // 从右子树先生成，因为posIndex索引是从后续数组中从后向前遍历的，而倒数第二个数据要么是根节点的右节点，
        // 要么是根节点右节点为空时的左节点，因此用这个数去去从中序数组中根节点右侧寻找一定可以找到（找不到就说明没有右节点）。
        root.setRight(getTreeNode(index + 1, right));
        root.setLeft(getTreeNode(left, index - 1));
        return root;
    }
}

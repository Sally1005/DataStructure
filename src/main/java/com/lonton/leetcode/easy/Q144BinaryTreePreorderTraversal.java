package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * @author 张利红
 */
public class Q144BinaryTreePreorderTraversal extends TreeNode {
    /**
     * 前序遍历
     *
     * @param root 根节点
     * @return 返回存储对象
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        // 定义list集合，存储返回对象
        List<Integer> val = new ArrayList<>();
        if (root == null) {
            return val;
        }
        // 递归遍历数据
        preorder(root, val);
        return val;
    }

    /**
     * 递归遍历下一个节点 <br/>
     * 根->左->右 <br/>
     *
     * @param root 根节点 <br/>
     * @param val  list集合容器
     */
    public static void preorder(TreeNode root, List<Integer> val) {
        if (root == null) {
            return;
        }
        // 判断根节点存在
        val.add((Integer) root.getVal());
        // 判断是否有左节点
        if (root.getLeft() != null) {
            preorder(root.getLeft(), val);
        }
        // 判断是否有右节点
        if (root.getRight() != null) {
            preorder(root.getRight(), val);
        }
    }
}

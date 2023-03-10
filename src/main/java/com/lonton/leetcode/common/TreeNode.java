package com.lonton.leetcode.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 定义树（题目给出条件）
 *
 * @author 张利红
 */
@Data
public class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;


    public TreeNode() {
        this.val = val;
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * 数组转为树
     *
     * @param array int数组
     * @return treeNode
     */
    public static TreeNode arrayToTree(Integer[] array) {
        // 构建一棵二叉树
        TreeNode tree = new TreeNode();
        // 如果数组为空，则返回空数组
        if (array.length == 0) return null;
        // 数组第一个为根节点
        tree.val = new TreeNode(array[0]);
        // 初始化树的下标
        int treeIdx = 0;
        int dataIdx = 0;
        // 创建一个集合存放数组
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add((TreeNode) tree.val);
        // 循环遍历数组
        for (dataIdx = 1; dataIdx < array.length; dataIdx += 2) {
            // 放置左节点
            if (array[dataIdx] != null) {
                TreeNode left = new TreeNode(array[dataIdx]);
                // 挂树
                treeNodes.get(treeIdx).setLeft(left);
                // 加到集合中
                treeNodes.add(left);
            }
            // 放置右节点
            if (dataIdx + 1 < array.length && array[dataIdx + 1] != null) {
                TreeNode right = new TreeNode(array[dataIdx + 1]);
                treeNodes.get(treeIdx).setRight(right);
                treeNodes.add(right);
            }
            treeIdx++;
        }
        return (TreeNode) tree.val;

    }

    /**
     * 树转为数组
     *
     * @param root 根节点
     * @return 数组
     */
    public static Integer[] treeToArray(TreeNode root) {
        // 根节点为空，返回一个空数组
        if (root == null) return new Integer[0];
        // 由于不知道数组长度，先将元素存入list中
        List<Integer> list = new ArrayList<>();
        // 需要向队列中添加null,ArrayDequeue不能添加null
        Queue<TreeNode> queue = new LinkedList<>();
        // 加入根节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null)
                    list.add((Integer) node.val);
                else
                    list.add(null);
                if (node == null || (queue.isEmpty() && node.left == null && node.right == null))
                    continue;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        // 去掉数组后多余的null
        int idx= list.size()-1;
        while ( idx >0 && list.get( idx) == null ) {
            idx--;
        }
        // 截取目标数组指定范围
        return list.subList(0, idx+1).toArray(new Integer[0]);
    }
}

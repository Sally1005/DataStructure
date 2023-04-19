package com.lonton.leetcode.common;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;


/**
 * 定义树（题目给出条件）
 *
 * @author 张利红
 */
@Data
public class TreeNode<T> {
    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        TreeNode<T> treeNode = (TreeNode<T>) obj;

        return Objects.equals(val, treeNode.val)
                && Objects.equals(left, treeNode.left)
                && Objects.equals(right, treeNode.right);
    }

    /**
     * 数组转为树
     *
     * @param array 数组
     * @return treeNode
     */
    public TreeNode<T> arrayToTree(T[] array) {
        // 构建一棵二叉树
        TreeNode<T> tree = new TreeNode<T>();
        // 如果数组为空，则返回空数组
        if (array.length == 0) return null;
        // 数组第一个为根节点
        tree.val = (T) new TreeNode<>(array[0]);
        // 初始化树的下标
        int treeIdx = 0;
        int dataIdx = 0;
        // 创建一个集合存放数组
        ArrayList<TreeNode<T>> treeNodes = new ArrayList<>();
        treeNodes.add((TreeNode<T>) tree.val);
        // 循环遍历数组
        for (dataIdx = 1; dataIdx < array.length; dataIdx += 2) {
            // 放置左节点
            if (array[dataIdx] != null) {
                TreeNode<T> left = new TreeNode<T>(array[dataIdx]);
                // 挂树
                treeNodes.get(treeIdx).setLeft(left);
                // 加到集合中
                treeNodes.add(left);
            }
            // 放置右节点
            if (dataIdx + 1 < array.length && array[dataIdx + 1] != null) {
                TreeNode<T> right = new TreeNode<T>(array[dataIdx + 1]);
                treeNodes.get(treeIdx).setRight(right);
                treeNodes.add(right);
            }
            treeIdx++;
        }
        return (TreeNode<T>) tree.val;

    }

    /**
     * 二叉树转为数组
     *
     * @param root 二叉树根节点
     * @return 数组
     */
    public T[] treeToArray(TreeNode<T> root,Class<T> clazz) {
        // 根节点为空，返回一个空数组
        if (root == null) return  (T[]) Array.newInstance(clazz,0);
        // 由于不知道数组长度，先将元素存入list中
        List<T> list = new ArrayList<>();
        // 需要向队列中添加null,ArrayDequeue不能添加null
        Queue<TreeNode<T>> queue = new LinkedList<>();
        // 加入根节点
        queue.offer(root);
        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                if (node != null)
                    list.add(node.val);
                else list.add(null);
                // 当前节点为null或者队列为空时，左右节点为null
                if (node == null || (queue.isEmpty() && node.left == null && node.right == null))
                    continue;
                queue.offer(node.left);
                queue.offer(node.right);
                // 标记list集合中最后一个为非null元素的位置
                if (!list.isEmpty() && list.get(list.size() - 1) != null) {
                    idx = list.size() - 1;
                }
            }
            // return  list.subList(0, idx+1).toArray((T[]) new Object[idx]);
            //return (T[]) list.subList(0, idx + 1).toArray(new Integer[0]);
        }
        return list.subList(0, idx + 1).toArray((T[]) Array.newInstance(clazz, list.subList(0, idx + 1).size()));
    }

}

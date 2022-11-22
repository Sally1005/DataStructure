package com.lonton.binaryTree.tree.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 二叉树类
 * 　<p/>
 * @author 张利红
 */

@SuppressWarnings("all")
@Slf4j
@Data
public class BinaryTree<T> {
    /**
     * 根节点
     */
    private TreeNode<T> root;

    /**
     * 节点数
     */
    private int nodeCount;

    public BinaryTree(List<TreeNode> nodes) {
        TreeNode treeNode = nodes.get(0);
        this.root = treeNode;

        this.nodeCount++;
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            addNode(root, node);
            this.nodeCount++;

        }
    }

    /**
     * 添加节点<br/>
     *
     * @param BinaryTree.TreeNode <br/>
     * @return
     */
    public void addNode(TreeNode<T> root,TreeNode<T> node) {
        // 如果当前父节点值大于要插入的值
        if(root.getWeight()> node.getWeight()) {
            // 则判断当前父节点有无左节点 若有 则进行递归 若没有则直接插入
            if (root.getLeft() != null) {
                addNode(root.getLeft(), node);
            } else {
                root.setLeft(node);
            }
            return;
        }else {
            //当前父节点小于要插入的值
            if(root.getWeight()< node.getWeight()) {
                // 则判断当前父节点有无右节点 若有 则进行递归 若没有则直接插入
                if (root.getRight() != null) {
                    addNode(root.getRight(), node);
                } else {
                    root.setRight(node);
                }
                return;
            }

        }

    }

    /**
     * 根据id查询节点
     *
     * @param id
     * @param curNode
     * @return
     */
    private TreeNode<T> search(int id, TreeNode<T> curNode) {
        if (curNode == null) {
            return null;
        }
        if (curNode.getId() == id) {
            return curNode;
        }
        TreeNode<T> node = search(id, curNode.getLeft());
        if (node != null) {
            return node;
        }
        return search(id, curNode.getRight());
    }

    @Data
    public static class TreeNode<T> {
        /**
         * 当前节点
         */
        private String data;

        /**
         * 左子节点
         */
        private TreeNode left;

        /**
         * 右子节点
         */
        private TreeNode right;

        /**
         * id
         */
        private int id;

        /**
         * 权重（分数)
         */
        private int weight;

    }

}


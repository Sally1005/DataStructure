package com.lonton.binarytree.tree.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 二叉树类<p/>
 * @author 张利红
 */

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

    /**
     * 在构造函数中创建二叉树
     * @param nodes 节点集
     */
    public BinaryTree(List<TreeNode> nodes) {
         // 随意取一个值作为根节点
        TreeNode treeNode = nodes.get(0);
         // 赋值
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
     * @param root 当前父节点值
     * @param node 插入节点值
     */
    public void addNode(TreeNode<T> root, TreeNode<T> node) {
         // 如果当前父节点值大于要插入的值
        if(root.getWeight() > node.getWeight()){
             // 则判断当前父节点有无左节点 若有 则进行递归
            if (root.getLeft() != null){
                addNode(root.getLeft(), node);
                // 若没有则直接插入
            }else{
                root.setLeft(node);
            }
            return;
            // 如果当前父节点值小于要插入的值
        }else{
             // 则判断当前父节点有无右节点 若有 则进行递归
            if (root.getRight() != null){
                addNode(root.getRight(), node);
                // 若没有则直接插入
            }else{
                root.setRight(node);
            }
            return;
        }
    }

    /**
     * 根据id查询节点
     * <br/>
     * @param id id
     * @param curNode 当前节点
     * @return TreeNode<T> 节点
     */
    private TreeNode<T> search(int id, TreeNode<T> curNode) {
         // 当前节点为空，返回null
        if (curNode == null) {
            return null;
        }
         // 当前节点id和所查询的id相同时，则返回当前节点值
        if (curNode.getId() == id) {
            return curNode;
        }
         // 递归查询左子节点id值
        TreeNode<T> node = search(id, curNode.getLeft());
         // 查出节点值非空，返回查出节点
        if (node != null) {
            return node;
        }
         // 递归查询右子节点id值
        return search(id, curNode.getRight());
    }

    @Data
    public static class TreeNode<T> {
        /**
         * id
         */
        private Integer id;

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
         * 权重
         */
        private int weight;

    }

}


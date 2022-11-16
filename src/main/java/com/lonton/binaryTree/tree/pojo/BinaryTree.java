package com.lonton.binaryTree.tree.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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

    /**
     * 添加节点<br/>
     * @param treeNode <br/>
     * @return
     */
    public boolean addNode(TreeNode<T> treeNode) {
        if (this.root == null) {
            this.root = treeNode;
            this.nodeCount++;
        } else {
             // 找到对应的父节点
            TreeNode<T> parent = this.search(treeNode.getParentID(), this.root);
            if (parent == null) {
                return false; // 插入失败
            }
            if (parent.getLeft() != null && parent.getRight() != null) {
                return false;
            }
            if (parent.getLeft() == null) {
                parent.setLeft(treeNode);
                this.nodeCount++;
                return true;
            }
            parent.setRight(treeNode);
            this.nodeCount++;
        }
        return true;
    }

    /**
     * 根据id查询节点
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

}


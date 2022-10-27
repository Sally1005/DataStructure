package com.lonton.tree;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 节点类
 * @author 张利红
 */

@Data
@Slf4j
public class TreeNode<T extends Comparable<T>> {
    /**
     * 父节点
     */
    private TreeNode<T> parent;

    /**
     * 左子节点
     */
    private TreeNode<T> left;

    /**
     * 右子节点
     */
    private TreeNode<T> right;

    /**
     * 任意类型
     */
    private T key;

    /**
     * 节点数
     */
    private int nodes;

    /**
     * 树高
     */
    private  int height;

    /**
     * 排名
     */
    private int rank;

    /**
     * 姓名
     */
    private String name;

     /**
     * 构造函数
     * @param rank
     * @param name
     */
    public TreeNode(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public TreeNode(T key,TreeNode<T> parent) {
        this.key = key;
        this.parent = parent;
    }

    /**
     * 构造函数
     * @param parent
     */
    public TreeNode(TreeNode<T> parent) {
        this.parent = parent;
    }

    /**
     * 构造函数
     * @param parent
     * @param left
     * @param right
     */
    public TreeNode(TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

}






















































































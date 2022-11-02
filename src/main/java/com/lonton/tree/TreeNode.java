package com.lonton.tree;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 节点类
 * @author 张利红
 */

@Data
@Slf4j
public class TreeNode<T> {
    /**
     * 当前节点
     */
    private T data;

    /**
     * 左子节点
     */
    private TreeNode left;

    /**
     * 右子节点
     */
    private TreeNode right;

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
    /**
     * 构造函数
     * @param data
     */
    public TreeNode(T data) {
        this.data = data;
    }
    /**
     * 构造函数
     * @param data
     * @param left
     * @param right
     */
    public TreeNode(T data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}






















































































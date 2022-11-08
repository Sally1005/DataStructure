package com.lonton.binaryTree.tree.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
/**
 *节点类
 *
 * @author 张利红
 * date:2022-11-05
 */

@Data
@Slf4j
public class TreeNode<T> {
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
     * 父id
     */
    private int parentID;

    /**
     * 无参构造
     */
    public TreeNode() {
    }

    /**
     * 有参构造
     * @param data
     * @param id
     * @param parentID
     */
    public TreeNode(String data, int id, int parentID) {
        this.data = data;
        this.id = id;
        this.parentID = parentID;
    }
}

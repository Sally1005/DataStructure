package com.lonton.binarytree.impl;

import com.lonton.binarytree.AVisitor;
import com.lonton.binarytree.pojo.BinaryTree;
import lombok.Data;


/**
 * 根据id查找节点
 *
 * @author 张利红
 */
@Data
public class SearchVisitor extends AVisitor {

    // 查询id
    private int id;

    // 已找到的节点
    private BinaryTree.TreeNode foundNode;

    /**
     * 根据id查找节点
     *
     * @param node  节点
     * @param param 可变参数
     * @return 所找节点
     */
    @Override
    public Object doVisit(BinaryTree.TreeNode node, Object... param) {
        // 若节点id值刚好的等于所查询的id，则返回当前节点
        if (node.getId() == id) {
            this.foundNode = node;
        }
        return node;
    }

    /**
     * 设置 id
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取已找到的节点
     *
     * @return 已找到的节点
     */
    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return foundNode;
    }

}

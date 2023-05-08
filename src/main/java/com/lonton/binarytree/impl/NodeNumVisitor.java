package com.lonton.binarytree.impl;

import com.lonton.binarytree.AVisitor;
import com.lonton.binarytree.pojo.BinaryTree;

/**
 * 计算节点个数
 *
 * @author 张利红
 */

public class NodeNumVisitor<T> extends AVisitor<T> {
    // 初始节点数
    int count;

    /**
     * 计算节点个数
     *
     * @param node  节点
     * @param param 求节点个数visitor
     * @return 节点个数
     */
    @Override
    public Object doVisit(BinaryTree.TreeNode<T> node, Object... param) {
        count++;
        return this.count;
    }

    /**
     * 获取节点数
     *
     * @return 节点数
     */
    public int getCount() {
        return count;
    }

    @Override
    public BinaryTree.TreeNode<T> getFoundNode() {
        return null;
    }

}

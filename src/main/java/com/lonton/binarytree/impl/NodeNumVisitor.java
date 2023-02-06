package com.lonton.binarytree.impl;

import com.lonton.binarytree.pojo.BinaryTree;
import com.lonton.binarytree.IVisitor;

import java.util.function.Predicate;

/**
 * 计算节点个数
 * <p/>
 * @author 张利红
 */

public class NodeNumVisitor implements IVisitor {
    /**
     * 初始节点数
     */
    int count = 0 ;

    /**
     * 计算节点个数
     * @param node 节点
     * @param param 可变参数
     * @return 节点个数
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        count++;
        return count;
    }

    @Override
    public Object visit(BinaryTree.TreeNode node, Predicate<BinaryTree.TreeNode> predicate) {
        return null;
    }

    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return null;
    }

    public int getCount() {
        return count;
    }

}

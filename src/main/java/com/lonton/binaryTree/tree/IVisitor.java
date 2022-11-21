package com.lonton.binaryTree.tree;


import com.lonton.binaryTree.tree.pojo.BinaryTree;

/**
 *二叉树访问数据接口
 *
 * @author 张利红
 */
public interface IVisitor {
    /**
     * 访问树
     * @param binaryTree
     */
    int visit(BinaryTree binaryTree);
}

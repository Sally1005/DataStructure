package com.lonton.binarytree;


import com.lonton.binarytree.pojo.BinaryTree;

/**
 * 二叉树访问数据接口
 *
 * @author 张利红
 */
public interface IVisitor<T> {

    /**
     * 访问树
     *
     * @param node  节点
     * @param param visitor可选的具体行为列表（包括求高、打印、查找和求节点个数）
     * @return 任意类型
     */
    Object visit(BinaryTree.TreeNode<T> node, Object... param);

    /**
     * 查找节点
     *
     * @return 已查找到的节点
     */
    BinaryTree.TreeNode<T> getFoundNode();
}


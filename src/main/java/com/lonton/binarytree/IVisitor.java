package com.lonton.binarytree;


import com.lonton.binarytree.pojo.BinaryTree;

import java.util.function.Predicate;

/**
 * 二叉树访问数据接口
 * <p/>
 * @author 张利红
 */
public interface IVisitor {

    /**
     * 访问树
     * @param node 节点
     * @param param 可变参数
     * @return 任意类型
     */
    Object visit(BinaryTree.TreeNode node, Object... param);

    /**
     * 访问树<重载过滤>
     * @param node 节点
     * @param predicate 预测(过滤输入内容是否符合条件)
     * @return 任意类型
     */
    Object visit(BinaryTree.TreeNode node, Predicate<BinaryTree.TreeNode> predicate);

    /**
     * 查找节点
     * @return 已查找到的节点
     */
    public BinaryTree.TreeNode getFoundNode();
}


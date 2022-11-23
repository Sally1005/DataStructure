package com.lonton.binaryTree.tree;


import com.lonton.binaryTree.tree.pojo.BinaryTree;

import java.util.List;

/**
 * 二叉树访问数据接口
 * <p/>
 * @author 张利红
 */
@SuppressWarnings("all")
public interface IVisitor {
    /**
     * 访问树
     */
    void visit(BinaryTree.TreeNode root, List<Object> list);
}

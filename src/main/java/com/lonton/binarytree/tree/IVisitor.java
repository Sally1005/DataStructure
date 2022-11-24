package com.lonton.binarytree.tree;


import com.lonton.binarytree.tree.pojo.BinaryTree;

import java.util.List;

/**
 * 二叉树访问数据接口
 * <p/>
 * @author 张利红
 */
public interface IVisitor {
    /**
     * 访问树
     */
    void visit(BinaryTree.TreeNode root, List<Object> list);
}

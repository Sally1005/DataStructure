package com.lonton.binarytree;

import com.lonton.binarytree.tree.IVisitor;
import com.lonton.binarytree.tree.pojo.BinaryTree;

import java.util.List;

/**
 * 遍历接口
 * <p/>
 * @author 张利红
 */
public interface ITraverser {

    /**
     * 访问树
     * @param binaryTree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return 任意类型
     */
    Object doVisitor(BinaryTree binaryTree, IVisitor visitor, Object... param);

    /**
     * 遍历树
     * @param tree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return 任意类型
     */
    Object traverser(BinaryTree tree, IVisitor visitor,Object... param);
}

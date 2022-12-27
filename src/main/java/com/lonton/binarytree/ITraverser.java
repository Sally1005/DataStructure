package com.lonton.binarytree;

import com.lonton.binarytree.pojo.BinaryTree;

/**
 * 遍历接口
 * <p/>
 * @author 张利红
 */
public interface ITraverser {

    /**
     * 访问树 (在抽象类中实现）
     * @param binaryTree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return 任意类型
     */
    Object doVisitor(BinaryTree binaryTree, IVisitor visitor, Object... param);

}

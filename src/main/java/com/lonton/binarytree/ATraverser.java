package com.lonton.binarytree;

import com.lonton.binarytree.tree.IVisitor;
import com.lonton.binarytree.tree.pojo.BinaryTree;
/**
 * 遍历抽象类
 * <p/>
 * @author 张利红
 */
public abstract class ATraverser implements ITraverser {

    /**
     * 访问树
     * @param binaryTree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return 任意类型
     */
    @Override
    public Object doVisitor(BinaryTree binaryTree, IVisitor visitor, Object... param) {
        return traverser(binaryTree, visitor, param);
    }
}

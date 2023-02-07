package com.lonton.binarytree.impl;

import com.lonton.binarytree.pojo.BinaryTree;
import com.lonton.binarytree.IVisitor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;


/**
 * 计算树高
 * <p/>
 * @author 张利红
 */

@Slf4j
public class CountHeightVisitor implements IVisitor {

    /**
     * 初始高度
     */
    private int height = 0;

    /**
     * 计算树高
     * @param node 节点
     * @param param 可变参数
     * @return 树高
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        if (node.getLevel() > height) {
            height = node.getLevel();
        }
        return node;
    }

    @Override
    public Object visit(BinaryTree.TreeNode node, Predicate<BinaryTree.TreeNode> predicate) {
        return null;
    }

    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return null;
    }

    @Override
    public Predicate<BinaryTree.TreeNode> predicate() {
        return IVisitor.super.predicate();
    }

    /**
     * 获取树高
     * @return  树高
     */
    public int getHeight() {
        return height;
    }
}

package com.lonton.binarytree.impl;

import com.lonton.binarytree.AVisitor;
import com.lonton.binarytree.pojo.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印树
 *
 * @author 张利红
 */
public class PrintVisitor extends AVisitor {
     // 树中数据集合
    private List<String> res = new ArrayList<>();


    /**
     * 打印二叉树
     *
     * @param node  根节点
     * @param param 任意类型
     * @return 树中数据
     */
    @Override
    public Object doVisit(BinaryTree.TreeNode node, Object... param) {
        res.add(node.getData());
        return node;
    }

    /**
     * 获取树中数据
     *
     * @return 树中数据
     */
    public List<String> getRes() {
        return res;
    }

    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return null;
    }
}

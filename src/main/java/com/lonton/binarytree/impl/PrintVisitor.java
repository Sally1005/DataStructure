package com.lonton.binarytree.impl;

import com.lonton.binarytree.IVisitor;
import com.lonton.binarytree.pojo.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 打印树
 * <p/>
 *
 * @author 张利红
 */
public class PrintVisitor implements IVisitor {
    /**
     * 树中数据集合
     */
    private List<String> res = new ArrayList<>();

    /**
     * 已过滤完符合条件的数据集合
     */
    private List<BinaryTree.TreeNode> filterNode = new ArrayList<>();


    /**
     * 打印二叉树
     *
     * @param node  根节点
     * @param param 任意类型
     * @return 树中数据
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        res.add(node.getData());
        return node;
    }


    /**
     * 打印二叉树 <重载>
     *
     * @param node      根节点
     * @param predicate 过滤条件
     * @return 树中数据
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, List<Predicate<BinaryTree.TreeNode>> predicate) {
        res.add(node.getData());
        // 若为true,则将节点信息加入符合条件的数据集合中
        if (predicate != null) {
            for (Predicate<BinaryTree.TreeNode> treeNodePredicate : predicate) {
                if (treeNodePredicate.test(node)) {
                    filterNode.add(node);
                }
            }
        }
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

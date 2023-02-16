package com.lonton.binarytree.impl;

import com.lonton.binarytree.pojo.BinaryTree;
import com.lonton.binarytree.IVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 计算节点个数
 * <p/>
 *
 * @author 张利红
 */

public class NodeNumVisitor implements IVisitor {
    /**
     * 初始节点数
     */
    int count;

    /**
     * 已过滤完符合条件的数据集合
     */
    private List<BinaryTree.TreeNode> filterNode = new ArrayList<>();

    /**
     * 计算节点个数
     *
     * @param node  节点
     * @param param 可变参数
     * @return 节点个数
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        count++;
        return this.count;
    }

    /**
     * 计算节点个数 <重载>
     *
     * @param node      节点
     * @param predicate 过滤条件
     * @return 节点个数
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, List<Predicate<BinaryTree.TreeNode>> predicate) {
        count++;
        // 若为true,则将节点信息加入符合条件的数据集合中
        if (predicate != null) {
            for (Predicate<BinaryTree.TreeNode> treeNodePredicate : predicate) {
                if (treeNodePredicate.test(node)) {
                    filterNode.add(node);
                }
            }
        }
        return this.count;
    }

    /**
     * 获取节点数
     *
     * @return 节点数
     */
    public int getCount() {
        return count;
    }

    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return null;
    }

}

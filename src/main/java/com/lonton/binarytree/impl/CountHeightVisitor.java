package com.lonton.binarytree.impl;

import com.lonton.binarytree.pojo.BinaryTree;
import com.lonton.binarytree.IVisitor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * 计算树高
 * <p/>
 *
 * @author 张利红
 */
@Slf4j
public class CountHeightVisitor implements IVisitor {

    /**
     * 初始高度
     */
    private int height;

    /**
     * 已过滤完符合条件的数据集合
     */
    private List<BinaryTree.TreeNode> filterNode = new ArrayList<>();

    /**
     * 计算树高
     *
     * @param node  节点
     * @param param 可变参数
     * @return 树高
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        if (node.getLevel() > height) {
            this.height = node.getLevel();
        }
        return node;
    }

    /**
     * 计算树高 <重载>
     *
     * @param node      节点
     * @param predicate 过滤条件
     * @return 树高
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, List<Predicate<BinaryTree.TreeNode>> predicate) {
        if (node.getLevel() > height) {
            this.height = node.getLevel();
        }
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
     * 获取树高
     *
     * @return 树高
     */
    public int getHeight() {
        return height;
    }

    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return null;
    }
}

package com.lonton.binarytree.impl;

import com.lonton.binarytree.pojo.BinaryTree;
import com.lonton.binarytree.IVisitor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 根据id查找节点
 * <p/>
 * @author 张利红
 */
@Data
public class SearchVisitor implements IVisitor {

    /**
     * 查询id
     */
    private int id;

    /**
     * 已找到的节点
     */
    private BinaryTree.TreeNode foundNode;

    /**
     * 已过滤完符合条件的数据集合
     */
    private List<BinaryTree.TreeNode> filterNode = new ArrayList<>();


    /**
     * 判断符合条件参数
     */
    private Predicate<BinaryTree.TreeNode> predicate;

    /**
     * 根据id查找节点<重载>
     * @param node 节点
     * @param predicate 预测(过滤输入内容是否符合条件)
     * @return 所找节点
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Predicate<BinaryTree.TreeNode> predicate) {
        // 若节点id值刚好的等于所查询的id，则返回当前节点
        if (node.getId() == id ) {
            this.foundNode = node;
        }
        // 若为true,则将节点信息加入符合条件的数据集合中
        if (predicate.test(node)){
            filterNode.add(node);
        }
        return node;
    }

    /**
     * 根据id查找节点
     * @param node 节点
     * @param param 可变参数
     * @return 所找节点
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        // 若节点id值刚好的等于所查询的id，则返回当前节点
        if (node.getId() == id) {
            this.foundNode = node;
        }
        return node;
    }


    /**
     * 设置 id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取已找到的节点
     * @return 已找到的节点
     */
    @Override
    public BinaryTree.TreeNode getFoundNode() {
        return foundNode;
    }


    public List<BinaryTree.TreeNode> getFilterNode() {
        return filterNode;
    }

    /**
     * 如果条件为空，则无过滤条件
     */
    @Override
    public Predicate<BinaryTree.TreeNode> predicate() {
        return predicate == null?(s-> true) :(predicate);
    }
}

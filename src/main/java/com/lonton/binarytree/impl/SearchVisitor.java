package com.lonton.binarytree.impl;

import com.lonton.binarytree.pojo.BinaryTree;
import com.lonton.binarytree.IVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 根据id查找节点
 * <p/>
 * @author 张利红
 */
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
            // 若找到目标id,则停止查找,跳出循环
            this.foundNode.setLoop(false);
        }
        return node;
    }

    /**
     * 根据id查找节点<重载></重载>
     * @param node 节点
     * @param predicate 预测(过滤输入内容是否符合条件)
     * @return 所找节点
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Predicate<BinaryTree.TreeNode> predicate) {
        // 若节点id值刚好的等于所查询的id，则返回当前节点
        if (node.getId() == id) {
            this.foundNode = node;
            // 找到目标节点后,将loop重新赋值为false
            this.foundNode.setLoop(false);
        }
        // 若为true,则将节点信息加入符合条件的数据集合中
        if (predicate.test(node)){
            filterNode.add(node);
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
    public BinaryTree.TreeNode getFoundNode() {
        return foundNode;
    }

    //    /**
//     * 根据id搜索节点
//     * @param id id
//     * @param curNode 当前节点
//     * @return 具体搜索到的节点值
//     */
//    private BinaryTree.TreeNode search(int id, BinaryTree.TreeNode  curNode) {
//        // 当前节点为空，返回null
//        if (curNode == null) {
//            return null;
//        }
//        // 当前节点id和所查询的id相同时，则返回当前节点值
//        if (curNode.getId() == id) {
//            return curNode;
//        }
//        // 递归查询左子节点id值
//        BinaryTree.TreeNode  node = search(id, curNode.getLeftNode());
//        // 查出节点值非空，返回查出节点
//        if (node != null) {
//            return node;
//        }
//        // 递归查询右子节点id值
//        return search(id, curNode.getRightNode());
//    }


    public List<BinaryTree.TreeNode> getFilterNode() {
        return filterNode;
    }
}

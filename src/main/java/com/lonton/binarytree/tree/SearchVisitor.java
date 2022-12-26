package com.lonton.binarytree.tree;

import com.lonton.binarytree.tree.pojo.BinaryTree;

/**
 * 根据id查找节点
 * <p/>
 * @author 张利红
 */
public class SearchVisitor implements IVisitor {

    /**
     * 查寻id
     */
    private int id;

    /**
     * 已找到的节点
     */
    private BinaryTree.TreeNode foundNode;

    /**
     * 根据id查找节点
     * @param node 节点
     * @param param 可变参数
     * @return 所找节点
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        // 若节点id值刚好的等于所搜寻的id，则返回当前节点
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

}

package com.lonton.tree.impl;

import com.lonton.tree.IVisitor;
import com.lonton.tree.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 *打印访问输出
 *
 * @author 张利红
 * date:2022-11-06
 */
@Slf4j
public class PrintVisitor implements IVisitor {

    @Override
    public void visit(BinaryTree binaryTree) {
        act(binaryTree.getRoot());
    }

    /**
     * 遍历访问
     * @param treeNode
     */
    private void act(TreeNode treeNode) {
        if(treeNode==null){
            return;
        }
        log.info("当前节点：{}",treeNode.getData());
        act(treeNode.getLeft());
        act(treeNode.getRight());
    }
}
package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.IVisitor;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

/**
 *打印访问输出
 *　<p/>
 * @author 张利红
 */
@Slf4j
public class PrintVisitor implements IVisitor {

    @Override
    public int visit(BinaryTree binaryTree) {
        act(binaryTree.getRoot());
        return 0;
    }

    /**
     * 遍历打印
     * @param treeNode
     */
    private void act(BinaryTree.TreeNode treeNode) {
        if(treeNode==null){
            return;
        }
        log.info("当前节点：{}",treeNode.getData());
        act(treeNode.getLeft());
        act(treeNode.getRight());
    }
}

package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.IVisitor;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

/**
 *计算树的节点
 *　<p/>
 * @author 张利红
 */
@Slf4j
public class CountVisitor implements IVisitor {
    @Override
    public int visit(BinaryTree binaryTree) {
        return binaryTree.getNodeCount();
        //log.info("树的节点数为：{}",String.valueOf(binaryTree.getNodeCount()));
    }
}

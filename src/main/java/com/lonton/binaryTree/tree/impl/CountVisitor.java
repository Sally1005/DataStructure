package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.IVisitor;
import lombok.extern.slf4j.Slf4j;

/**
 *计算树的节点
 *
 * @author 张利红
 * date:2022-11-06
 */
@Slf4j
public class CountVisitor implements IVisitor {
    @Override
    public int visit(BinaryTree binaryTree) {
        return binaryTree.getNodeCount();
        //log.info("树的节点数为：{}",String.valueOf(binaryTree.getNodeCount()));
    }
}

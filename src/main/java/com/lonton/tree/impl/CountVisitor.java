package com.lonton.tree.impl;

import com.lonton.tree.IVisitor;
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
    public void visit(BinaryTree binaryTree) {
        log.info("树的节点数为：{}",String.valueOf(binaryTree.getNodeCount()));
    }
}

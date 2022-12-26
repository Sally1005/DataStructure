package com.lonton.binarytree.tree;

import com.lonton.binarytree.tree.pojo.BinaryTree;

/**
 * 计算节点个数
 * <p/>
 * @author 张利红
 */

public class NodeNumVisitor implements IVisitor {
    /**
     * 初始节点数
     */
    int count = 0 ;

    /**
     * 计算节点个数
     * @param node 节点
     * @param param 可变参数
     * @return 节点个数
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        count++;
        return count;
    }

    public int getCount() {
        return count;
    }

}

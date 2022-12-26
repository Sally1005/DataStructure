package com.lonton.binarytree.tree;

import com.lonton.binarytree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;


/**
 * 计算树高
 * <p/>
 * @author 张利红
 */

@Slf4j
public class CountHeightVisitor implements IVisitor {

    /**
     * 初始高度
     */
    private int height = 0;

    /**
     * 计算树高
     * @param node 节点
     * @param param 可变参数
     * @return 树高
     */
    @Override
    public Object visit(BinaryTree.TreeNode node, Object... param) {
        if (node.getLevel() > height) {
            height = node.getLevel();
        }
        return node;
    }

    /**
     * 获取树高
     * @return  树高
     */
    public int getHeight() {
        return height;
    }
}

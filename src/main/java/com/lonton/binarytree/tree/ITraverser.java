package com.lonton.binarytree.tree;

import com.lonton.binarytree.tree.pojo.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历数据
 * <p/>
 * @author 张利红
 */
public abstract class ITraverser {

    private IVisitor visitor;

    /**
     * 遍历
     */
    public List<Object> traverser(BinaryTree.TreeNode node){
        if(visitor == null){
            return null;
        }
        List<Object> arr = new ArrayList<Object>();
        visitor.visit(node,arr);
        return arr;
    }

    /**
     * 查找
     */
    public abstract BinaryTree.TreeNode search(BinaryTree.TreeNode root, int id);

    protected void setVisitor(IVisitor visitor){
        this.visitor = visitor;
    }
}



package com.lonton.binarytree.impl;

import com.lonton.binarytree.ITraverser;
import com.lonton.binarytree.IVisitor;
import com.lonton.binarytree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;


/**
 * 中序遍历
 * <p/>
 * @author 张利红
 */
@Slf4j
public  class MidTraverser implements ITraverser {
    /**
     * 访问树
     * @param tree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return
     */
    public  Object traverse(BinaryTree tree, IVisitor visitor, Object... param){
        recursive(tree.getRoot(),visitor);
        return tree;
    }

    /**
     * 递归中序遍历
     * @param root  根节点
     * @param visitor  visitor具体实现类
     */
    protected void recursive(BinaryTree.TreeNode root, IVisitor visitor) {
        // 左子节点是否存在
        if (root.getLeftNode() != null) {
            recursive(root.getLeftNode(), visitor);
            if (visitor.getFoundNode() !=null){
                return ;
            }
        }

        //当前节点
        visitor.visit(root, visitor.predicate());
        if (visitor.getFoundNode() !=null){
            return  ;
        }

        // 右子节点是否存在
        if (root.getRightNode() != null) {
            recursive(root.getRightNode(), visitor);
        }

    }


    /**
     * 非递归中序遍历
     * @param root 根节点
     * @param visitor visitor具体实现类
     */
    private void notRecursive(BinaryTree.TreeNode root, IVisitor visitor) {
        if (root == null) {
            return;
        }
        // 1.先将当前节点入栈
        BinaryTree.TreeNode temp = root;
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            // 2.将当前节点的所有左子树入栈，直到左子树为空
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeftNode();
            }
            temp = stack.pop();
            visitor.visit(temp);
            // 3.访问栈顶元素，如果栈顶元素存在右子树，则继续第2步
            if (temp.getRightNode() != null) {
                temp = temp.getRightNode();
            } else {
                temp = null;
            }
        }
    }
}

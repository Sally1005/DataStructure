package com.lonton.binarytree.tree.impl;

import com.lonton.binarytree.ATraverser;
import com.lonton.binarytree.tree.IVisitor;
import com.lonton.binarytree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 后序遍历
 * <p/>　
 * @author 张利红
 */

@Slf4j

public class PostTraverser extends ATraverser {
    /**
     * 访问树
     * @param tree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return
     */
    @Override
    public Object traverser(BinaryTree tree, IVisitor visitor, Object... param) {
        recursive(tree.getRoot(),visitor);
        return tree;
    }

    /**
     * 递归后序遍历
     * @param root 根节点
     * @param visitor visitor具体实现类
     */
    private void recursive(BinaryTree.TreeNode root, IVisitor visitor) {
        // 左子节点是否存在
        if (root.getLeftNode() != null) {
            recursive(root.getLeftNode(), visitor);
        }
        // 当前节点
        if (root.getRightNode() != null) {
            recursive(root.getRightNode(), visitor);
        }
        visitor.visit(root);
    }

    /**
     * 非递归后序遍历
     * @param root 根节点
     * @param visitor visitor具体实现类
     */
    private void notRecursive(BinaryTree.TreeNode root, IVisitor visitor) {
        if (root == null) {
            return;
        }
        // 1.先将当前节点入栈
        BinaryTree.TreeNode temp = root; // 记录当前访问的节点
        BinaryTree.TreeNode pre = null; // 上一个访问的节点
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            // 2.将当前节点的所有左子树入栈，直到左子树为空
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeftNode();
            }
            // 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右子树，
            // 如果存在并且没有被访问，则将右子树入栈，否则，就访问栈顶元素
            if (!stack.isEmpty()) {
                // 返回栈顶的元素但不移除它
                temp = stack.peek();
                if (temp != null) {
                    if (temp.getRightNode() == null || temp.getRightNode() == pre) {
                        temp = stack.pop();
                        visitor.visit(temp);
                        pre = temp;
                        temp = null;
                    } else {
                        temp = temp.getRightNode();
                    }
                }
            }

        }
    }
}

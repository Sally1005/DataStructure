package com.lonton.binarytree.impl;

import com.lonton.binarytree.ATraverser;
import com.lonton.binarytree.IVisitor;
import com.lonton.binarytree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 前序遍历
 * <p/>
 * @author 张利红
 */
@Slf4j
public abstract class PreTraverser extends ATraverser {
    /**
     * 访问树
     * @param tree 二叉树
     * @param visitor 访问visitor
     * @param param 可变参数
     * @return
     */

    public abstract Object traverse(BinaryTree tree, IVisitor visitor, Object... param);


    /**
     * 递归前序遍历
     * @param root 根节点
     * @param visitor visitor具体实现类
     */
    protected void recursive(BinaryTree.TreeNode root, IVisitor visitor) {
        // 根节点
        BinaryTree.TreeNode visit = (BinaryTree.TreeNode) visitor.visit(root);
       // 访问的id若与已找到的id,则停止查找
        if (root.getId() ==  visit.getId()){
            return;
        }
        // 左子节点是否存在
        if (root.getLeftNode() != null) {
            recursive(root.getLeftNode(), visitor);
        }
        // 右子节点是否存在
        if (root.getRightNode() != null) {
            recursive(root.getRightNode(), visitor);
        }
    }

    /**
     * 非递归前序遍历
     * @param root 根节点
     * @param visitor visitor具体实现类
     */
    private void notRecursive(BinaryTree.TreeNode root, IVisitor visitor) {
        // 创建一个栈对象
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        // 将当前节点放入栈中
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTree.TreeNode temp = stack.pop();
            // 栈不为空时，弹出栈中元素
            visitor.visit(temp);
            // 如果当前节点存在右子树，则将右子树入栈
            if (temp.getRightNode() != null) {
                stack.push(temp.getRightNode());
            }
            // 如果当前节点存在左子树，则将左子树入栈
            if (temp.getLeftNode() != null) {
                stack.push(temp.getLeftNode());
            }
        }
    }
}

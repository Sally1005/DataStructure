package com.lonton.tree.impl;

import com.lonton.tree.ITraverser;
import com.lonton.tree.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 *前序遍历
 *
 * @author 张利红
 * date:2022-11-06
 */
@Slf4j
public class PreTraverser implements ITraverser {
    /**
     * 递归前序遍历
     * @param data
     */
    private void pre(TreeNode data) {
        if (data == null) {
            return;
        }
        log.info("data:{}",  data.getData());
        pre(data.getLeft());
        pre(data.getRight());
    }

    /**
     * 前序遍历搜索查询
     * @param data
     * @param id
     * @return
     */
    private TreeNode preOrderTraversalSearch(TreeNode data, int id) {
        TreeNode resultNode; // 查询结果为空
        if (data == null) {
            return null;
        }
        if (data.getId() == id) {
            return data;
        }
        if (data.getLeft() != null) {
            resultNode = preOrderTraversalSearch(data.getLeft(), id); // 如果左子节点不为空，向左递归遍历查询
            if (resultNode != null) { // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data.getRight() != null) {
            resultNode = preOrderTraversalSearch(data.getRight(), id); // 如果右子节点不为空，向右递归遍历查询
            // 查询结果不为空，则已查到该节点
            return resultNode;
        }
        return null;
    }

    /**
     * 非递归前序遍历
     * @param data
     */
    private void preOrder(TreeNode data) {
        if (data == null) {
           return;
        }
        Stack<TreeNode> stack = new Stack<>(); // 创建一个栈对象
        stack.push(data); // 将当前节点放入栈中
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            log.info("data:{}",temp.getData()); // 栈不为空时，弹出栈中元素
            if (temp.getRight() != null) { // 如果当前节点存在右子树，则将右子树入栈
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) { // 如果当前节点存在左子树，则将左子树入栈
                stack.push(temp.getLeft());
            }
        }
    }

    @Override
    public void RecursiveTraversal(BinaryTree binaryTree) {
        pre(binaryTree.getRoot());
    }

    @Override
    public TreeNode TraversalSearch(BinaryTree binaryTree, int id) {
        return preOrderTraversalSearch(binaryTree.getRoot(), id);
    }

    @Override
    public void NotRecursiveTraversal(BinaryTree binaryTree) {
        preOrder(binaryTree.getRoot());

    }

}

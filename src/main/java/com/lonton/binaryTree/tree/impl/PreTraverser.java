package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.ITraverser;
import com.lonton.binaryTree.tree.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Stack;

/**
 *前序遍历
 *
 * @author 张利红
 */
@Slf4j
public class PreTraverser implements ITraverser {
    /**
     * 递归前序遍历
     * @param data
     */
    private void pre(TreeNode data,ArrayList<String> arrayList) {
        if (data == null) {
            return;
        }
        arrayList.add(data.getData());
        pre(data.getLeft(),arrayList);
        pre(data.getRight(),arrayList);
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
    private void preOrder(TreeNode data,ArrayList<String> arrayList) {
        if (data == null) {
           return;
        }
        Stack<TreeNode> stack = new Stack<>(); // 创建一个栈对象
        stack.push(data); // 将当前节点放入栈中
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
           arrayList.add(temp.getData()); // 栈不为空时，弹出栈中元素
            if (temp.getRight() != null) { // 如果当前节点存在右子树，则将右子树入栈
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) { // 如果当前节点存在左子树，则将左子树入栈
                stack.push(temp.getLeft());
            }
        }
    }

    @Override
    public ArrayList<String> recursiveTraversal(BinaryTree binaryTree) {
        ArrayList<String> strings = new ArrayList<>();
        pre(binaryTree.getRoot(),strings);
        return strings;
    }

    @Override
    public TreeNode traversalSearch(BinaryTree binaryTree, int id) {
        return preOrderTraversalSearch(binaryTree.getRoot(), id);
    }

    @Override
    public  ArrayList<String> notRecursiveTraversal(BinaryTree binaryTree) {
        ArrayList<String> strings = new ArrayList<>();
        preOrder(binaryTree.getRoot(),strings);
        return strings;
    }

}

package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.ITraverser;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 中序遍历
 * 　<p/>
 * @author 张利红
 */
@Slf4j
public class MidTraverser implements ITraverser {
    /**
     * 递归中序遍历
     * @param data
     */
    private void mid(BinaryTree.TreeNode data, ArrayList<String> arrayList) {
        if (data == null) {
            return;
        }
        mid(data.getLeft(),arrayList);
        arrayList.add(data.getData());
        mid(data.getRight(),arrayList);
    }

    /**
     * 中序遍历搜索查询
     * @param data
     * @param id
     * @return
     */
    private BinaryTree.TreeNode midOrderTraversalSearch(BinaryTree.TreeNode data, int id) {
        BinaryTree.TreeNode resultNode; // 查询结果为空
        if (data == null) {
            return null;
        }
        if (data.getLeft() != null) {
            resultNode = midOrderTraversalSearch(data.getLeft(), id); // 如果左子节点不为空，向左递归遍历查询
            if (resultNode != null) { // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data.getId() == id) {
            return data;
        }
        if (data.getRight() != null) {
            resultNode = midOrderTraversalSearch(data.getRight(), id); // 如果右子节点不为空，向右递归遍历查询
            // 查询结果不为空，则已查到该节点
            return resultNode;
        }
        return null;
    }

    /**
     * 非递归中序遍历
     * @param data
     */
    private void midOrder(BinaryTree.TreeNode data, ArrayList<String> arrayList) {
        if (data == null) {
          return;
        }
        BinaryTree.TreeNode temp = data; // 1.先将当前节点入栈
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {

            while (temp != null) { // 2.将当前节点的所有左子树入栈，直到左子树为空
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            arrayList.add(temp.getData());
            if (temp.getRight() != null) { // 3.访问栈顶元素，如果栈顶元素存在右子树，则继续第2步
                temp = temp.getRight();
            } else {
                temp = null;
            }
        }
    }
    @Override
    public ArrayList<String>  recursiveTraversal(BinaryTree binaryTree) {
        ArrayList<String> strings = new ArrayList<>();
        mid(binaryTree.getRoot(), strings);
        return strings;

    }

    @Override
    public BinaryTree.TreeNode traversalSearch(BinaryTree binaryTree, int id) {
        return midOrderTraversalSearch(binaryTree.getRoot(), id);
    }

    @Override
    public ArrayList<String> notRecursiveTraversal(BinaryTree binaryTree) {
        ArrayList<String> strings = new ArrayList<>();
        midOrder(binaryTree.getRoot(),strings);
        return strings;
    }
}

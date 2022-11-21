package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.ITraverser;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 后序遍历
 * 　<p/>
 * @author 张利红
 */

@Slf4j
public class PostTraverser implements ITraverser {
    /**
     * 递归后序遍历
     * @param data
     */
    private void post(BinaryTree.TreeNode data, ArrayList<String> arrayList) {
        if (data == null) {
            return;
        }
        post(data.getLeft(),arrayList);
        post(data.getRight(),arrayList);
        arrayList.add(data.getData());
    }

    /**
     * 后序遍历搜索查询
     * @param data
     * @param id
     * @return
     */
    private BinaryTree.TreeNode postOrderTraversalSearch(BinaryTree.TreeNode data, int id) {
        BinaryTree.TreeNode resultNode;
        if (data == null) {
            return null;
        }
        if (data.getLeft() != null) {
            resultNode = postOrderTraversalSearch(data.getLeft(), id); // 如果左子节点不为空，向左递归遍历查询
            if (resultNode != null) { // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data.getRight() != null) {
            resultNode = postOrderTraversalSearch(data.getRight(), id); // 如果右子节点不为空，向右递归遍历查询
            // 查询结果不为空，则已查到该节点
            if (resultNode != null) { // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data.getId() == id) {
            return data;
        }
        return null;
    }


    /**
     * 非递归后序遍历
     * @param data
     */
    private void postOrder(BinaryTree.TreeNode data, ArrayList<String> arrayList) {
        if (data == null) {
           return;
        }
        /**
         * 1.先将当前节点入栈
         */
        BinaryTree.TreeNode temp = data; // 记录当前访问的节点
        BinaryTree.TreeNode pre = null; // 上一个访问的节点
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            /**
             * 2.将当前节点的所有左子树入栈，直到左子树为空
             */
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            /**
             * 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右子树，如果存在并且没有被访问，
             *    则将右子树入栈，否则，就访问栈顶元素
             */
            if (!stack.isEmpty()) {
                temp = stack.peek(); // 返回栈顶的元素但不移除它
                if (temp != null) {
                    if (temp.getRight() == null || temp.getRight() == pre) {
                        temp = stack.pop();
                        arrayList.add(temp.getData());
                        pre = temp;
                        temp = null;
                    } else {
                        temp = temp.getRight();
                    }
                }
            }

        }
    }

    @Override
    public ArrayList<String> recursiveTraversal(BinaryTree binaryTree) {
        ArrayList<String> strings = new ArrayList<>();
        post(binaryTree.getRoot(),strings);
        return strings;

    }

    @Override
    public BinaryTree.TreeNode traversalSearch(BinaryTree binaryTree, int id) {
        return postOrderTraversalSearch(binaryTree.getRoot(), id);
    }

    @Override
    public ArrayList<String> notRecursiveTraversal(BinaryTree binaryTree) {
        ArrayList<String> strings = new ArrayList<>();
        postOrder(binaryTree.getRoot(),strings);
        return strings;
    }
}

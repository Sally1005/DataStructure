package com.lonton.tree.impl;

import com.lonton.tree.ITraverser;
import com.lonton.tree.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 *后序遍历
 *
 * @author 张利红
 * date:2022-11-06
 */

@Slf4j
public class PostTraverser implements ITraverser {
    /**
     * 递归后序遍历
     * @param data
     */
    private void post(TreeNode data) {
        if (data == null) {
            return;
        }
        post(data.getLeft());
        post(data.getRight());
        log.info("data:{}", data.getData());
    }

    /**
     * 后序遍历搜索查询
     * @param data
     * @param id
     * @return
     */
    private TreeNode postOrderTraversalSearch(TreeNode data, int id) {
        TreeNode resultNode;
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

    @Override
    public void RecursiveTraversal(BinaryTree binaryTree) {
        post(binaryTree.getRoot());
    }

    @Override
    public TreeNode TraversalSearch(BinaryTree binaryTree, int id) {
        return postOrderTraversalSearch(binaryTree.getRoot(), id);
    }

    /**
     * 非递归后序遍历
     * @param data
     */
    private void postOrder(TreeNode data) {
        if (data == null) {
            log.info(null);
        }
        /**
         * 1.先将当前节点入栈
         */
        TreeNode temp = data; // 记录当前访问的节点
        TreeNode pre = null; // 上一个访问的节点
        Stack<TreeNode> stack = new Stack<>();
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
                        log.info(temp.getData() + "");
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
    public void NotRecursiveTraversal(BinaryTree binaryTree) {
        postOrder(binaryTree.getRoot());
    }
}

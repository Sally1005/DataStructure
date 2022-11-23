package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.ITraverser;
import com.lonton.binaryTree.tree.IVisitor;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 * 　<p/>
 * @author 张利红
 */

@Slf4j
@SuppressWarnings("all")
public class PostTraverser extends ITraverser {

    /**
     * 递归遍历
     */
    private class Recursive implements IVisitor {

        @Override
        public void visit(BinaryTree.TreeNode root, List<Object> list) {
             // 左子节点是否存在
            if(root.getLeft() != null){
                visit(root.getLeft(), list);
            }
             // 右子节点是否存在
            if(root.getRight() != null){
                visit(root.getRight(), list);
            }
             // 添加当前节点
            list.add(root.getData());
        }
    }

    /**
     * 非递归遍历
     */
    private class NotRecursive implements IVisitor{

        @Override
        public void visit(BinaryTree.TreeNode root, List<Object> list) {
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
                    temp = temp.getLeft();
                }
                 // 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右子树，
                 // 如果存在并且没有被访问，则将右子树入栈，否则，就访问栈顶元素
                if (!stack.isEmpty()) {
                     // 返回栈顶的元素但不移除它
                    temp = stack.peek();
                    if (temp != null) {
                        if (temp.getRight() == null || temp.getRight() == pre) {
                            temp = stack.pop();
                            list.add(temp.getData());
                            pre = temp;
                            temp = null;
                        } else {
                            temp = temp.getRight();
                        }
                    }
                }

            }
        }
    }

    public PostTraverser() {
        this(true);
    }
     // 判断后序访问顺序是否为递归遍历
    public PostTraverser(boolean recursive) {
        if(recursive){
            setVisitor(new Recursive());
        }else{
            setVisitor(new NotRecursive());
        }
    }

    /**
     * 查找
     * @param root
     * @param id
     */
    @Override
    public BinaryTree.TreeNode search(BinaryTree.TreeNode root, int id) {
        BinaryTree.TreeNode resultNode;
        if (root == null) {
            return null;
        }
        if (root.getLeft() != null) {
             // 如果左子节点不为空，向左递归遍历查询
            resultNode = search(root.getLeft(), id);
             // 查询结果不为空，则已查到该节点
            if (resultNode != null) {
                return resultNode;
            }
        }
        if (root.getRight() != null) {
             // 如果右子节点不为空，向右递归遍历查询
            resultNode = search(root.getRight(), id);
             // 查询结果不为空，则已查到该节点
            if (resultNode != null) {
                return resultNode;
            }
        }
        if (root.getId() == id) {
            return root;
        }
        return null;
    }

}

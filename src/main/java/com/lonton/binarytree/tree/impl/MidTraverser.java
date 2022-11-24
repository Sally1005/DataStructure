package com.lonton.binarytree.tree.impl;

import com.lonton.binarytree.tree.ITraverser;
import com.lonton.binarytree.tree.IVisitor;
import com.lonton.binarytree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * 　<p/>
 * @author 张利红
 */
@Slf4j
public class MidTraverser extends ITraverser {
    /**
     * 递归遍历 <br/>
     * visitor决定访问行为，理解为先遍历左子树还是先遍历右子树<br/>
     * traverser决定访问顺序，理解为前/中/后序遍历
     */
    private class Recursive implements IVisitor{

        @Override
        public void visit(BinaryTree.TreeNode root, List<Object> list) {
             // 左子节点是否存在
            if(root.getLeft() != null){
                visit(root.getLeft(), list);
            }
             // 添加当前节点
            list.add(root.getData());
             // 右子节点是否存在
            if(root.getRight() != null){
                visit(root.getRight(), list);
            }
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
            BinaryTree.TreeNode temp = root;
            Stack<BinaryTree.TreeNode> stack = new Stack<>();
            while (temp != null || !stack.isEmpty()) {
                 // 2.将当前节点的所有左子树入栈，直到左子树为空
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.getLeft();
                }
                temp = stack.pop();
                list.add(temp.getData());
                 // 3.访问栈顶元素，如果栈顶元素存在右子树，则继续第2步
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                } else {
                    temp = null;
                }
            }
        }
    }

    public MidTraverser() {
        this(true);
    }

     // 判断中序访问顺序是否为递归遍历
    public MidTraverser(boolean recursive) {
        if(recursive){
            setVisitor(new Recursive());
        }else{
            setVisitor(new NotRecursive());
        }
    }

    /**
     * 查找
     * <br/>
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
        if (root.getId() == id) {
            return root;
        }
        if (root.getRight() != null) {
             // 如果右子节点不为空，向右递归遍历查询
            resultNode = search(root.getRight(), id);
             // 查询结果不为空，则已查到该节点
            if (resultNode != null) {
                return resultNode;
            }
        }
        return null;
    }
}

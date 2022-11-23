package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.ITraverser;
import com.lonton.binaryTree.tree.IVisitor;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *前序遍历
 * 　<p/>
 * @author 张利红
 */
@Slf4j
@SuppressWarnings("all")
public class PreTraverser extends ITraverser {

    /**
     * 递归遍历
     */
    private class Recursive implements IVisitor{

        @Override
        public void visit(BinaryTree.TreeNode root, List<Object> list) {
             // 添加当前节点
            list.add(root.getData());
             // 左子节点是否存在
            if(root.getLeft() != null){
                visit(root.getLeft(), list);
            }
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
             // 创建一个栈对象
            Stack<BinaryTree.TreeNode> stack = new Stack<>();
             // 将当前节点放入栈中
            stack.push(root);
            while (!stack.isEmpty()) {
                BinaryTree.TreeNode temp = stack.pop();
                 // 栈不为空时，弹出栈中元素
                list.add(temp.getData());
                 // 如果当前节点存在右子树，则将右子树入栈
                if (temp.getRight() != null) {
                    stack.push(temp.getRight());
                }
                 // 如果当前节点存在左子树，则将左子树入栈
                if (temp.getLeft() != null) {
                    stack.push(temp.getLeft());
                }
            }
        }
    }

    public PreTraverser() {
        this(true);
    }
    // 判断前·序访问顺序是否为递归遍历
    public PreTraverser(boolean recursive) {
        if(recursive){
            setVisitor(new Recursive());
        }else{
            setVisitor(new NotRecursive());
        }
    }

    /**
     * 查找
     *
     * @param root
     * @param id
     */
    @Override
    public BinaryTree.TreeNode search(BinaryTree.TreeNode root, int id) {
        BinaryTree.TreeNode resultNode;
         // 查询结果为空
        if (root == null) {
            return null;
        }
        if (root.getId() == id) {
            return root;
        }
        if (root.getLeft() != null) {
             // 如果左子节点不为空，向左递归遍历查询
            resultNode = search(root.getLeft(), id);
            if (resultNode != null) { // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
         // 如果右子节点不为空，向右递归遍历查询
        if (root.getRight() != null) {
            resultNode = search(root.getRight(), id);
            // 查询结果不为空，则已查到该节点
            return resultNode;
        }
        return null;
    }
}

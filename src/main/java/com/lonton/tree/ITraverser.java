package com.lonton.tree;

import com.lonton.tree.impl.BinaryTree;
import com.lonton.tree.pojo.TreeNode;

/**
 *二叉树遍历数据接口
 *
 * @author 张利红
 * date:2022-11-05
 */
public interface ITraverser {
    /**
     * 递归遍历二叉树
     * @param binaryTree
     */
    void RecursiveTraversal(BinaryTree binaryTree);

    /**
     * 非递归遍历二叉树
     * @param binaryTree
     */
    void NotRecursiveTraversal(BinaryTree binaryTree);

    /**
     * 根据id遍历搜索树
     * @param binaryTree
     * @param id
     * @return
     */
    TreeNode TraversalSearch(BinaryTree binaryTree, int id);


    /**
     *
     * 递归转非递归的通用原理
     *
     * 递归的话是通过栈来保存状态的，然后再次调用自己进入一个新的状态，然后函数返回的时候又回到上次保存的状态。
     * 递归时，计算机会帮我们做入栈，出栈等操作，并且在入栈时，会记录上下文信息（节点出栈后，从什么位置执行），
     * 代码书写简单，可读性强，但占用空间大，易发生栈溢出。
     *
     * 转为非递归时，我们就得自己记录上下文信息了。一般的递归，想要转化为非递归，就需要模拟栈的行为。
     * 栈可以理解为一个记录局部变量的容器。首先是局部变量初始化的状态，然后进入一个循环执行代码时，遇到递归，
     * 就只做状态压栈保存，然后更新局部变量进入下一层。如果一个调用结束了，就要返回上层状态。直接将栈里的记录弹出，
     * 拿来更新当前状态。若某个调用结束时，栈为空，则所有调用都结束，退出主循环。
     * 非递归代码书写起来很复杂，可读性和维护性不强，但是执行效率会比迭代稍快。
     * 还是得根据实际的情况用哪种方式来遍历，非递归可以通过模拟栈和循环来实现递归。
     */
}



package com.lonton.tree;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树类
 * @author 张利红
 */
@Slf4j
public class BinaryTree<T extends Comparable<T>> implements BT<T> {
    /**
     * TreeNode类作为根节点
     */
    private TreeNode<T> root;

    /**
     *
     * @param key
     */
    @Override
    public void add(T key) {
        TreeNode<T> newNode = new TreeNode<>(key, null);
        if(root == null){
            this.root = newNode;
            return;
        }
        TreeNode<T> it = root;
        while (it != null) {
            if (isGreaterThan(key, it.getKey())) {
                if (it.getRight() == null) {
                    addRightChild(it, newNode);
                    break;
                }
                it = it.getRight();
            } else {
                if (it.getLeft() == null) {
                    addLeftChild(it, newNode);
                    break;
                }
                it = it.getLeft();
            }
        }
    }

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    private boolean isGreaterThan(T o1, T o2) {
        return o1.compareTo(o2) > 0;
    }

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    private boolean isEqual(T o1, T o2) {
        return o1.compareTo(o2) == 0;
    }


    /**
     *
     * @param parent
     * @param child
     */
    private void addLeftChild(TreeNode<T> parent, TreeNode<T> child) {
        child.setParent(parent);
        parent.setLeft(child);
    }

    /**
     *
     * @param parent
     * @param child
     */
    private void addRightChild(TreeNode<T> parent, TreeNode<T> child) {
        child.setParent(parent);
        parent.setRight(child);
    }

    /**
     * 递归前序遍历：当前节点->左子树->右子树
     * @param
     */
    @Override
    public List<T> pre() {
        List<T> values = new ArrayList<>();
        pre(this.root, values);
        return values;
    }

    private void pre(TreeNode<T> node, List<T> values) {
        if (node == null)
            return;
        values.add(node.getKey());
        pre(node.getLeft(), values);
        pre(node.getRight(), values);
    }
    /**
     * 递归中序遍历：左子树->当前节点->右子树
     * @param
     */
    @Override
    public  List<T> mid() {
        List<T> values = new ArrayList<>();
       mid(this.root, values);
        return values;
    }

    private void mid(TreeNode<T> node, List<T> values) {
        if (node == null)
            return;
        mid(node.getLeft(), values);
        values.add(node.getKey());
        mid(node.getRight(), values);
    }
    /**
     * 递归后序遍历：左子树->右子树->当前节点
     * @param
     */
    @Override
    public  List<T> post() {
        List<T> values = new ArrayList<>();
        post(this.root, values);
        return values;
    }

    private void post(TreeNode<T> node, List<T> values) {
        if (node == null)
            return;
        post(node.getLeft(), values);
        post(node.getRight(), values);
        values.add(node.getKey());
    }

    @Override
    public TreeNode<T> search(T key) {
        return searchNode(key);
    }

    private TreeNode<T> searchNode(T key) {
        TreeNode<T> it = root;
        while (it != null) {
            if (isEqual(key, it.getKey()))
                return it;
            if (isGreaterThan(key, it.getKey()))
                it = it.getRight();
            else
                it = it.getLeft();
        }
        return null;
    }


//    /**
//     * 非递归前序遍历
//     * @param
//     */
//    @Override
//    public void preOrder(TreeNode data){
//        if (root == null){
//           log.info("当前节点为空");
//        }
//        Stack<TreeNode> stack = new Stack<>(); // 创建一个栈对象
//        stack.push(root); // 将根节点放入栈中
//        while(!stack.isEmpty()){
//            TreeNode temp = stack.pop();
//            log.info(); // 栈不为空时，弹出栈中元素
//            if (temp.getRight()!=null){ // 如果当前节点存在右子树，则将右子树入栈
//                stack.push(temp.getRight());
//            }
//            if (temp.getLeft()!=null){ // 如果当前节点存在左子树，则将左子树入栈
//                stack.push(temp.getLeft());"当前节点：{}",temp.getParent()
//            }
//        }
//

//    /**
//     * 非递归中序遍历
//     * @param data 当前节点
//     */
//    @Override
//    public  void midOrder(TreeNode data){
//        if (data==null){
//            log.info("当前节点为空");
//        }
//        TreeNode temp = data; // 1.先将当前节点入栈
//        Stack<TreeNode> stack = new Stack<>();
//        while(temp != null || !stack.isEmpty()){
//
//            while(temp != null){ // 2.将当前节点的所有左子树入栈，直到左子树为空
//                stack.push(temp);
//                temp = temp.getLeft();
//            }
//            temp = stack.pop();
//           log.info("当前节点：{}",temp.getParent());
//            if(temp.getRight()!= null){ // 3.访问栈顶元素，如果栈顶元素存在右子树，则继续第2步
//                temp = temp.getRight();
//            }else {
//                temp = null;
//            }
//        }
//    }
//    /**
//     * 非递归后续遍历
//     * @param data 当前节点
//     */
//    @Override
//    public void postOrder(TreeNode data){
//        if (data == null){
//            log.info("当前节点为空");
//        }
//        /**
//         * 1.先将当前节点入栈
//         */
//        TreeNode temp = data; // 记录当前访问的节点
//        TreeNode pre = null; // 上一个访问的节点
//        Stack<TreeNode> stack = new Stack<>();
//        while(temp!= null || !stack.isEmpty()){
//            /**
//             * 2.将当前节点的所有左子树入栈，直到左子树为空
//             */
//            while(temp!= null){
//                stack.push(temp);
//                temp = temp.getLeft();
//            }
//            /**
//             * 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右子树，如果存在并且没有被访问，
//             *    则将右子树入栈，否则，就访问栈顶元素
//             */
//            if(!stack.isEmpty()){
//                temp = stack.peek(); // 返回栈顶的元素但不移除它
//                if(temp != null){
//                    if(temp.getRight() == null || temp.getRight() == pre){
//                        temp = stack.pop();
//                        log.info("当前节点：{}",temp.getParent());
//                        pre = temp;
//                        temp = null;
//                    }else {
//                        temp = temp.getRight();
//                    }
//                }
//            }
//
//        }
//    }


    /**
     * 计算树高
     * @param data 当前节点
     * @return int 返回树的高度
     */
    public int countHeight(TreeNode data) {
        if (data == null) {
            return 0;
        } // 若当前节点为空，则返回0
        int lHeight = countHeight(data.getLeft()); // 递归计算左子树的高度
        int rHeight = countHeight(data.getRight()); // 递归计算右子树的高度
        return (lHeight < rHeight) ? rHeight + 1 : lHeight + 1; // 判断该节点的左右子树中的高度，再在较高高度上 + 1

         }


    /**
     * 计算节点个数
     * @param data 当前节点
     * @return int 返回节点个数
     */
    public int countNodes(TreeNode data) {
        if (data == null) { // 若当前节点为空，则返回0
            return 0;
        }
        return countNodes(data.getLeft()) + countNodes(data.getRight()) + 1; // 递归求左右子树的节点个数和 + 1
    }


    /**
     * 前序遍历查找节点
     * @param data  当前节点
     * @param rank  排名
     * @return  查找节点
     */
    public  TreeNode preOrderTraversalSearch(TreeNode data,int rank){
        if (data != null){
            if (data.getRank() == rank){
                return data;
            }
        } // 当前节点为要查找的节点，就返回当前节点
        TreeNode resultNode = null; // 查询结果为空
        if (data.getLeft() != null){
            resultNode = preOrderTraversalSearch(data.getLeft(),rank); // 如果左子节点不为空，向左递归遍历查询
            if (resultNode != null){ // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data.getRight() != null){
            resultNode = preOrderTraversalSearch(data.getRight(),rank); // 如果右子节点不为空，向右递归遍历查询
            if (resultNode != null){ // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        return resultNode; // 返回查询结果null
    }

    /**
     * 中序遍历查找节点
     * @param data  当前节点
     * @param rank  排名
     * @return  查找节点
     */
    public  TreeNode midOrderTraversalSearch(TreeNode data ,int  rank ){
        TreeNode resultNode = null; // 查询结果为空
        if (data.getLeft() != null){
            resultNode  = midOrderTraversalSearch(data.getLeft(), rank ); // 如果左子节点不为空，向左递归遍历查询
            if (resultNode  != null){ // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data != null){
            if (data.getRank() ==  rank ){
                return data;
            }
        } // 当前节点为要查找的节点，就返回当前节点
        if (data.getRight() != null){
            resultNode  = midOrderTraversalSearch(data.getRight(), rank ); // 如果右子节点不为空，向右递归遍历查询
            if (resultNode  != null){ // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        return resultNode;
    }

    /**
     * 后序遍历查找节点
     * @param data  当前节点
     * @param rank  排名
     * @return  查找节点
     */
    public TreeNode postOrderTraversalSearch(TreeNode data ,int  rank){
        TreeNode resultNode  = null;

        if (data.getLeft() != null){
            resultNode  = postOrderTraversalSearch(data.getLeft(), rank); // 如果左子节点不为空，向左递归遍历查询
            if (resultNode  != null){ // 查询结果不为空，则已查到该节点
                return resultNode;
            }
        }
        if (data.getRight() != null){
            resultNode  = postOrderTraversalSearch(data.getRight(), rank); // 如果右子节点不为空，向右递归遍历查询
            if (resultNode  != null){ // 查询结果不为空，则已查到该节点
                return resultNode ;
            }
        }
        if (data.getRank()== rank){
            return data;
        } // 当前节点为要查找的节点，就返回当前节点
        return resultNode ;
    }
}


package com.lonton.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


@Slf4j
 public class BinaryTreeTest {
    /**
     * 前序遍历打印二叉树
     */
    @Test
    public void testBinaryTreePre() {
        List<Integer> expected = Arrays.asList(1, 2, 12, 11, 13);
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        log.info("前序遍历打印二叉树：{}",tree.pre());
        assertIterableEquals(expected, tree.pre());
    }
    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void testBinaryTreeMid() {
        List<Integer> expected = Arrays.asList(8, 9, 33, 12, 13);
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(9);
        tree.add(8);
        tree.add(12);
        tree.add(33);
        tree.add(13);
        log.info("中遍历打印二叉树：{}",tree.mid());
        assertIterableEquals(expected, tree.mid());
    }
    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void testBinaryTreePost() {
        List<Integer> expected = Arrays.asList(8, 12, 21, 13, 33);
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(33);
        tree.add(8);
        tree.add(12);
        tree.add(21);
        tree.add(13);
        log.info("后序遍历打印二叉树：{}",tree.post());
        assertIterableEquals(expected,tree.post());
    }
    @Test
    public void testBinaryTreeAdd() {
     List<Integer> expected1 = Arrays.asList(10, 8, 12, 11, 13);
     BinaryTree<Integer> tree = new BinaryTree<>();
     tree.add(10);
     tree.add(8);
     tree.add(12);
     tree.add(11);
     tree.add(13);
     log.info("输出1：{}",tree.pre());

     assertIterableEquals(expected1, tree.pre());

     List<Integer> expected2 = Arrays.asList(10, 8, 2, 6, 4, 12, 11, 13);
     tree.add(2);
     tree.add(6);
     tree.add(4);
     log.info("输出2：{}",tree.pre());
     assertIterableEquals(expected2, tree.pre());


 }


//    /**
//     * 非递归前序遍历打印二叉树
//     */
//    @Test
//    public void testBinaryTreePreOrder(){
//        List<Integer> expected = Arrays.asList(10, 8, 12, 11, 13);
//        BinaryTree<Integer> tree = new BinaryTree<>();
//        tree.add(10);
//        tree.add(8);
//        tree.add(12);
//        tree.add(11);
//        tree.add(13);
//        log.info("前序遍历打印二叉树：{}",tree.preOrder());
//        assertIterableEquals(expected, tree.preOrder());
//    }

//    /**
//     * 非递归中序遍历打印二叉树
//     */
//    //@Test
//    public void midOrder(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1);
//        TreeNode<Object> b = new TreeNode<>(2);
//        TreeNode<Object> c = new TreeNode<>(3);
//        TreeNode<Object> d = new TreeNode<>(4);
//        TreeNode<Object> e = new TreeNode<>(5);
//        TreeNode<Object> f = new TreeNode<>(6);
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        log.info("非递归中序遍历二叉树：");
//        binaryTree.midOrder(a); // 421536
//    }
//
//    /**
//     * 非递归后序遍历打印二叉树
//     */
//   // @Test
//    public void postOrder(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1);
//        TreeNode<Object> b = new TreeNode<>(2);
//        TreeNode<Object> c = new TreeNode<>(3);
//        TreeNode<Object> d = new TreeNode<>(4);
//        TreeNode<Object> e = new TreeNode<>(5);
//        TreeNode<Object> f = new TreeNode<>(6);
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        log.info("非递归后序遍历二叉树：");
//        binaryTree.postOrder(a); //425631
//    }
//
//    /**
//     * 测试计算树的高度
//     */
//   // @Test
//    public void countHeight(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1);
//        TreeNode<Object> b = new TreeNode<>(2);
//        TreeNode<Object> c = new TreeNode<>(3);
//        TreeNode<Object> d = new TreeNode<>(4);
//        TreeNode<Object> e = new TreeNode<>(5);
//        TreeNode<Object> f = new TreeNode<>(6);
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        log.info("树的高度："+binaryTree.countHeight(a)); // 3
//    }
//
//    /**
//     * 测试计算树的节点个数
//     */
//  //  @Test
//    public  void countNodes(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1);
//        TreeNode<Object> b = new TreeNode<>(2);
//        TreeNode<Object> c = new TreeNode<>(3);
//        TreeNode<Object> d = new TreeNode<>(4);
//        TreeNode<Object> e = new TreeNode<>(5);
//        TreeNode<Object> f = new TreeNode<>(6);
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        log.info("树的节点个数："+binaryTree.countNodes(a)); // 6
//    }
//
//    /**
//     * 前序遍历查找节点
//     *        1
//     *
//     *   2        3
//     *
//     *  4       5       6
//     *
//     */
//   @Test
//    public void preOrderTraversalSearch(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1,"兰");
//        TreeNode<Object> b = new TreeNode<>(2,"竹");
//        TreeNode<Object> c = new TreeNode<>(3,"梅");
//        TreeNode<Object> d = new TreeNode<>(4,"菊");
//        TreeNode<Object> e = new TreeNode<>(5,"荷");
//        TreeNode<Object> f = new TreeNode<>(6,"牡丹");
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        TreeNode treeNode = binaryTree.preOrderTraversalSearch(a, 3);
//       log.info("获取到的树的节点："+ treeNode);
//    }
//    /**
//     * 中序遍历查找节点
//     */
//   // @Test
//    public void midOrderTraversalSearch(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1,"兰");
//        TreeNode<Object> b = new TreeNode<>(2,"竹");
//        TreeNode<Object> c = new TreeNode<>(3,"梅");
//        TreeNode<Object> d = new TreeNode<>(4,"菊");
//        TreeNode<Object> e = new TreeNode<>(5,"荷");
//        TreeNode<Object> f = new TreeNode<>(6,"牡丹");
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        TreeNode treeNode = binaryTree.midOrderTraversalSearch(a, 4);
//        log.info("获取到的树的节点："+ treeNode);
//    }
//    /**
//     * 后序遍历查找节点
//     */
//     @Test
//    public void postOrderTraversalSearch(){
//        BinaryTree binaryTree = new BinaryTree();
//        //构造二叉树
//        TreeNode<Object> a = new TreeNode<>(1,"兰");
//        TreeNode<Object> b = new TreeNode<>(2,"竹");
//        TreeNode<Object> c = new TreeNode<>(3,"梅");
//        TreeNode<Object> d = new TreeNode<>(4,"菊");
//        TreeNode<Object> e = new TreeNode<>(5,"荷");
//        TreeNode<Object> f = new TreeNode<>(6,"牡丹");
//        a.setLeft(b);
//        a.setRight(c);
//        b.setLeft(d);
//        c.setLeft(e);
//        c.setRight(f);
//        TreeNode treeNode = binaryTree.postOrderTraversalSearch(a, 4);
//         log.info("获取到的树的节点："+ treeNode);
//    }
}

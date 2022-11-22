package com.lonton.tree;

import com.lonton.binaryTree.TreeApplication;
import com.lonton.binaryTree.dao.NodeDao;
import com.lonton.binaryTree.tree.impl.*;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * 二叉树单元测试
 *
 * @author 张利红
 */
@SuppressWarnings("all")
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TreeApplication.class)
public class BinaryTreeTest {
    @Autowired
    NodeDao stringNodeDao;

    public BinaryTree BuildTree() {
        List<BinaryTree.TreeNode> nodeList = stringNodeDao.getNodeList();
        BinaryTree binaryTree = new BinaryTree(nodeList);
        return binaryTree;
    }

    /**
     * 前序遍历打印二叉树
     */
    @Test
    public void pre() {
        BinaryTree binaryTree = BuildTree();
        PreTraverser preTraverser = new PreTraverser();
        ArrayList<String> target = preTraverser.recursiveTraversal(binaryTree);
        ArrayList<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小绿");
        list.add("小黄");
        list.add("小红");
        list.add("小吴");
        list.add("小哈");
        list.add("小黑");
        assert target.equals(list);

    }

    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void mid() {
        BinaryTree binaryTree = BuildTree();
        MidTraverser midTraverser = new MidTraverser();
        ArrayList<String> target = midTraverser.recursiveTraversal(binaryTree);
        ArrayList<String> list = new ArrayList<>();
        list.add("小绿");
        list.add("小黄");
        list.add("小明");
        list.add("小哈");
        list.add("小吴");
        list.add("小黑");
        list.add("小红");
        assert target.equals(list);

    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        BinaryTree binaryTree = BuildTree();
        PostTraverser postTraverser = new PostTraverser();
        ArrayList<String> target = postTraverser.recursiveTraversal(binaryTree);
        ArrayList<String> list = new ArrayList<>();
        list.add("小黄");
        list.add("小绿");
        list.add("小哈");
        list.add("小黑");
        list.add("小吴");
        list.add("小红");
        list.add("小明");
        assert target.equals(list);
    }

    /**
     * 非递归前序遍历打印二叉树
     */
    @Test
    public void preOrder() {
        BinaryTree binaryTree = BuildTree();
        PreTraverser preTraverser = new PreTraverser();
        ArrayList<String> target = preTraverser.notRecursiveTraversal(binaryTree);
        ArrayList<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小绿");
        list.add("小黄");
        list.add("小红");
        list.add("小吴");
        list.add("小哈");
        list.add("小黑");
        assert target.equals(list);
    }

    /**
     * 非递归中序遍历打印二叉树
     */
    @Test
    public void midOrder() {
        BinaryTree binaryTree = BuildTree();
        MidTraverser midTraverser = new MidTraverser();
        ArrayList<String> target = midTraverser.notRecursiveTraversal(binaryTree);
        ArrayList<String> list = new ArrayList<>();
        list.add("小绿");
        list.add("小黄");
        list.add("小明");
        list.add("小哈");
        list.add("小吴");
        list.add("小黑");
        list.add("小红");
        assert target.equals(list);
    }

    /**
     * 非递归后序遍历打印二叉树
     */
    @Test
    public void postOrder() {
        BinaryTree binaryTree = BuildTree();
        PostTraverser postTraverser = new PostTraverser();
        ArrayList<String> target = postTraverser.notRecursiveTraversal(binaryTree);
        ArrayList<String> list = new ArrayList<>();
        list.add("小黄");
        list.add("小绿");
        list.add("小哈");
        list.add("小黑");
        list.add("小吴");
        list.add("小红");
        list.add("小明");
        assert target.equals(list);
    }

    /**
     * 测试计算树的高度
     */
    @Test
    public void countHeight() {
        HeightVisitor heightVisitor = new HeightVisitor();
        int target = heightVisitor.visit(this.BuildTree());
        int expected = 4;
        Assertions.assertSame(target,expected);
    }

    /**
     * 测试计算树的节点个数
     */
     @Test
    public void countNodes() {
        CountVisitor countVisitor = new CountVisitor();
        int target = countVisitor.visit(this.BuildTree());
        int expected = 7;
        Assertions.assertSame(expected,target);
    }

    /**
     * 前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        PreTraverser preTraverser = new PreTraverser();
        int id = 1;
        BinaryTree.TreeNode treeNode = preTraverser.traversalSearch(this.BuildTree(), id);
        String target = treeNode.getData();
        String expected = "小明";
        assert target.equals(expected);
        //log.info("id为{}时，所查询的节点为:{}",id,BinaryTree.TreeNode.getData());
    }

    /**
     * 中序遍历查找节点
     */
    @Test
    public void midOrderTraversalSearch() {
        MidTraverser midTraverser = new MidTraverser();
        int id = 2;
        BinaryTree.TreeNode treeNode = midTraverser.traversalSearch(this.BuildTree(), id);
        String target = treeNode.getData();
        String expected = "小红";
        assert target.equals(expected);
        //log.info("id为{}时，所查询的节点为:{}",id,BinaryTree.TreeNode.getData());
    }

    /**
     * 后序遍历查找节点
     */
    @Test
    public void postOrderTraversalSearch() {
        PostTraverser postTraverser = new PostTraverser();
        int id = 3;
        BinaryTree.TreeNode treeNode = postTraverser.traversalSearch(this.BuildTree(), id);
        String target = treeNode.getData();
        String expected = "小吴";
        assert target.equals(expected);
        //log.info("id为{}时，所查询的节点为:{}",id,BinaryTree.TreeNode.getData());
    }
}

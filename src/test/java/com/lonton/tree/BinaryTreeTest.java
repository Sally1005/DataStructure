package com.lonton.tree;

import com.lonton.binaryTree.TreeApplication;
import com.lonton.binaryTree.dao.NodeDao;
import com.lonton.binaryTree.tree.impl.*;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * 二叉树单元测试
 *
 * @author 张利红
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TreeApplication.class)
public class BinaryTreeTest {
    /*** 建树
     *        水果
     *
     *  柑橘类     瓜果类
     *
     *橙子  沃柑   西瓜  哈密瓜
     *
     */
    @Autowired
    NodeDao stringNodeDao;

    public BinaryTree BuildTree() {
        BinaryTree binaryTree = new BinaryTree();
        List<BinaryTree.TreeNode> nodeList = stringNodeDao.getNodeList();
        nodeList.sort(new Comparator<BinaryTree.TreeNode>() {
            @Override
            public int compare(BinaryTree.TreeNode t, BinaryTree.TreeNode t1) {
                return t.getParentID() - t1.getParentID();
            }
        });
        for (BinaryTree.TreeNode treeNode : nodeList) {
            binaryTree.addNode(treeNode);
        }

        return binaryTree;
    }

    /**
     * 前序遍历打印二叉树
     */
    @Test
    public void pre() {
        BinaryTree binaryTree = BuildTree();
        PreTraverser preTraverser = new PreTraverser();
        ArrayList<String> strings = preTraverser.recursiveTraversal(binaryTree);
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + " ");
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("水果");
        list.add("柑橘类");
        list.add("橙子");
        list.add("沃柑");
        list.add("瓜果类");
        list.add("西瓜");
        list.add("哈密瓜");
       //  assert list.equals(result.toString());

    }

    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void mid() {
        BinaryTree binaryTree = BuildTree();
        MidTraverser midTraverser = new MidTraverser();
        ArrayList<String> strings = midTraverser.recursiveTraversal(binaryTree);
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + " ");
        }
        String target = "橙子 柑橘类 沃柑 水果 西瓜 瓜果类 哈密瓜 ";
        assert target.equals(result.toString());

    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        BinaryTree binaryTree = BuildTree();
        PostTraverser postTraverser = new PostTraverser();
        ArrayList<String> strings = postTraverser.recursiveTraversal(binaryTree);
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + " ");
        }
        String target = "橙子 沃柑 柑橘类 西瓜 哈密瓜 瓜果类 水果 ";
        assert target.equals(result.toString());
    }

    /**
     * 非递归前序遍历打印二叉树
     */
    @Test
    public void preOrder() {
        BinaryTree binaryTree = BuildTree();
        PreTraverser preTraverser = new PreTraverser();
        ArrayList<String> strings = preTraverser.notRecursiveTraversal(binaryTree);
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + " ");
        }
        String target = "水果 柑橘类 橙子 沃柑 瓜果类 西瓜 哈密瓜 ";
        assert target.equals(result.toString());
    }

    /**
     * 非递归中序遍历打印二叉树
     */
    @Test
    public void midOrder() {
        BinaryTree binaryTree = BuildTree();
        MidTraverser midTraverser = new MidTraverser();
        ArrayList<String> strings = midTraverser.notRecursiveTraversal(binaryTree);
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + " ");
        }
        String target = "橙子 柑橘类 沃柑 水果 西瓜 瓜果类 哈密瓜 ";
        assert target.equals(result.toString());
    }

    /**
     * 非递归后序遍历打印二叉树
     */
    @Test
    public void postOrder() {
        BinaryTree binaryTree = BuildTree();
        PostTraverser postTraverser = new PostTraverser();
        ArrayList<String> strings = postTraverser.notRecursiveTraversal(binaryTree);
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + " ");
        }
        String target = "橙子 沃柑 柑橘类 西瓜 哈密瓜 瓜果类 水果 ";
        assert target.equals(result.toString());
    }

    /**
     * 测试计算树的高度
     */
    @Test
    public void countHeight() {
        HeightVisitor heightVisitor = new HeightVisitor();
        int target = heightVisitor.visit(this.BuildTree());
        int expected = 3;
        assert target == expected;
    }

    /**
     * 测试计算树的节点个数
     */
    @Test
    public void countNodes() {
        CountVisitor countVisitor = new CountVisitor();
        int target = countVisitor.visit(this.BuildTree());
        int expected = 7;
        assert target == expected;
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
        String expected = "水果";
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
        String expected = "柑橘类";
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
        String expected = "瓜果类";
        assert target.equals(expected);
        //log.info("id为{}时，所查询的节点为:{}",id,BinaryTree.TreeNode.getData());
    }
}

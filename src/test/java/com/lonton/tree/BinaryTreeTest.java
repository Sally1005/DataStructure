package com.lonton.tree;

import com.lonton.binaryTree.dao.NodeDao;
import com.lonton.binaryTree.tree.impl.*;
import com.lonton.binaryTree.tree.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 *二叉树单元测试
 *
 * @author 张利红
 * date:2022-11-07
 */
@Slf4j
public class BinaryTreeTest {
  /*** 建树
     *        水果
     *
     *  柑橘类     瓜果类
     *
     *橙子  沃柑   西瓜  哈密瓜
     *
     */
    public BinaryTree BuildTree() {
        NodeDao stringNodeDao = new NodeDao();
        BinaryTree binaryTree = new BinaryTree();
        List<TreeNode> nodeList = stringNodeDao.getNodeList();
        nodeList.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode treeNode, TreeNode t1) {
                return treeNode.getParentID() - t1.getParentID();
            }
        });
        for (TreeNode stringTreeNode : nodeList) {
            binaryTree.AddNode(stringTreeNode);
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
        ArrayList<String> strings = preTraverser.RecursiveTraversal(binaryTree);
        StringBuilder result= new StringBuilder();
        for (String string : strings) {
            result.append(string+" ");
        }
        String target="水果 柑橘类 橙子 沃柑 瓜果类 西瓜 哈密瓜 ";
        assert target.equals(result.toString());
    }

    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void mid() {
        BinaryTree binaryTree = BuildTree();
        MidTraverser midTraverser = new MidTraverser();
        ArrayList<String> strings = midTraverser.RecursiveTraversal(binaryTree);
        StringBuilder result= new StringBuilder();
        for (String string : strings) {
            result.append(string+" ");
        }
        String target="橙子 柑橘类 沃柑 水果 西瓜 瓜果类 哈密瓜 ";
        assert target.equals(result.toString());

    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        BinaryTree binaryTree = BuildTree();
        PostTraverser postTraverser = new PostTraverser();
        ArrayList<String> strings = postTraverser.RecursiveTraversal(binaryTree);
        StringBuilder result= new StringBuilder();
        for (String string : strings) {
            result.append(string+" ");
        }
        String target="橙子 沃柑 柑橘类 西瓜 哈密瓜 瓜果类 水果 ";
        assert target.equals(result.toString());
    }
    /**
     * 非递归前序遍历打印二叉树
     */
     @Test
    public void preOrder() {
        BinaryTree binaryTree = BuildTree();
        PreTraverser preTraverser = new PreTraverser();
         ArrayList<String> strings = preTraverser.NotRecursiveTraversal(binaryTree);
         StringBuilder result= new StringBuilder();
         for (String string : strings) {
             result.append(string+" ");
         }
         String target="水果 柑橘类 橙子 沃柑 瓜果类 西瓜 哈密瓜 ";
         assert target.equals(result.toString());
    }

    /**
     * 非递归中序遍历打印二叉树
     */
    @Test
    public void midOrder() {
        BinaryTree binaryTree = BuildTree();
       MidTraverser midTraverser = new MidTraverser();
        ArrayList<String> strings = midTraverser.NotRecursiveTraversal(binaryTree);
        StringBuilder result= new StringBuilder();
        for (String string : strings) {
            result.append(string+" ");
        }
        String target="橙子 柑橘类 沃柑 水果 西瓜 瓜果类 哈密瓜 ";
        assert target.equals(result.toString());
    }

    /**
     * 非递归后序遍历打印二叉树
     */
    @Test
    public void postOrder() {
        BinaryTree binaryTree = BuildTree();
        PostTraverser postTraverser = new PostTraverser();
        ArrayList<String> strings = postTraverser.NotRecursiveTraversal(binaryTree);
        StringBuilder result= new StringBuilder();
        for (String string : strings) {
            result.append(string+" ");
        }
        String target="橙子 沃柑 柑橘类 西瓜 哈密瓜 瓜果类 水果 ";
        assert target.equals(result.toString());
    }

    /**
     * 测试计算树的高度
     */
    @Test
    public void countHeight() {
        HeightVisitor heightVisitor = new HeightVisitor();
        heightVisitor.visit(this.BuildTree());
        int target = 3;
       // assertIterableEquals(target,);
    }

    /**
     * 测试计算树的节点个数
     */
    @Test
    public void countNodes() {
        CountVisitor countVisitor = new CountVisitor();
        countVisitor.visit(this.BuildTree());
    }

    /**
     * 前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        PreTraverser preTraverser = new PreTraverser();
        int id = 1;
        TreeNode treeNode = preTraverser.TraversalSearch(this.BuildTree(), id);
        log.info("id为{}时，所查询的节点为:{}",id,treeNode.getData());
    }

    /**
     * 中序遍历查找节点
     */
     @Test
    public void midOrderTraversalSearch() {
         MidTraverser midTraverser = new MidTraverser();
         int id = 2;
         TreeNode treeNode = midTraverser.TraversalSearch(this.BuildTree(), id);
         log.info("id为{}时，所查询的节点为:{}",id,treeNode.getData());
     }

    /**
     * 后序遍历查找节点
     */
    @Test
    public void postOrderTraversalSearch() {
        PostTraverser postTraverser = new PostTraverser();
        int id = 3;
        TreeNode treeNode = postTraverser.TraversalSearch(this.BuildTree(), id);
        log.info("id为{}时，所查询的节点为:{}",id,treeNode.getData());
    }
}

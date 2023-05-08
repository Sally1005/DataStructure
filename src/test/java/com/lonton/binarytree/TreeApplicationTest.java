package com.lonton.binarytree;

import com.lonton.binarytree.impl.CountHeightVisitor;
import com.lonton.binarytree.impl.MidTraverser;
import com.lonton.binarytree.impl.NodeNumVisitor;
import com.lonton.binarytree.impl.PostTraverser;
import com.lonton.binarytree.impl.PreTraverser;
import com.lonton.binarytree.impl.PrintVisitor;
import com.lonton.binarytree.impl.SearchVisitor;
import com.lonton.binarytree.mapper.TreeNodeMapper;
import com.lonton.binarytree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


/**
 * 二叉树单元测试
 *
 * @author 张利红
 */
@Slf4j
@SpringBootTest(classes = TreeApplication.class)
@MapperScan({"com.lonton.binarytree.mapper.TreeNodeMapper"})
public class TreeApplicationTest {
    @Autowired
    TreeNodeMapper treeNodeMapper;

    /**
     * 建树
     *
     * @return 二叉树
     */
    public BinaryTree BuildTree() {
        List<BinaryTree.TreeNode> nodeList = treeNodeMapper.list();
        BinaryTree binaryTree = new BinaryTree(nodeList);
        return binaryTree;
    }

    /**
     * 前序遍历打印二叉树
     */
    @Test
    public void pre() {
        PrintVisitor<BinaryTree.TreeNode<String>> visitor = new PrintVisitor<>();
        new PreTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("水果");
        list.add("柑橘类");
        list.add("橙子");
        list.add("沃柑");
        list.add("瓜果类");
        list.add("西瓜");
        list.add("哈密瓜");
        log.info("前序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, visitor.getRes(), " 前序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }


    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void mid() {
        PrintVisitor<BinaryTree.TreeNode<String>> visitor = new PrintVisitor<>();
        new MidTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("柑橘类");
        list.add("沃柑");
        list.add("水果");
        list.add("西瓜");
        list.add("瓜果类");
        list.add("哈密瓜");
        log.info("中序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, visitor.getRes(), " 中序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        PrintVisitor<BinaryTree.TreeNode<String>> visitor = new PrintVisitor<>();
        new PostTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("沃柑");
        list.add("柑橘类");
        list.add("西瓜");
        list.add("哈密瓜");
        list.add("瓜果类");
        list.add("水果");
        log.info("后序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, visitor.getRes(), " 后序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 根据id，前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        int id = 1;
        SearchVisitor<BinaryTree.TreeNode<String>> visitor = new SearchVisitor<>();
        visitor.setId(id);
        new PreTraverser().traverse(BuildTree(), visitor, id);
        String target = visitor.getFoundNode().getData();
        log.info("前序遍历查找节点:{}", target);
        Assertions.assertEquals("水果", target, " 根据id，前序遍历查找节点实际得到的结果与预期结果不相等。");
    }

    /**
     * 根据id，中序遍历查找节点
     */
    @Test
    public void midOrderTraversalSearch() {
        int id = 3;
        SearchVisitor<BinaryTree.TreeNode<String>> visitor = new SearchVisitor<>();
        visitor.setId(id);
        new MidTraverser().traverse(BuildTree(), visitor, id);
        String target = visitor.getFoundNode().getData();
        log.info("中序遍历查找节点:{}", target);
        Assertions.assertEquals("瓜果类", target, " 根据id，中序遍历查找节点实际得到的结果与预期结果不相等。");
    }

    /**
     * 根据id，后序遍历查找节点
     */
    @Test
    public void postOrderTraversalSearch() {
        int id = 3;
        SearchVisitor<BinaryTree.TreeNode<String>> visitor = new SearchVisitor<>();
        visitor.setId(id);
        new PostTraverser().traverse(BuildTree(), visitor, id);
        String target = visitor.getFoundNode().getData();
        log.info("后序遍历查找节点:{}", target);
        Assertions.assertEquals("瓜果类", target, " 根据id，后序遍历查找节点实际得到的结果与预期结果不相等。");
    }

    /**
     * 计算树的高度
     */
    @Test
    public void countHeight() {
        CountHeightVisitor<BinaryTree.TreeNode<Integer>> visitor = new CountHeightVisitor<>();
        new PostTraverser().traverse(BuildTree(), visitor);
        Assertions.assertEquals(3, visitor.getHeight(), " 计算树的高度实际得到的结果与预期结果不相等。");
    }

    /**
     * 计算树的节点个数
     */
    @Test
    public void nodeNum() {
        NodeNumVisitor<BinaryTree.TreeNode<Integer>> visitor = new NodeNumVisitor<>();
        new PreTraverser().traverse(BuildTree(), visitor);
        Assertions.assertEquals(7, visitor.getCount(), " 计算树的节点个数实际得到的结果与预期结果不相等。");
    }

    /**
     * 前序打印二叉树
     */
    @Test
    public void prePrint() {
        PrintVisitor<BinaryTree.TreeNode<String>> visitor = new PrintVisitor<>();
        new PreTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("水果");
        list.add("柑橘类");
        list.add("橙子");
        list.add("沃柑");
        list.add("瓜果类");
        list.add("西瓜");
        list.add("哈密瓜");
        log.info("前序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, visitor.getRes(), " 前序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 中序打印二叉树
     */
    @Test
    public void midPrint() {
        PrintVisitor<BinaryTree.TreeNode<String>> visitor = new PrintVisitor<>();
        new MidTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("柑橘类");
        list.add("沃柑");
        list.add("水果");
        list.add("西瓜");
        list.add("瓜果类");
        list.add("哈密瓜");
        log.info("中序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, visitor.getRes(), " 中序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 后序打印二叉树
     */
    @Test
    public void postPrint() {
        PrintVisitor<BinaryTree.TreeNode<String>> visitor = new PrintVisitor<>();
        new PostTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("沃柑");
        list.add("柑橘类");
        list.add("西瓜");
        list.add("哈密瓜");
        list.add("瓜果类");
        list.add("水果");
        log.info("后序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, visitor.getRes(), " 后序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 后序过滤二叉树后求树的高度
     */
    @Test
    public void postFilterCountHeight() {
        CountHeightVisitor<BinaryTree.TreeNode<Integer>> visitor = new CountHeightVisitor<>();
        visitor.addFilter(node -> node.getId() > 2);
        visitor.addFilter(node -> node.getParentId() < 2);
        new PostTraverser().traverse(BuildTree(), visitor);
        Assertions.assertEquals(2, visitor.getHeight(), " 后序过滤二叉树后求树的高度实际得到的结果与预期结果不相等。");
    }

    /**
     * 后序过滤打印二叉树
     */
    @Test
    public void postFilterPrint() {
        PrintVisitor<BinaryTree.TreeNode<Integer>> visitor = new PrintVisitor<>();
        visitor.addFilter(node -> node.getId() > 2);
        visitor.addFilter(node -> node.getParentId() < 2);
        new PostTraverser().traverse(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("瓜果类");
        Assertions.assertEquals(list, visitor.getRes(), " 后序过滤打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 后序过滤二叉树后求树的节点个数
     */
    @Test
    public void postFilterNodeNum() {
        NodeNumVisitor<BinaryTree.TreeNode<Integer>> visitor = new NodeNumVisitor<>();
        visitor.addFilter(node -> node.getId() > 2);
        visitor.addFilter(node -> node.getParentId() < 2);
        new PostTraverser().traverse(BuildTree(), visitor);
        Assertions.assertEquals(1, visitor.getCount(), " 后序过滤二叉树后求树的节点个数实际得到的结果与预期结果不相等。");
    }
}

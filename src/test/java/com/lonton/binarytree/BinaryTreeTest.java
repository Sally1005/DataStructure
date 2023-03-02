package com.lonton.binarytree;

import com.lonton.binarytree.impl.MidTraverser;
import com.lonton.binarytree.impl.PostTraverser;
import com.lonton.binarytree.impl.PreTraverser;
import com.lonton.binarytree.mapper.TreeNodeMapper;
import com.lonton.binarytree.impl.CountHeightVisitor;
import com.lonton.binarytree.impl.NodeNumVisitor;
import com.lonton.binarytree.impl.PrintVisitor;
import com.lonton.binarytree.impl.SearchVisitor;
import com.lonton.binarytree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


/**
 * 二叉树单元测试
 * <p/>
 *
 * @author 张利红
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TreeApplication.class)
@MapperScan({"com.lonton.binarytree.mapper.TreeNodeMapper"})
public class BinaryTreeTest {
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
        SearchVisitor visitor = new SearchVisitor();
        List<Predicate<BinaryTree.TreeNode>> predicates = new ArrayList<>();
        predicates.add(Objects::nonNull);
        visitor.setFilters(predicates);
        new PreTraverser().traverse(BuildTree(), visitor);
        List<String> actual = new ArrayList<>();
        for (BinaryTree.TreeNode treeNode : visitor.getFilterNode()) {
            actual.add(treeNode.getData());
        }
        List<String> list = new ArrayList<>();
        list.add("水果");
        list.add("柑橘类");
        list.add("橙子");
        list.add("沃柑");
        list.add("瓜果类");
        list.add("西瓜");
        list.add("哈密瓜");
        log.info("前序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, actual, " 前序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }


    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void mid() {
        SearchVisitor visitor = new SearchVisitor();
        List<Predicate<BinaryTree.TreeNode>> predicates = new ArrayList<>();
        predicates.add(Objects::nonNull);
        visitor.setFilters(predicates);
        new MidTraverser().traverse(BuildTree(), visitor);
        List<String> actual = new ArrayList<>();
        for (BinaryTree.TreeNode treeNode : visitor.getFilterNode()) {
            actual.add(treeNode.getData());
        }
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("柑橘类");
        list.add("沃柑");
        list.add("水果");
        list.add("西瓜");
        list.add("瓜果类");
        list.add("哈密瓜");
        log.info("中序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, actual, " 中序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        SearchVisitor visitor = new SearchVisitor();
        List<Predicate<BinaryTree.TreeNode>> predicates = new ArrayList<>();
        predicates.add(Objects::nonNull);
        visitor.setFilters(predicates);
        new PostTraverser().traverse(BuildTree(), visitor);
        List<String> actual = new ArrayList<>();
        for (BinaryTree.TreeNode treeNode : visitor.getFilterNode()) {
            actual.add(treeNode.getData());
        }
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("沃柑");
        list.add("柑橘类");
        list.add("西瓜");
        list.add("哈密瓜");
        list.add("瓜果类");
        list.add("水果");
        log.info("后序遍历打印二叉树:{}", list);
        Assertions.assertEquals(list, list, " 后序遍历打印二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * 根据id，前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        int id = 1;
        SearchVisitor visitor = new SearchVisitor();
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
        SearchVisitor visitor = new SearchVisitor();
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
        SearchVisitor visitor = new SearchVisitor();
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
        CountHeightVisitor visitor = new CountHeightVisitor();
        new PostTraverser().traverse(BuildTree(), visitor);
        Assertions.assertEquals(3, visitor.getHeight(), " 计算树的高度实际得到的结果与预期结果不相等。");
    }

    /**
     * 计算树的节点个数
     */
    @Test
    public void nodeNum() {
        NodeNumVisitor visitor = new NodeNumVisitor();
        new PreTraverser().traverse(BuildTree(), visitor);
        Assertions.assertEquals(7, visitor.getCount(), " 计算树的节点个数实际得到的结果与预期结果不相等。");
    }

    /**
     * 前序打印二叉树
     */
    @Test
    public void prePrint() {
        PrintVisitor visitor = new PrintVisitor();
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
     * 中序测试过滤
     */
    @Test
    public void midFilter() {
        SearchVisitor visitor = new SearchVisitor();
        List<Predicate<BinaryTree.TreeNode>> predicates = new ArrayList<>();
        // 取与关系
        predicates.add(treeNode -> treeNode.getLevel() > 2 && treeNode.getId() < 5);
        visitor.setFilters(predicates);
        new MidTraverser().traverse(BuildTree(), visitor);
        List<String> actual = new ArrayList<>();
        for (BinaryTree.TreeNode treeNode : visitor.getFilterNode()) {
            actual.add(treeNode.getData());
        }
        List<String> list = new ArrayList<>();
        list.add("橙子");
        log.info("中序过滤二叉树:{}", list);
        Assertions.assertEquals(list, actual, " 中序过滤二叉树实际得到的结果与预期结果不相等。");
    }

    /**
     * Stream流过滤练习示例
     */
    @Test
    public void testFilterByStream() {
        List<BinaryTree.TreeNode> list = treeNodeMapper.list();
        list.stream() // 1) 创建流-> 1. 单列集合：collection、set 2. 双列集合：先map.entrySet/keySet转成单列集合
                // 3.数组：Arrays.stream(数组名)或者Stream.of(数组)
                .distinct() // 去重
                .sorted((o1, o2) -> o2.getId() - o1.getId()) // 按照id进行降序排序
                .filter(treeNode -> treeNode.getIsLeft() == 0) // 过滤
                .limit(3) // 限制流的长度，多的部分将会被抛弃
                .skip(1) // 跳过前1个元素（最大、最小）
                .forEach(treeNode -> log.info("为左节点的节点：{}", treeNode.getData()));
    }
}

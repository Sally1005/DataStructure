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

import java.util.*;



/**
 * 二叉树单元测试
 * <p/>
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
     * @return
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
        PreTraverser preTraverser = new PreTraverser();
        List<String> list = new ArrayList<>();
        PrintVisitor visitor = new PrintVisitor();
        preTraverser.doVisitor(BuildTree(), visitor);
        List<String> res = visitor.getRes();
        list.add("水果");
        list.add("柑橘类");
        list.add("橙子");
        list.add("沃柑");
        list.add("瓜果类");
        list.add("西瓜");
        list.add("哈密瓜");
        log.info("前序遍历打印二叉树:{}",list);
        Assertions.assertEquals(res,list,"前序遍历打印二叉树于失败。");
    }

    /**
     * 中序遍历打印二叉树
     */
   // @Test
    public void mid() {
        MidTraverser midTraverser = new MidTraverser();
        PrintVisitor visitor = new PrintVisitor();
        midTraverser.doVisitor(BuildTree(), visitor);
        List<String> res = visitor.getRes();
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("柑橘类");
        list.add("沃柑");
        list.add("水果");
        list.add("西瓜");
        list.add("瓜果类");
        list.add("哈密瓜");
        log.info("中序遍历打印二叉树:{}",list);
        Assertions.assertEquals(res,list,"中序遍历打印二叉树于失败。");

    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        PostTraverser postTraverser = new PostTraverser();
        PrintVisitor visitor = new PrintVisitor();
        List<String> res = visitor.getRes();
        postTraverser.doVisitor(BuildTree(), visitor);
        List<String> list = new ArrayList<>();
        list.add("橙子");
        list.add("沃柑");
        list.add("柑橘类");
        list.add("西瓜");
        list.add("哈密瓜");
        list.add("瓜果类");
        list.add("水果");
        log.info("后序遍历打印二叉树:{}",list);
        Assertions.assertEquals(res,list,"后序遍历打印二叉树于失败。");
    }

    /**
     * 根据id，前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        int id = 1;
        SearchVisitor visitor = new SearchVisitor();
        visitor.setId(id);
        new PreTraverser().doVisitor(BuildTree(), visitor,id);
        String target = visitor.getFoundNode().getData();
        log.info("前序遍历查找节点:{}",target);
        Assertions.assertEquals("水果", target,"根据id，前序遍历查找节点失败。");
    }

    /**
     * 根据id，中序遍历查找节点
     */
    @Test
    public void midOrderTraversalSearch() {
        int id = 3;
        SearchVisitor visitor = new SearchVisitor();
        visitor.setId(id);
        new MidTraverser().doVisitor(BuildTree(), visitor,id);
        String target = visitor.getFoundNode().getData();
        log.info("中序遍历查找节点:{}",target);
        // id=7的节点在中序遍历查找目标节点后即停止查找
        Assertions.assertEquals("瓜果类", target,"根据id，中序遍历查找节点失败。");
    }

    /**
     * 根据id，后序遍历查找节点
     */
    @Test
    public void postOrderTraversalSearch() {
        int id = 3;
        SearchVisitor visitor = new SearchVisitor();
        visitor.setId(id);
        new PostTraverser().doVisitor(BuildTree(), visitor, id);
        String target = visitor.getFoundNode().getData();
        log.info("后序遍历查找节点:{}",target);
        Assertions.assertEquals("瓜果类", target,"根据id，后序遍历查找节点失败。");
    }

    /**
     * 计算树的高度
     */
   // @Test
    public void countHeight(){
        CountHeightVisitor visitor = new CountHeightVisitor();
        new PostTraverser().doVisitor(BuildTree(),visitor);
        Assertions.assertEquals(3,visitor.getHeight(),"计算树的高度失败。");
    }

    /**
     * 计算树的节点个数
     */
    @Test
    public  void  nodeNum(){
        NodeNumVisitor visitor = new NodeNumVisitor();
        new PreTraverser().doVisitor(BuildTree(),visitor);
        Assertions.assertEquals(7,visitor.getCount(),"计算树的节点个数失败。");
    }

    /**
     * 前序打印二叉树
     */
    @Test
    public  void prePrint(){
        PrintVisitor visitor = new PrintVisitor();
        new PreTraverser().doVisitor(BuildTree(),visitor);
        List<String> list = new ArrayList<>();
        list.add("水果");
        list.add("柑橘类");
        list.add("橙子");
        list.add("沃柑");
        list.add("瓜果类");
        list.add("西瓜");
        list.add("哈密瓜");
        log.info("前序遍历打印二叉树:{}",list);
        Assertions.assertEquals(list,visitor.getRes(),"前序遍历打印二叉树于失败。");
    }

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

    /**
     * 中序测试过滤
     */
    @Test
    public void midFilter(){
        SearchVisitor visitor = new SearchVisitor();
        visitor.setPredicate(treeNode -> treeNode.getId()>3);
        new MidTraverser().doVisitor(BuildTree(), visitor);
        List<String> actual = new ArrayList<>();
        for (BinaryTree.TreeNode treeNode : visitor.getFilterNode()) {
            actual.add(treeNode.getData());
        }
        List<String> list= new ArrayList<>();
        list.add("橙子");
        list.add("沃柑");
        list.add("西瓜");
        list.add("哈密瓜");
        log.info("中序过滤二叉树:{}",list);
        Assertions.assertEquals(list,actual,"中序过滤二叉树失败。");





















    }
}

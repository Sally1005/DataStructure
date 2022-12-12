package com.lonton.binarytree;
import com.lonton.binarytree.mapper.TreeNodeMapper;
import com.lonton.binarytree.tree.impl.*;
import com.lonton.binarytree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


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
        List<String> target = preTraverser.traverser(BuildTree(), new Visitor());
        list.add("小明");
        list.add("小绿");
        list.add("小黄");
        list.add("小红");
        list.add("小吴");
        list.add("小哈");
        list.add("小黑");
        log.info("前序遍历打印二叉树:{}",list);
        // assert target.equals(list);
    }

    /**
     * 中序遍历打印二叉树
     */
    @Test
    public void mid() {
        MidTraverser midTraverser = new MidTraverser();
        List<String> target = midTraverser.traverser(BuildTree(), new Visitor());
        List<String> list = new ArrayList<>();
        list.add("小绿");
        list.add("小黄");
        list.add("小明");
        list.add("小哈");
        list.add("小吴");
        list.add("小黑");
        list.add("小红");
        log.info("中序遍历打印二叉树:{}",list);
        assert target.equals(list);

    }

    /**
     * 后序遍历打印二叉树
     */
    @Test
    public void post() {
        PostTraverser postTraverser = new PostTraverser();
        List<String> target = postTraverser.traverser(BuildTree(), new Visitor());
        List<String> list = new ArrayList<>();
        list.add("小黄");
        list.add("小绿");
        list.add("小哈");
        list.add("小黑");
        list.add("小吴");
        list.add("小红");
        list.add("小明");
        log.info("后序遍历打印二叉树:{}",list);
        assert target.equals(list);
    }

    /**
     * 前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        int id = 1;
        BinaryTree.TreeNode target = new PreTraverser().search(id, BuildTree().getRoot(), new Visitor());
        String expected = "小明";
        log.info("前序遍历查找节点:{}",target);
       // assert target.equals(expected);
    }

    /**
     * 中序遍历查找节点
     */
    @Test
    public void midOrderTraversalSearch() {
        int id = 2;
        BinaryTree.TreeNode treeNode = new MidTraverser().search(id, BuildTree().getRoot(), new Visitor());
        String target = treeNode.getData();
        String expected = "柑橘类";
        log.info("中序遍历查找节点:{}",target);
        assert target.equals(expected);
    }

    /**
     * 后序遍历查找节点
     */
    @Test
    public void postOrderTraversalSearch() {
        int id = 3;
        BinaryTree.TreeNode treeNode = new PostTraverser().search(id, BuildTree().getRoot(), new Visitor());
        String target = treeNode.getData();
        String expected = "小吴";
        log.info("后序遍历查找节点:{}",target);
        assert target.equals(expected);

    }
}

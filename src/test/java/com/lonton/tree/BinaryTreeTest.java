package com.lonton.tree;

import com.lonton.binarytree.TreeApplication;
import com.lonton.binarytree.dao.NodeDao;
import com.lonton.binarytree.tree.ITraverser;
import com.lonton.binarytree.tree.impl.*;
import com.lonton.binarytree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class BinaryTreeTest {
    @Autowired
    NodeDao stringNodeDao;

    /**
     * 建树
     * @return
     */
    public BinaryTree BuildTree() {
        List<BinaryTree.TreeNode> nodeList = stringNodeDao.getNodeList();
        BinaryTree binaryTree = new BinaryTree(nodeList);
        return binaryTree;
    }

    /**
     * 遍历
     * @param traverser
     * @return
     */
    public List<Object> traversal(ITraverser traverser){
        return traverser.traverser(BuildTree().getRoot());
    }

    /**
     * 前序遍历打印二叉树
     */
    @Test
    public void pre() {
            List<Object> target = traversal(new PreTraverser());
            List<String> list = new ArrayList<>();
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
        List<Object> target = traversal(new MidTraverser());
        List<String> list = new ArrayList<>();
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
        List<Object> target = traversal(new PostTraverser());
        List<String> list = new ArrayList<>();
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
        List<Object> target = traversal(new PreTraverser(false));
        List<String> list = new ArrayList<>();
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
        List<Object> target = traversal(new MidTraverser(false));
        List<String> list = new ArrayList<>();
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
        List<Object> target = traversal(new PostTraverser(false));
        List<String> list = new ArrayList<>();
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
     * 查询
     * @param traverser
     * @param id
     * @return
     */
    public BinaryTree.TreeNode search(ITraverser traverser, int id){
        return traverser.search(BuildTree().getRoot(), id);
    }

    /**
     * 前序遍历查找节点
     */
    @Test
    public void preOrderTraversalSearch() {
        int id = 1;
        BinaryTree.TreeNode treeNode = search(new PreTraverser(), id);
        String target = treeNode.getData();
        String expected = "小明";
        assert target.equals(expected);
    }

    /**
     * 中序遍历查找节点
     */
    @Test
    public void midOrderTraversalSearch() {
        int id = 2;
        BinaryTree.TreeNode treeNode = search(new MidTraverser(), id);
        String target = treeNode.getData();
        String expected = "小红";
        assert target.equals(expected);
    }

    /**
     * 后序遍历查找节点
     */
    @Test
    public void postOrderTraversalSearch() {
        int id = 3;
        BinaryTree.TreeNode treeNode = search(new PostTraverser(), id);
        String target = treeNode.getData();
        String expected = "小吴";
        assert target.equals(expected);
    }
}

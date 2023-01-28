package com.lonton.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


/**
 * 测试二叉树的所有路径 <p/>
 * 输入：root = [1,2,3,null,5] <p/>
 * 输出：["1->2->5","1->3"] <p/>
 * @author 张利红
 */
@Slf4j
public class Q257AllPathsToBinaryTreesTest {
    @Test
    public void test(){
        // 构建二叉树
        Q257AllPathsToBinaryTrees.TreeNode root = new Q257AllPathsToBinaryTrees.TreeNode(1);
        Q257AllPathsToBinaryTrees.TreeNode treeNode2 = new Q257AllPathsToBinaryTrees.TreeNode(2);
        Q257AllPathsToBinaryTrees.TreeNode treeNode3 = new Q257AllPathsToBinaryTrees.TreeNode(3);
        Q257AllPathsToBinaryTrees.TreeNode treeNode4 = new Q257AllPathsToBinaryTrees.TreeNode(5);
        root.left = treeNode2;
        root.right =treeNode3;
        treeNode2.right = treeNode4;
        // 断言
        List<String> res = Q257AllPathsToBinaryTrees.binaryTreePaths(root);
        log.info("res={}",res);
        Assert.assertEquals("NotEquals",2,res.size());
    }


}

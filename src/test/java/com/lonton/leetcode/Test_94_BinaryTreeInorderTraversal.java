package com.lonton.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Test_94_BinaryTreeInorderTraversal {
    @Test
    public void test() {
        /**       1      <br/>
         *    null   2   <br/>
         *              3<br/>
         */
        // 构建二叉树
        _94_BinaryTreeInorderTraversal.TreeNode treeNode = new _94_BinaryTreeInorderTraversal.TreeNode(1,
                null,
                new _94_BinaryTreeInorderTraversal.TreeNode(2,
                        new _94_BinaryTreeInorderTraversal.TreeNode(3),
                        null));
        List<Integer> list =_94_BinaryTreeInorderTraversal.inorderTraversal(treeNode);
        List<Integer> target = Arrays.asList(1,3,2);
        assert target.equals(list);
    }


}

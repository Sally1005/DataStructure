package com.lonton.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Test_144_BinaryTreePreorderTraversal {
    @Test
    public void test() {
        /**       1      <br/>
         *    null   2   <br/>
         *              3<br/>
         */
        // 构建二叉树
        _144_BinaryTreePreorderTraversal.TreeNode treeNode = new _144_BinaryTreePreorderTraversal.TreeNode(1,
                null,
                new _144_BinaryTreePreorderTraversal.TreeNode(2,
                        new _144_BinaryTreePreorderTraversal.TreeNode(3),
                        null));
        List<Integer> list = _144_BinaryTreePreorderTraversal.preorderTraversal(treeNode);
        List<Integer> target = Arrays.asList(1,2,3);
        assert target.equals(list);
    }

}

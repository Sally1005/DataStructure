package com.lonton.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Test_145_BinaryTreePostorderTraversal {
    @Test
    public void test() {
        /**       1      <br/>
         *    null   2   <br/>
         *              3<br/>
         */
        // 构建二叉树
        _145_BinaryTreePostorderTraversal.TreeNode treeNode = new _145_BinaryTreePostorderTraversal.TreeNode(1,
                null,
                new _145_BinaryTreePostorderTraversal.TreeNode(2,
                        new _145_BinaryTreePostorderTraversal.TreeNode(3),
                        null));
        List<Integer> list = _145_BinaryTreePostorderTraversal.postorderTraversal(treeNode);
        List<Integer> target = Arrays.asList(3,2,1);
        assert target.equals(list);
    }

}

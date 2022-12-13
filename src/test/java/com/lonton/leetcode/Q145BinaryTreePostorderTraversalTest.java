package com.lonton.leetcode;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Slf4j
public class Q145BinaryTreePostorderTraversalTest {
    @Test
    public void test() {
        /**       1      <br/>
         *    null   2   <br/>
         *              3<br/>
         */
        // 构建二叉树
        Q145BinaryTreePostorderTraversal.TreeNode treeNode = new Q145BinaryTreePostorderTraversal.TreeNode(1,
                null,
                new Q145BinaryTreePostorderTraversal.TreeNode(2,
                        new Q145BinaryTreePostorderTraversal.TreeNode(3),
                        null));
        List<Integer> expected = Q145BinaryTreePostorderTraversal.postorderTraversal(treeNode);
        List<Integer> actual = Arrays.asList(3,2,1);
        assertCollectionsAreEquals(expected,actual,"NotEquals");
    }
    public static <T> void assertCollectionsAreEquals (Collection<T> expected, Collection<T> actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }

}

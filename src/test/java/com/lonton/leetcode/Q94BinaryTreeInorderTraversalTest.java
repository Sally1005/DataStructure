package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Slf4j
public class Q94BinaryTreeInorderTraversalTest {
    @Test
    public void test() {
        /**       1      <br/>
         *    null   2   <br/>
         *              3<br/>
         */
        // 构建二叉树
        Q94BinaryTreeInorderTraversal.TreeNode treeNode = new Q94BinaryTreeInorderTraversal.TreeNode(1,
                null,
                new Q94BinaryTreeInorderTraversal.TreeNode(2,
                        new Q94BinaryTreeInorderTraversal.TreeNode(3),
                        null));
        List<Integer> expected = Q94BinaryTreeInorderTraversal.inorderTraversal(treeNode);
        List<Integer> actual = Arrays.asList(1,3,2);
        log.info("expected:{}",expected);
         // 断言检查两个集合是否相同
        assertCollectionsAreEquals(expected,actual,"NotEquals");
    }
    public static <T> void assertCollectionsAreEquals (Collection<T> expected, Collection<T> actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }


}

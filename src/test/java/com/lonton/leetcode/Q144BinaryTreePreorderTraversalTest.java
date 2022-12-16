package com.lonton.leetcode;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;

/**
 * 测试二叉树前序遍历 <p/>
 *      1     <p/>
 *     / \    <p/>
 * null   2   <p/>
 *         \  <p/>
 *          3 <p/>
 * @author 张利红
 */
@Slf4j
public class Q144BinaryTreePreorderTraversalTest {
    @Test
    public void test() {
        // 构建二叉树
        Q144BinaryTreePreorderTraversal.TreeNode treeNode = new Q144BinaryTreePreorderTraversal.TreeNode(1,
                null,
                new Q144BinaryTreePreorderTraversal.TreeNode(2,
                        new Q144BinaryTreePreorderTraversal.TreeNode(3),
                        null));

        assertCollectionsAreEquals( Arrays.asList(1,2,3),
                Q144BinaryTreePreorderTraversal.preorderTraversal(treeNode),
               "NotEquals");
    }
    /**
     * 断言检查两个集合是否相同
     * @param expected 预期值
     * @param actual 实际值
     * @param message 报错信息
     * @param <T> 集合泛型
     */
    public static <T> void assertCollectionsAreEquals (Collection<T> expected, Collection<T> actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }
}

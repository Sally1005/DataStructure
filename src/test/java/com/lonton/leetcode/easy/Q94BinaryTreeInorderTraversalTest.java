package com.lonton.leetcode.easy;

import com.lonton.leetcode.easy.Q94BinaryTreeInorderTraversal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;

/**
 * 测试二叉树中序遍历 <p/>
 *      1     <p/>
 *     / \    <p/>
 * null   2   <p/>
 *         \  <p/>
 *          3 <p/>
 * @author 张利红
 */

@Slf4j
public class Q94BinaryTreeInorderTraversalTest {
    @Test
    public void test() {
        // 构建二叉树
        Q94BinaryTreeInorderTraversal.TreeNode treeNode = new Q94BinaryTreeInorderTraversal.TreeNode(1,
                null,
                new Q94BinaryTreeInorderTraversal.TreeNode(2,
                        new Q94BinaryTreeInorderTraversal.TreeNode(3),
                        null));

        assertCollectionsAreEquals(Arrays.asList(1,3,2),
                Q94BinaryTreeInorderTraversal.inorderTraversal(treeNode),
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

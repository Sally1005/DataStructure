package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * 测试二叉树中序遍历 <p/>
 * 将数组 nums = [1,null,2,3] 构建成二叉树，并判断输出的值是否为预期的[1,3,2]。
 *
 * @author 张利红
 */

public class Q94BinaryTreeInOrderTraversalTest {
    @Test
    public void test() {
        Integer[] nums = new Integer[]{1, null, 2, 3};
        TreeNode root = BinaryTree.arrayToTree(nums);

        assertCollectionsAreEquals(Arrays.asList(1, 3, 2),
                Q94BinaryTreeInOrderTraversal.inorderTraversal(root),
                "NotEquals---二叉树中序遍历实际得到的结果与预期结果不相等。");
    }

    /**
     * 断言检查两个集合是否相同
     *
     * @param expected 预期值
     * @param actual   实际值
     * @param message  报错信息
     * @param <T>      集合泛型
     */
    public static <T> void assertCollectionsAreEquals(Collection<T> expected, Collection<T> actual, String message) {
        Assertions.assertEquals(expected, actual, message);
    }
}

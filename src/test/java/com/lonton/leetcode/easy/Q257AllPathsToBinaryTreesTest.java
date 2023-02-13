package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试二叉树的所有路径 <p/>
 * 将数组 [1,2,3,null,5] 构建成二叉树,
 * 并判断该树中从 根节点到叶子节点 的路径 是否为预期条数 (2), 并检查结果集每一条路径是否计算正确。 <p/>
 *
 * @author 张利红
 */
public class Q257AllPathsToBinaryTreesTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, 2, 3, null, 5};
        TreeNode root = BinaryTree.arrayToTree(nums);

        // 断言
        Assertions.assertEquals(2,
                Q257AllPathsToBinaryTrees.binaryTreePaths(root).size(),
                "NotEquals---从根节点到叶子节点的路径条数与预期结果不相等。");
        Assertions.assertTrue(
                Q257AllPathsToBinaryTrees.binaryTreePaths(root).contains("1->3"),
                "NotTrue---结果集路径计算错误，实际得到的路径不符合预期。");
        Assertions.assertTrue(
                Q257AllPathsToBinaryTrees.binaryTreePaths(root).contains("1->2->5"),
                "NotTrue---结果集路径计算错误，实际得到的路径不符合预期。");
    }
}

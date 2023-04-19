package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 257. 测试二叉树的所有路径
 * <ul>
 * <li> 将数组 [1,2,3,null,5] 构建成二叉树,判断该树中从 根节点到叶子节点 的路径 是否为预期条数 (2), 并检查结果集每一条路径是否计算正确。
 * </ul>
 *
 * @author 张利红
 */
public class Q257AllPathsToBinaryTreesTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, 2, 3, null, 5};
        TreeNode<Integer>  root = new TreeNode<Integer> ().arrayToTree(nums);

        // 断言
        Assertions.assertEquals(2,
               new Q257AllPathsToBinaryTrees().binaryTreePaths(root).size(),
                " 从根节点到叶子节点的路径条数计算错误。");
        Assertions.assertTrue(
                new Q257AllPathsToBinaryTrees().binaryTreePaths(root).contains("1->3"),
                " 结果集路径计算错误。");
        Assertions.assertTrue(
                new Q257AllPathsToBinaryTrees().binaryTreePaths(root).contains("1->2->5"),
                " 结果集路径计算错误。");
    }
}

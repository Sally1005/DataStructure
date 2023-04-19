package com.lonton.leetcode.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试树中定义的方法<p>
 * 数组转为树
 * <ol>
 *  <li> 测试一个非空数组，含多个元素；
 *  <li> 测试一个非空数组。
 * </ol>
 * 树转数组
 * <ol>
 *  <li> 测试一个非空数组，含多个元素；
 *  <li> 测试一个非空数组。
 * </ol>
 *
 * @author 张利红
 */
public class TreeNodeTest {
    @Test
    public void testArrayToTree() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode<Integer> root = new TreeNode<Integer>().arrayToTree(arr);
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7},
                new TreeNode<Integer>().treeToArray(root, Integer.class), "当数组为一个非空数组时，数组转成树失败。");
    }

    @Test
    public void testEmpty1() {
        Integer[] arr = new Integer[0];
        TreeNode<Integer> root = new TreeNode<Integer>().arrayToTree(arr);
        Assertions.assertNull(root);
    }

    @Test
    public void testTreeToArray() {
        Integer[] arr = {1, 3, 5, 7, 9};
        TreeNode<Integer> array = new TreeNode<Integer>().arrayToTree(arr);
        Assertions.assertArrayEquals(new Integer[]{1, 3, 5, 7, 9},
                new TreeNode<Integer>().treeToArray(array, Integer.class), "当数组为一个非空数组时，树转成数组失败。");
    }

    @Test
    public void testEmpty() {
        Integer[] result = new TreeNode<Integer>().treeToArray(null, Integer.class);
        Assertions.assertArrayEquals(new Integer[0], result, "当为空树时，数组转成树失败。");
    }

    @Test
    public void testNull() {
        Integer[] result = new TreeNode<Integer>().treeToArray(null, Integer.class);
        Assertions.assertArrayEquals(new Integer[0], result, "当根节点为null时，数组转成树失败。");
    }

}

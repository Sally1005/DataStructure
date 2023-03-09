package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 测试从前序与中序遍历序列构造二叉树 <p/>
 * 示例1：将数组 preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] 构建成二叉树，并判断输出的值是否为预期的[3,9,20,null,null,15,7]。
 * 示例2：将数组 preorder2 = [], inorder2 = [] 构建成二叉树，并判断输出的值是否为预期的[]。
 *
 * @author 张利红
 */
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    @Test
    public void test1() {

        TreeNode tree = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        List<Integer> array = TreeNode.treeToArray(tree);

        Assertions.assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, array.toArray(),
                "比对失败，前序数组和中序数组构成的二叉搜索树与与实际预期不相等。");

    }

    @Test
    public void test2() {
        TreeNode tree2 = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[0], new int[0]);
        List<Integer> array = TreeNode.treeToArray(tree2);
        Assertions.assertArrayEquals(new Integer[0], array.toArray(),
                "比对失败，前序数组和中序数组构成的二叉搜索树与与实际预期不相等。");
    }
}



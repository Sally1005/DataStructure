package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * 105. 测试从前序与中序遍历序列构造二叉树 <p/>
 * <ol>
 * <li> 将数组 preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] 构建成二叉树，并判断输出的值是否为预期的[3,9,20,null,null,15,7]。
 * <li> 将数组 preorder2 = [], inorder2 = [] 构建成二叉树，并判断输出的值是否为预期的[null]。
 * </ol>
 *
 * @author 张利红
 */
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    @Test
    public void test() {

        TreeNode<Integer> tree = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        Integer[] array = new TreeNode<Integer>().treeToArray(tree, Integer.class);
        Assertions.assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, array,
                "比对失败，前序数组和中序数组构成的二叉搜索树与与实际预期不相等。");

    }

    @Test
    public void testEmpty() {
        TreeNode<Integer> tree2 = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(
                new int[0], new int[0]);
        Integer[] array = new TreeNode<Integer>().treeToArray(tree2,Integer.class);

        Assertions.assertArrayEquals(new Integer[0], array,
                "比对失败，前序数组和中序数组构成的二叉搜索树与与实际预期不相等。");
    }
}



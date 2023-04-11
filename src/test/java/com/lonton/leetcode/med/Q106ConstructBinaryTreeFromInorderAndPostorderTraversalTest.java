package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * 106. 测试从中序与后序遍历序列构造二叉树
 * <ol>
 * <li> 将数组 inorder = [9,3,15,20,7], postorder = [9,15,7,20,3] 构建成二叉树，并判断输出的值是否为预期的[3,9,20,null,null,15,7]。
 * <li> 将数组 inorder2 = [], postorder2 = [] 构建成二叉树，并判断输出的值是否为预期的[null]。
 * </ol>
 *
 * @author 张利红
 */
public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversalTest {
    @Test
    public void test() {

        TreeNode tree = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Object[] objects = new TreeNode().treeToArray(tree);
        Integer[] array = new Integer[objects.length];
        for(int i = 0;i<objects.length;i++) {
            array[i] = (Integer)objects[i];
        }

        Assertions.assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, array,
                "比对失败，中序数组和后序数组构成的二叉搜索树与与实际预期不相等。");
    }

    @Test
    public void testEmpty() {

        TreeNode tree2 = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[0], new int[0]);
        Integer[] array = (Integer[]) new TreeNode().treeToArray(tree2);
        Assertions.assertArrayEquals(null, array,
                "比对失败，中序数组和后序数组构成的二叉搜索树与与实际预期不相等。");
    }
}



package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试从中序与后序遍历序列构造二叉树 <p/>
 * 将数组 inorder = [9,3,15,20,7], postorder = [9,15,7,20,3] 构建成二叉树，并判断输出的值是否为预期的[3,9,20,null,null,15,7]。
 * 将数组 inorder2 = [-1], postorder2 = [-1] 构建成二叉树，并判断输出的值是否为预期的[-1]。
 *
 * @author 张利红
 */
public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversalTest {
    @Test
    public void test() {
        // 示例1
        TreeNode tree = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Integer[] array = TreeNode.treeToArray(tree);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx = array.length - 1;
        while (array[idx] == null) {
            idx--;
        }
        Integer[] nullFilteredArr = Arrays.copyOf(array, idx + 1);

        Assertions.assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, nullFilteredArr,
                "比对失败，中序数组和后序数组构成的二叉搜索树与与实际预期不相等。");

        // 示例2
        TreeNode tree2 = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[0], new int[0]);
        Integer[] array2 = TreeNode.treeToArray(tree2);
        Assertions.assertArrayEquals(new Integer[0], array2,
                "比对失败，中序数组和后序数组构成的二叉搜索树与与实际预期不相等。");
    }
}



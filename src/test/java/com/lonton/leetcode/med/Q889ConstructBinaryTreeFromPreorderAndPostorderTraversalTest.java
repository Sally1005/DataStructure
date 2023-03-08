package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试根据前序和后序遍历构造二叉树 <p/>
 * 示例1：将数组 preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1] 构建成二叉树，并判断输出的值是否为预期的[1,2,3,4,5,6,7]。
 * 示例2：将数组 preorder2 = [], postorder2 = [] 构建成二叉树，并判断输出的值是否为预期的[]。
 *
 * @author 张利红
 */
public class Q889ConstructBinaryTreeFromPreorderAndPostorderTraversalTest {

    @Test
    public void test1() {

        TreeNode tree = new Q889ConstructBinaryTreeFromPreorderAndPostorderTraversal().buildTree(
                new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        Integer[] array = TreeNode.treeToArray(tree);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx = array.length - 1;
        while (array[idx] == null) {
            idx--;
        }
        Integer[] nullFilteredArr = Arrays.copyOf(array, idx + 1);

        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, nullFilteredArr,
                "比对失败，前序数组和后序数组构成的二叉搜索树与与实际预期不相等。");
    }

    @Test
    public void test2() {

        TreeNode tree2 = new Q889ConstructBinaryTreeFromPreorderAndPostorderTraversal().buildTree(
                new int[0], new int[0]);
        Integer[] array2 = TreeNode.treeToArray(tree2);
        Assertions.assertArrayEquals(new Integer[0], array2,
                "比对失败，前序数组和后序数组构成的二叉搜索树与与实际预期不相等。");
    }
}



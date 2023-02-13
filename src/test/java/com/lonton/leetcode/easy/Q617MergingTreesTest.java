package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * 617. 测试合并二叉树
 * 将数组 nums1 = [1]，nums2 = [1,2] 构建成二叉树，并判断输出的值是否为预期的[2，2]。
 *
 * @author 张利红
 */
public class Q617MergingTreesTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums1 = new Integer[]{1};
        TreeNode root1 = BinaryTree.arrayToTree(nums1);
        Integer[] nums2 = new Integer[]{1, 2};
        TreeNode root2 = BinaryTree.arrayToTree(nums2);

        TreeNode node = Q617MergingTrees.mergeTrees(root1, root2);
        Integer[] array = BinaryTree.treeToArray(node);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx = array.length - 1;
        while (array[idx] == null) {
            idx--;
        }
        Integer[] nullFilteredArr = Arrays.copyOf(array, idx + 1);

        Assertions.assertEquals(Arrays.asList(2, 2), Arrays.asList(nullFilteredArr),
                "NotEquals---合并二叉树失败，实际得到的结果与预期结果不相等。");
    }

}

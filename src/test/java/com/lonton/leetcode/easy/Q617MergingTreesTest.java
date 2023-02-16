package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * 617. 测试合并二叉树
 * 示例1：将数组 nums1 = [1]，nums2 = [1,2] 构建成二叉树，并判断输出的值是否为预期的[2，2]。
 * 示例2：(半子节点) 将数组 nums3 = [1,3,2,5]，nums4 = [2,1,3,null,4,null,7] 构建成二叉树，并判断输出的值是否为预期的[3,4,5,5,4,null,7]。
 * 示例3：(满子节点) 将数组 nums5 = [1,3,2,5]，nums6 = [4,2,7,1,3,6,9] 构建成二叉树，并判断输出的值是否为预期的[5,5,9,6,3,6,9]。
 *
 * @author 张利红
 */
@Slf4j
public class Q617MergingTreesTest {
    @Test
    public void test() {
        // 示例1
        Integer[] nums1 = new Integer[]{1};
        TreeNode root1 = TreeNode.arrayToTree(nums1);
        Integer[] nums2 = new Integer[]{1, 2};
        TreeNode root2 = TreeNode.arrayToTree(nums2);

        TreeNode node = Q617MergingTrees.mergeTrees(root1, root2);
        Integer[] array = TreeNode.treeToArray(node);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx = array.length - 1;
        while (array[idx] == null) {
            idx--;
        }
        Integer[] nullFilteredArr = Arrays.copyOf(array, idx + 1);

        Assertions.assertArrayEquals(new Integer[]{2, 2}, nullFilteredArr,
                " 合并二叉树失败，两数组不相等。");

        // 示例2
        Integer[] nums3 = new Integer[]{1, 3, 2, 5};
        TreeNode root3 = TreeNode.arrayToTree(nums3);
        Integer[] nums4 = new Integer[]{2, 1, 3, null, 4, null, 7};
        TreeNode root4 = TreeNode.arrayToTree(nums4);

        TreeNode node2 = Q617MergingTrees.mergeTrees(root3, root4);
        Integer[] array2 = TreeNode.treeToArray(node2);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx2 = array2.length - 1;
        while (array2[idx2] == null) {
            idx2--;
        }
        Integer[] nullFilteredArr2 = Arrays.copyOf(array2, idx2 + 1);

        Assertions.assertArrayEquals(new Integer[]{3, 4, 5, 5, 4, null, 7}, nullFilteredArr2,
                " 合并二叉树失败，两数组不相等。");

        // 示例3
        Integer[] nums5 = new Integer[]{1, 3, 2, 5};
        TreeNode root5 = TreeNode.arrayToTree(nums5);
        Integer[] nums6 = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root6 = TreeNode.arrayToTree(nums6);

        TreeNode node3 = Q617MergingTrees.mergeTrees(root5, root6);
        Integer[] array3 = TreeNode.treeToArray(node3);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx3 = array3.length - 1;
        while (array3[idx3] == null) {
            idx3--;
        }
        Integer[] nullFilteredArr3 = Arrays.copyOf(array3, idx3 + 1);

        Assertions.assertArrayEquals(new Integer[]{5, 5, 9, 6, 3, 6, 9}, nullFilteredArr3,
                " 合并二叉树失败，两数组不相等。");

    }

}

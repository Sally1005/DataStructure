package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 617. 测试合并二叉树
 * 示例1：将数组 nums1 = [1]，nums2 = [1,2] 构建成二叉树，并判断输出的值是否为预期的[2，2]。
 * 示例2：(半子节点) 将数组 nums3 = [1,3,2,5]，nums4 = [2,1,3,null,4,null,7] 构建成二叉树，并判断输出的值是否为预期的[3,4,5,5,4,null,7]。
 * 示例3：(满子节点) 将数组 nums5 = [1,3,2,5]，nums6 = [4,2,7,1,3,6,9] 构建成二叉树，并判断输出的值是否为预期的[5,5,9,6,3,6,9]。
 * 示例4：(根节点为null) 将数组 nums7 = [4,2,7,1,3,6,9]，nums8 = [ ] 构建成二叉树，并判断输出的值是否为预期的[4,2,7,1,3,6,9]。
 *
 * @author 张利红
 */
@Slf4j
public class Q617MergingTreesTest {

    @Test
    public void test1() {

        Integer[] nums1 = new Integer[]{1};
        TreeNode root1 = TreeNode.arrayToTree(nums1);
        Integer[] nums2 = new Integer[]{1, 2};
        TreeNode root2 = TreeNode.arrayToTree(nums2);

        TreeNode node = Q617MergingTrees.mergeTrees(root1, root2);
        Integer[] array = (Integer[]) TreeNode.treeToArray(node);

        Assertions.assertArrayEquals(new Integer[]{2, 2}, array,
                " 合并二叉树失败，两数组不相等。");

    }

    @Test
    public void test2() {

        Integer[] nums3 = new Integer[]{1, 3, 2, 5};
        TreeNode root3 = TreeNode.arrayToTree(nums3);
        Integer[] nums4 = new Integer[]{2, 1, 3, null, 4, null, 7};
        TreeNode root4 = TreeNode.arrayToTree(nums4);

        TreeNode node2 = Q617MergingTrees.mergeTrees(root3, root4);
        Integer[] array = (Integer[]) TreeNode.treeToArray(node2);

        Assertions.assertArrayEquals(new Integer[]{3, 4, 5, 5, 4, null, 7}, array,
                " 合并二叉树失败，两数组不相等。");

    }

    @Test
    public void test3() {

        Integer[] nums5 = new Integer[]{1, 3, 2, 5};
        TreeNode root5 = TreeNode.arrayToTree(nums5);
        Integer[] nums6 = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root6 = TreeNode.arrayToTree(nums6);

        TreeNode node3 = Q617MergingTrees.mergeTrees(root5, root6);
        Integer[] array = (Integer[]) TreeNode.treeToArray(node3);

        Assertions.assertArrayEquals(new Integer[]{5, 5, 9, 6, 3, 6, 9}, array,
                " 合并二叉树失败，两数组不相等。");

    }

    @Test
    public void test4() {

        Integer[] nums7 = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root7 = TreeNode.arrayToTree(nums7);
        Integer[] nums8 = new Integer[0];
        TreeNode root8 = TreeNode.arrayToTree(nums8);

        TreeNode node4 = Q617MergingTrees.mergeTrees(root7, root8);
        Integer[] array = (Integer[]) TreeNode.treeToArray(node4);


        Assertions.assertArrayEquals(new Integer[]{4, 2, 7, 1, 3, 6, 9}, array,
                " 合并二叉树失败，两数组不相等。");

    }

}

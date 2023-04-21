package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 617. 测试合并二叉树
 * <ol>
 * <li> 将数组 nums1 = [1]，nums2 = [1,2] 构建成二叉树，并判断输出的值是否为预期的[2，2]。
 * <li> (半子节点) 将数组 nums3 = [1,3,2,5]，nums4 = [2,1,3,null,4,null,7] 构建成二叉树，并判断输出的值是否为预期的[3,4,5,5,4,null,7]。
 * <li> (满子节点) 将数组 nums5 = [1,3,2,5]，nums6 = [4,2,7,1,3,6,9] 构建成二叉树，并判断输出的值是否为预期的[5,5,9,6,3,6,9]。
 * <li> (根节点为null) 将数组 nums7 = [4,2,7,1,3,6,9]，nums8 = [ ] 构建成二叉树，并判断输出的值是否为预期的[4,2,7,1,3,6,9]。
 * </ol>
 *
 * @author 张利红
 */
@Slf4j
public class Q617MergingTreesTest {

    @Test
    public void test() {

        Integer[] nums1 = new Integer[]{1};
        TreeNode<Integer> root1 = new TreeNode<Integer>().arrayToTree(nums1);
        Integer[] nums2 = new Integer[]{1, 2};
        TreeNode<Integer> root2 = new TreeNode<Integer>().arrayToTree(nums2);

        TreeNode<Integer> node = new Q617MergingTrees().mergeTrees(root1, root2);
        Integer[] array =  new TreeNode<Integer>().treeToArray(node );

        Assertions.assertArrayEquals(new Integer[]{2, 2}, array,
                " 合并二叉树失败，两数组不相等。");

    }

    @Test
    public void testHalfChildNode() {

        Integer[] nums3 = new Integer[]{1, 3, 2, 5};
        TreeNode<Integer> root3 = new TreeNode<Integer>().arrayToTree(nums3);
        Integer[] nums4 = new Integer[]{2, 1, 3, null, 4, null, 7};
        TreeNode<Integer> root4 = new TreeNode<Integer>().arrayToTree(nums4);

        TreeNode<Integer> node2 = new Q617MergingTrees().mergeTrees(root3, root4);
        Integer[] array = new TreeNode<Integer>().treeToArray(node2 );

        Assertions.assertArrayEquals(new Integer[]{3, 4, 5, 5, 4, null, 7}, array,
                " 合并二叉树失败，两数组不相等。");

    }

    @Test
    public void testFullChildNode() {

        Integer[] nums5 = new Integer[]{1, 3, 2, 5};
        TreeNode<Integer> root5 = new TreeNode<Integer>().arrayToTree(nums5);
        Integer[] nums6 = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode<Integer> root6 = new TreeNode<Integer>().arrayToTree(nums6);

        TreeNode<Integer> node3 = new Q617MergingTrees().mergeTrees(root5, root6);
        Integer[] array = new TreeNode<Integer>().treeToArray(node3 );

        Assertions.assertArrayEquals(new Integer[]{5, 5, 9, 6, 3, 6, 9}, array,
                " 合并二叉树失败，两数组不相等。");

    }

    @Test
    public void testNull() {

        Integer[] nums7 = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode<Integer> root7 = new TreeNode<Integer>().arrayToTree(nums7);
        Integer[] nums8 = new Integer[0];
        TreeNode<Integer> root8 = new TreeNode<Integer>().arrayToTree(nums8);

        TreeNode<Integer> node4 = new Q617MergingTrees().mergeTrees(root7, root8);
        Integer[] array = new TreeNode<Integer>().treeToArray(node4 );

        Assertions.assertArrayEquals(new Integer[]{4, 2, 7, 1, 3, 6, 9}, array,
                " 合并二叉树失败，两数组不相等。");

    }

}

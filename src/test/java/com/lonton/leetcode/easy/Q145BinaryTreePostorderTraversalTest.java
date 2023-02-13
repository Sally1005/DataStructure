package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.lonton.leetcode.common.BinaryTree.assertCollectionsAreEquals;

/**
 * 测试二叉树后序遍历 <p/>
 * 将数组 nums = [1,null,2,3] 构建成二叉树，并判断输出的值是否为预期的[3,2,1]。
 *
 * @author 张利红
 */

public class Q145BinaryTreePostorderTraversalTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, null, 2, 3};
        TreeNode root = BinaryTree.arrayToTree(nums);

        assertCollectionsAreEquals(Arrays.asList(3, 2, 1),
                Q145BinaryTreePostorderTraversal.postorderTraversal(root),
                "NotEquals---二叉树后序遍历实际得到的结果与预期结果不相等。");
    }

}

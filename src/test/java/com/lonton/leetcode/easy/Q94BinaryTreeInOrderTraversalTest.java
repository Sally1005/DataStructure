package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static com.lonton.leetcode.common.BinaryTree.assertCollectionsAreEquals;

/**
 * 测试二叉树中序遍历 <p/>
 * 将数组 nums = [1,null,2,3] 构建成二叉树，并判断输出的值是否为预期的[1,3,2]。
 *
 * @author 张利红
 */

public class Q94BinaryTreeInOrderTraversalTest {
    @Test
    public void test() {
        Integer[] nums = new Integer[]{1, null, 2, 3};
        TreeNode root = BinaryTree.arrayToTree(nums);

        assertCollectionsAreEquals(Arrays.asList(1, 3, 2),
                Q94BinaryTreeInOrderTraversal.inorderTraversal(root),
                "NotEquals---二叉树中序遍历实际得到的结果与预期结果不相等。");
    }

}

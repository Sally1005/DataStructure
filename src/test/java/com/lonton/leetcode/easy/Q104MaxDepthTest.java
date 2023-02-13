package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 将数组 nums = [3,9,20,null,null,15,7] 构建成二叉树,并校验二叉树最大深度是否为预期值3。<p/>
 *
 * @author 张利红
 */
public class Q104MaxDepthTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = BinaryTree.arrayToTree(nums);

        Assertions.assertEquals(3, new Q104MaxDepth().maxDepth(root),
                "NotEquals---最大深度计算错误错误，实际计算值与预期不符。");
    }
}

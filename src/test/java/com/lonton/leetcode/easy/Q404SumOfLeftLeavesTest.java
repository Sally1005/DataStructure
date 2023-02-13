package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试左叶子之和 <p/>
 * 将数组 nums = [3,9,20,null,null,15,7]构建成二叉树，并判断输出的值是否为预期的24。 <p/>
 *
 * @author 张利红
 */
public class Q404SumOfLeftLeavesTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = BinaryTree.arrayToTree(nums);

        Assertions.assertEquals(24, new Q404SumOfLeftLeaves().sumOfLeftLeaves(root),
                "NotEquals---左叶子之和计算错误，实际结果与预期值不相等。");
    }

}

package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 404. 测试左叶子之和
 * <ul>
 * <li> 将数组 nums = [3,9,20,null,null,15,7]构建成二叉树，并判断输出的值是否为预期的24。
 * </ul>
 *
 * @author 张利红
 */
public class Q404SumOfLeftLeavesTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode<>().arrayToTree(nums);

        Assertions.assertEquals(24, new Q404SumOfLeftLeaves().sumOfLeftLeaves(root),
                " 左叶子之和计算错误。");
    }

}

package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * 测试二叉搜索树中的搜索<p/>
 * 将数组 nums = [4,2,7,1,3] 构建成二叉树，整数值 val = 2，并判断输出的值是否为预期的[2,1,3]。
 *
 * @author 张利红
 */
public class Q700SearchBSTTest {
    @Test
    public void test() {
        Integer[] nums = new Integer[]{4, 2, 7, 1, 3};
        TreeNode root = TreeNode.arrayToTree(nums);

        TreeNode node = Q700SearchBST.searchBST(root, 2);
        Integer[] array = (Integer[]) TreeNode.treeToArray(node);

        Assertions.assertArrayEquals(new Integer[]{2, 1, 3}, array,
                " 二叉搜索树搜索整数值失败，两数组不相等。");
    }
}

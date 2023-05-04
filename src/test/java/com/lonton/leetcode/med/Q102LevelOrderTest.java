package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 102. 测试二叉树的层级遍历
 * <ul>
 * <li> 将数组 nums = [3,9,20,null,null,15,7] 构建成二叉树，并判断输出的值是否为预期的[[3],[9,20],[15,7]]。
 * </ul>
 *
 * @author 张利红
 */
public class Q102LevelOrderTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)));

        Assertions.assertEquals(expected, new Q102LevelOrder().levelOrder(root),
                "比对失败，二叉树的层级遍历出的集合有问题。");
    }

}

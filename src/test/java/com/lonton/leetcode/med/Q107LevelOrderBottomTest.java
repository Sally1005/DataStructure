package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 107. 测试二叉树的层级遍历 II
 * <ul>
 * <li> 将数组 nums = [5,4,8,11,null,13,4,7,2,null,null,5,1],构建成二叉树,并判断输出的值是否为预期的[[15,7],[9,20],[3]]。
 * </ul>
 *
 * @author 张利红
 */
public class Q107LevelOrderBottomTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> node = new TreeNode<Integer>().arrayToTree(nums);

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Collections.singletonList(3)));

        Assertions.assertEquals(expected, new Q107LevelOrderBottom().levelOrderBottom(node),
                " 比对失败，二叉树的层级遍历II遍历出的集合有问题。");
    }
}

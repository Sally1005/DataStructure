package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 538. 测试将二叉搜索树转换为累加树
 * <ol>
 * <li> 将数组 nums = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8] 构建成二叉树，
 *     并判断输出的值是否为预期的[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]。
 * <li> 将数组 nums = [1,0,2] 构建成二叉树，并判断输出的值是否为预期的[3,3,2]。
 * <li> 将数组 nums = [3,2,4,1] 构建成二叉树，并判断输出的值是否为预期的[7,9,4,10]。
 * </ol>
 *
 * @author 张利红
 */
public class Q538ConvertBSTToGreaterTreeTest {
    @Test
    public void test() {
        // 构树
        Integer[] nums = new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode<Integer> actual = new Q538ConvertBSTToGreaterTree().convertBST(new TreeNode<Integer>().arrayToTree(nums));

        Integer[] expected = new Integer[]{30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8};

        // 断言
        Assertions.assertArrayEquals(expected,new TreeNode<Integer>().treeToArray(actual),
                "比对失败，将二叉搜索树转换为累加树有误");
    }

    @Test
    public void test2() {
        // 构树
        Integer[] nums = new Integer[]{1, 0, 2};
        TreeNode<Integer> actual = new Q538ConvertBSTToGreaterTree().convertBST(new TreeNode<Integer>().arrayToTree(nums));

        Integer[] expected = new Integer[]{3, 3, 2};

        // 断言
        Assertions.assertArrayEquals(expected,new TreeNode<Integer>().treeToArray(actual),
                "比对失败，将二叉搜索树转换为累加树有误");
    }

    @Test
    public void test3() {
        // 构树
        Integer[] nums = new Integer[]{3, 2, 4, 1};
        TreeNode<Integer> actual = new Q538ConvertBSTToGreaterTree().convertBST(new TreeNode<Integer>().arrayToTree(nums));

        Integer[] expected = new Integer[]{7, 9, 4, 10};

        // 断言
        Assertions.assertArrayEquals(expected, new TreeNode<Integer>().treeToArray(actual),
                "比对失败，将二叉搜索树转换为累加树有误");
    }
}

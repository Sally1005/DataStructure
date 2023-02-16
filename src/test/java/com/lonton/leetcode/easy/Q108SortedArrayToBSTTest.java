package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.lonton.leetcode.easy.Q100SameTree.isSameTree;


/**
 * 测试 将有序数组转换为二叉搜索树<p/>
 * 输入：nums = [-10,-3,0,5,9],result = [0,-10,5,null,-3,null,9]<p/>
 * 比较两个有序数组是否构为相同的二叉搜索树，预期值为true
 *
 * @author 张利红
 */
public class Q108SortedArrayToBSTTest {
    @Test
    public void test() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode actual = new Q108SortedArrayToBST().sortedArrayToBST(nums);
        Integer[] array = TreeNode.treeToArray(actual);
        // 因为数组后面的null不影响数据，为了方便测试，将数组后面的null值都去掉
        int idx = array.length - 1;
        while (array[idx] == null) {
            idx--;
        }
        Integer[] nullFilteredArr = Arrays.copyOf(array, idx + 1);

        Integer[] expected = new Integer[]{0, -10, 5, null, -3, null, 9};

        Assertions.assertArrayEquals(expected,nullFilteredArr,
                "比对失败，两个有序数组没有构为相同的二叉搜索树");
    }
}




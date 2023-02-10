package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 测试 将有序数组转换为二叉搜索树<p/>
 * 输入：nums = [-10,-3,0,5,9],result = [0,-10,5,null,-3,null,9]<p/>
 * 比较两个有序数组是否构为相同的二叉搜索树
 *
 * @author 张利红
 */
@Slf4j
public class Q108SortedArrayToBSTTest {
    @Test
    public void test() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode actual = new Q108SortedArrayToBST().sortedArrayToBST(nums);

        Integer[] result = new Integer[]{0, -10, 5, null, -3, null, 9};
        TreeNode expected = BinaryTree.arrayToTree(result);

        Assertions.assertTrue(isSameTree(expected, actual), "有序数组转换为二叉搜索树失败!");

    }

    /**
     * 判断是否为相同的树  复制 Q100
     *
     * @param p 根节点 p
     * @param q 根节点 q
     * @return boolean
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两棵树的根节点都为空，那么它们为相同的树
        if (p == null && q == null) {
            return true;
        }
        // 如果两棵树要么一棵树根节点为空，要么另一棵树根节点不为空，不是相同的树（上面已对都为空的情况进行判断）
        if (p == null || q == null) {
            return false;
        }
        // 排除不相等的情况，再讨论两棵树相同情况下的条件
        return (p.getVal() == q.getVal() && isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight()));
    }
}




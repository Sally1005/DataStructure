package com.lonton.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试左叶子之和 <p/>
 * 输入: root = [3,9,20,null,null,15,7] <p/>
 * 输出: 24 <p/>
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 <p/>
 *
 */
@Slf4j
public class Q404SumOfLeftLeavesTest {
    @Test
    public void test(){
        // 建树
        Q404SumOfLeftLeaves.TreeNode tree = new Q404SumOfLeftLeaves.TreeNode(3,new Q404SumOfLeftLeaves.TreeNode(9),
                new Q404SumOfLeftLeaves.TreeNode(20,
                        new Q404SumOfLeftLeaves.TreeNode(15),
                        new Q404SumOfLeftLeaves.TreeNode(7)));

        // 断言
        Assert.assertEquals("左叶子之和计算错误",24, new Q404SumOfLeftLeaves().sumOfLeftLeaves(tree));
    }


}

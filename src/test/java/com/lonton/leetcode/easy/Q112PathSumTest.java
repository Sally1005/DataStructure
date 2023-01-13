package com.lonton.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试路径总和 <p/>
 * 判断该树中是否存在 根节点到叶子节点 的路径。<p/>
 * 示例：<p/>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22 <p/>
 * 输出：true
 * @author 张利红
 */
public class Q112PathSumTest {
    @Test
    public void test() {
        Q112PathSum.TreeNode root = new Q112PathSum.TreeNode(5,
                new Q112PathSum.TreeNode(4,
                        new Q112PathSum.TreeNode(11,
                                new Q112PathSum.TreeNode(7),
                                new Q112PathSum.TreeNode(2)),
                        null),
                new Q112PathSum.TreeNode(8,
                        new Q112PathSum.TreeNode(13),
                        new Q112PathSum.TreeNode(4,
                                null,
                                new Q112PathSum.TreeNode(1))
                )

        );

        Assert.assertEquals(true,Q112PathSum.hasPathSum(root, 22));
    }
}

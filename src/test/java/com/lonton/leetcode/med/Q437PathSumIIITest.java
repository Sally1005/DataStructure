package com.lonton.leetcode.med;

import com.lonton.leetcode.easy.Q104MaxDepth;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 测试路径数目 <p/>
 * 示例：<p/>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8 <p/>
 * 输出：3 <p/>
 * 解释：和等于 8 的路径有 3 条。
 * @author 张利红
 */
public class Q437PathSumIIITest {

    @Test
    public void test() {
        // 构建二叉树
        Q437PathSumIII.TreeNode root = new Q437PathSumIII.TreeNode(10,
                new Q437PathSumIII.TreeNode(5,
                        new Q437PathSumIII.TreeNode(3,
                                new Q437PathSumIII.TreeNode(3),
                                new Q437PathSumIII.TreeNode(-2)),
                        new Q437PathSumIII.TreeNode(2,
                                null,
                                new Q437PathSumIII.TreeNode(1))),
                new Q437PathSumIII.TreeNode(-3,
                        null,
                        new Q437PathSumIII.TreeNode(11))

        );

        Assertions.assertSame(3, Q437PathSumIII.pathSum(root,8),"路径数目计算错误。");

    }
}

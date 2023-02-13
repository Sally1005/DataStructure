package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 测试路径总和 <p/>
 * 将数组 [5,4,8,11,null,13,4,7,2,null,null,null,1] 构建成二叉树,
 * 并判断该树中是否存在 根节点到叶子节点 的路径 和为 t1 = 22, t2 = 27, t3 = 18, t4 = 26，预期结果为true。 <p/>
 *
 * @author 张利红
 */
public class Q112PathSumTest {
    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = BinaryTree.arrayToTree(nums);

        // 断言
        Assertions.assertEquals(true, Q112PathSum.hasPathSum(root, 22),
                "NotEquals---符合条件的路径总和不存在，实际得到的结果与预期结果不相等。");
        Assertions.assertEquals(true, Q112PathSum.hasPathSum(root, 27),
                "NotEquals---符合条件的路径总和不存在，实际得到的结果与预期结果不相等。");
        Assertions.assertEquals(true, Q112PathSum.hasPathSum(root, 18),
                "NotEquals---符合条件的路径总和不存在，实际得到的结果与预期结果不相等。");
        Assertions.assertEquals(true, Q112PathSum.hasPathSum(root, 26),
                "NotEquals---符合条件的路径总和不存在，实际得到的结果与预期结果不相等。");
    }
}

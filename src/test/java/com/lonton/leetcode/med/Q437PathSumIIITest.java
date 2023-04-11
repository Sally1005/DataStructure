package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 437. 测试路径数目
 * <ol>
 * <li> 将数组 [10,5,-3,3,2,null,11,3,-2,null,1],构建成二叉树,并判断该树中是否存在 根节点到叶子节点 的路径 和为 t1 = 8, 共3条。
 * </ol>
 *
 * @author 张利红
 */
public class Q437PathSumIIITest {
    @Test
    public void test() {

        // 构建二叉树
        Integer[] nums = new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = new TreeNode<>().arrayToTree(nums);

        // 断言
        Assertions.assertEquals(3, new Q437PathSumIII().pathSum(root, 8),
                " 路径数目计算错误。");
    }
}

package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 513. 测试求树左下角的值
 * <ol>
 * <li> 将数组 [1,2,3,4,null,5,6,null,null,7],构建成二叉树,并判断树左下角的值为 7；
 * <li> (最低端 最左边 为右子树节点的情况)：将数组 [1,2,3,null,null,null,4,null,5],构建成二叉树,并判断树左下角的值为 5。
 * </ol>
 *
 * @author 张利红
 */
public class Q513FindBottomLeftTreeValueTest {

    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7};
        TreeNode root = new TreeNode<>().arrayToTree(nums);

        int result = (int) new Q513FindBottomLeftTreeValue().findBottomLeftValue(root);

        // 断言
        Assertions.assertEquals(7, result, "当树左下角的值为最低端、最左边、为左子树节点的情况时计算错误。");
    }

    @Test
    public void testTheLowestLeftInLeftSubtree() {
        // 构建二叉树
        Integer[] nums2 = new Integer[]{1, 2, 3, null, null, null, 4, null, 5};
        TreeNode root2 = new TreeNode<>().arrayToTree(nums2);

        int result2 = (int) new Q513FindBottomLeftTreeValue().findBottomLeftValue(root2);

        // 断言
        Assertions.assertEquals(5, result2, "当树左下角的值为最低端、最左边、为右子树节点的情况时计算错误。");
    }
}

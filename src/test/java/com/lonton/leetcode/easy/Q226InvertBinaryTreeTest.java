package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.BinaryTree;
import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.lonton.leetcode.easy.Q226InvertBinaryTree.invertTree;


/**
 * 测试翻转二叉树 <p/>
 * 将数组 [4,2,7,1,3,6,9] 构建成树(满子节点),并判断翻转后二叉树节点是否符合预期
 * 将数组 [4,2,7,1] 构建成树(半子节点),并判断翻转后二叉树节点是否符合预期
 *
 * @author 张利红
 */
public class Q226InvertBinaryTreeTest {

    @Test
    public void test() {

        // 构建二叉树
        Integer[] nums = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        Integer[] nums2 = new Integer[]{4, 2, 7, 1};
        TreeNode root1 = BinaryTree.arrayToTree(nums);
        TreeNode root2 = BinaryTree.arrayToTree(nums2);

        // 翻转树
        invertTree(root1);
        invertTree(root2);

        // 断言
        Assertions.assertEquals(2, root1.getRight().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(1, root1.getRight().getRight().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(3, root1.getRight().getLeft().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(4, root1.getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(7, root1.getLeft().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(9, root1.getLeft().getLeft().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(6, root1.getLeft().getRight().getVal(), "NotEquals---翻转后树的节点与预期不相等。");

        Assertions.assertEquals(2, root2.getRight().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(1, root2.getRight().getRight().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(4, root2.getVal(), "NotEquals---翻转后树的节点与预期不相等。");
        Assertions.assertEquals(7, root2.getLeft().getVal(), "NotEquals---翻转后树的节点与预期不相等。");
    }
}

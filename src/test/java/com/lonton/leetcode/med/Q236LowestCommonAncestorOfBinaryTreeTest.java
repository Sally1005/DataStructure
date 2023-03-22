package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试求二叉树的最近公共祖先 <p/>
 * 将数组 nums = [3,5,1,6,2,0,8,null,null,7,4] 构建成二叉树，其中  p = 5, q = 1,验证p、q最近公共祖先是否为节点 3 。<p/>
 * 将数组 nums2 = [3,5,1,6,2,0,8,null,null,7,4] 构建成二叉树，其中  p = 5, q = 4,验证p、q最近公共祖先是否为节点 5 。<p/>
 * 将数组 nums3 = [3,5,1,6,2,0,8,null,null,7,4] 构建成二叉树，其中  p = 1, q = 8,验证p、q最近公共祖先是否为节点 1 。<p/>
 * 将数组 nums4 = [1,2] 构建成二叉树，其中  p = 1, q = 2,验证p、q最近公共祖先是否为节点 1 。<p/>
 * 将数组 nums5 = [ ] 构建成二叉树，其中  p = null, q = null,验证p、q最近公共祖先是否为节点 null 。<p/>
 *
 * @author 张利红
 */
public class Q236LowestCommonAncestorOfBinaryTreeTest {

    @Test
    public void test() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.arrayToTree(nums);

        Assertions.assertEquals(3,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.getLeft(), root.getRight()).getVal(),
                "当p和q在左、右子树上时，求二叉树的最近公共祖先错误。");
    }

    @Test
    public void test2() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(5,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.getLeft(), root.getLeft().getRight().getRight()).getVal(),
                "当p和q都在左子树上时，求二叉树的最近公共祖先错误。");
    }

    @Test
    public void test3() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(1,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.getRight(), root.getRight().getRight()).getVal(),
                "当p和q都在右子树上时，求二叉树的最近公共祖先错误。");
    }


    @Test
    public void test4() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, 2};
        TreeNode root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(1,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root, root.getRight()).getVal(),
                "当p和根节点相同时，求二叉树的最近公共祖先错误。");
    }

    @Test
    public void test5() {
        // 构建二叉树
        Integer[] nums = new Integer[0];
        TreeNode root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(null,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(null, null, null),
                "当二叉树为空树时，求二叉树的最近公共祖先错误。");
    }


}

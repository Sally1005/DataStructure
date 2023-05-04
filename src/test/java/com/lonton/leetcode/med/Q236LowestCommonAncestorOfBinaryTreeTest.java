package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 236.  测试求二叉树的最近公共祖先
 * <ol>
 * <li> 将数组 nums = [3,5,1,6,2,0,8,null,null,7,4] 构建成二叉树，其中  p = 5, q = 1,验证p、q最近公共祖先是否为节点 3 。
 * <li> 将数组 nums2 = [3,5,1,6,2,0,8,null,null,7,4] 构建成二叉树，其中  p = 5, q = 4,验证p、q最近公共祖先是否为节点 5 。
 * <li> 将数组 nums3 = [3,5,1,6,2,0,8,null,null,7,4] 构建成二叉树，其中  p = 1, q = 8,验证p、q最近公共祖先是否为节点 1 。
 * <li> 将数组 nums4 = [1,2] 构建成二叉树，其中  p = 1, q = 2,验证p、q最近公共祖先是否为节点 1 。
 * <li> 将数组 nums5 = [ ] 构建成二叉树，其中  p = null, q = null,验证p、q最近公共祖先是否为节点 null 。
 * </ol>
 *
 * @author 张利红
 */
public class Q236LowestCommonAncestorOfBinaryTreeTest {

    @Test
    public void testBothINLeftAndRightBinaryTree() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);

        Assertions.assertEquals(3,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.getLeft(), root.getRight()).getVal(),
                "当p和q在左、右子树上时，求二叉树的最近公共祖先错误。");
    }

    @Test
    public void testBothINLeftBinaryTree() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(5,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.getLeft(), root.getLeft().getRight().getRight()).getVal(),
                "当p和q都在左子树上时，求二叉树的最近公共祖先错误。");
    }

    @Test
    public void testBothINRightBinaryTree() {
        // 构建二叉树
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(1,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.getRight(), root.getRight().getRight()).getVal(),
                "当p和q都在右子树上时，求二叉树的最近公共祖先错误。");
    }


    @Test
    public void testSame() {
        // 构建二叉树
        Integer[] nums = new Integer[]{1, 2};
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);
        Assertions.assertEquals(1,
                new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root, root.getRight()).getVal(),
                "当p和根节点相同时，求二叉树的最近公共祖先错误。");
    }

    @Test
    public void testEmpty() {
        // 构建二叉树
        Integer[] nums = new Integer[0];
        TreeNode<Integer> root = TreeNode.arrayToTree(nums);
        Assertions.assertNull(new Q236LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, null, null), "当二叉树为空树时，求二叉树的最近公共祖先错误。");
    }
}

package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 669. 测试修剪二叉搜索树
 * <ol>
 *     <li> 树为空，返回null；将数组 root = [ ] 转化为二叉树,low = 1, high = 2,并判断是否符合预期输出[null]。
 *     <li> 不在修剪的范围内：（1）根节点大于high,返回左子树；（2）根节点小于low,返回右子树；
 *          将数组 root = [3,0,4,null,2,null,null,1] 转化为二叉树,low = 1, high = 3,并判断是否符合预期输出[3,2,null,1]。
 *     <li> 在修剪的范围内，递归修剪左右子树。
 *         将数组 root = [3,2,null,1] 转化为二叉树,low = 1, high = 3,并判断是否符合预期输出[3,2,null,1]。
 * </ol>
 *
 * @author 张利红
 */
public class Q669TrimBSTTest {

    @Test
    public void testEmpty() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[0]);
        TreeNode tree = new Q669TrimBST().trimBST(root, 1, 2);

        Assertions.assertArrayEquals(new Integer[0], new TreeNode<Integer>().treeToArray(tree, Integer.class),
                "当树为空时，修剪二叉搜索树的结果与实际预期不相等。");
    }

    @Test
    public void testOutOfRange() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{3, 0, 4, null, 2, null, null, 1});
        TreeNode tree = new Q669TrimBST().trimBST(root, 1, 3);

        Assertions.assertArrayEquals(new Integer[]{3, 2, null, 1}, new TreeNode<Integer>().treeToArray(tree, Integer.class),
                "当根节点不在修剪的范围内时，修剪二叉搜索树的结果与实际预期不相等。");
    }


    @Test
    public void testInRange() {
        TreeNode root = new TreeNode<>().arrayToTree(new Integer[]{3, 2, null, 1});
        TreeNode tree = new Q669TrimBST().trimBST(root, 1, 3);

        Assertions.assertArrayEquals(new Integer[]{3, 2, null, 1}, new TreeNode<Integer>().treeToArray(tree, Integer.class),
                "当根节点在修剪的范围内时，修剪二叉搜索树的结果与实际预期不相等。");
    }

}

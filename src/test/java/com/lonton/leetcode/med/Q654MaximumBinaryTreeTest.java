package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * 测试求最大二叉树  <p/>
 * 示例1（空树）：将数组 [ ],构建成二叉树,并判断是否符合预期输出[null]。<p/>
 * 示例2（仅根节点）：将数组 [1],构建成二叉树,并判断是否符合预期输出[1,null,null]。<p/>
 * 示例3（左树左枝）：将数组 [2,4,3,5],构建成二叉树,并判断是否符合预期输出[5,4,null,2,3,null]。<p/>
 * 示例4（右树右枝）：将数组 [3,2,1],构建成二叉树,并判断是否符合预期输出[3,null,2,null,1]。<p/>
 * 示例5（右树左枝）：将数组 [5,2,3,4 ],构建成二叉树,并判断是否符合预期输出[5,null,4,3,null,2,null]。<p/>
 * 示例6（左树右枝）：将数组 [5,4,2,6],构建成二叉树,并判断是否符合预期输出[6,5,null,null,4,null,2]。<p/>
 * 示例7（左树右树）：将数组 [3,2,1,6,0,5],构建成二叉树,并判断是否符合预期输出[6,3,5,null,2,0,null,null,1]。<p/>
 *
 * @author 张利红
 */
public class Q654MaximumBinaryTreeTest {

    @Test
    public void testWithEmptyTree() {
        Assertions.assertNull(
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{}),
                "当二叉树构建为空树时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testWithSingleNumber() {
        Assertions.assertEquals(
                new TreeNode(
                        1,
                        null,
                        null
                ),
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{1}),
                "当二叉树构建仅有根节点时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testLeftSubtreeWithLeftBranch() {
        Assertions.assertEquals(
                new TreeNode(
                        5,
                        new TreeNode(
                                4,
                                new TreeNode(2, null, null),
                                new TreeNode(3, null, null)
                        ),
                        null
                ),
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{2, 4, 3, 5}),
                "当二叉树构建为左树左枝时，求最大二叉树计算错误。"
        );
    }


    @Test
    public void testRightSubtreeWithRightBranch() {
        Assertions.assertEquals(
                new TreeNode(
                        3,
                        null,
                        new TreeNode(2, null, new TreeNode(1, null, null))
                ),
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1}),
                "当二叉树构建为右树右枝时，求最大二叉树计算错误。"

        );
    }

    @Test
    public void testRightSubtreeWithLeftBranch() {
        Assertions.assertEquals(
                new TreeNode(
                        5,
                        null,
                        new TreeNode(
                                4,
                                new TreeNode(3,
                                        new TreeNode(2, null, null), null),
                                null
                        )
                ),
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{5, 2, 3, 4}),
                "当二叉树构建为右树左枝时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testLeftSubtreeWithRightBranch() {
        Assertions.assertEquals(
                new TreeNode(
                        6,
                        new TreeNode(
                                5,
                                null,
                                new TreeNode(4,
                                        null, new TreeNode(2, null, null))
                        ),
                        null
                ),
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{5, 4, 2, 6}),
                "当二叉树构建为左树右枝时，求最大二叉树计算错误。"
        );
    }

    @Test
    public void testLeftSubtreeWithRightSubtree() {
        Assertions.assertEquals(
                new TreeNode(
                        6,
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(2, null, new TreeNode(1, null, null))
                        ),
                        new TreeNode(
                                5,
                                new TreeNode(0, null, null),
                                null
                        )
                ),
                new Q654MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}),
                "当二叉树构建为均有左树右树时，求最大二叉树计算错误。"
        );
    }

}





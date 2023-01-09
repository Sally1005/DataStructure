package com.lonton.leetcode.easy;

import com.lonton.leetcode.easy.Q110BalancedBinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 测试判断二叉树是否是高度平衡的二叉树 <p/>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * @author 张利红
 */
@Slf4j
public class Q110BalancedBinaryTreeTest {
    @Test
    public void test() {
        // 构建二叉树
        Q110BalancedBinaryTree.TreeNode root= new Q110BalancedBinaryTree.TreeNode(3,
                new Q110BalancedBinaryTree.TreeNode(9),
                new Q110BalancedBinaryTree.TreeNode(20, new Q110BalancedBinaryTree.TreeNode(15), new Q110BalancedBinaryTree.TreeNode(7))
        );

        boolean result = new Q110BalancedBinaryTree().isBalanced(root);
        Assertions.assertEquals(true,result,"该二叉树不是高度平衡的二叉树");



    }

}

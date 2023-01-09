package com.lonton.leetcode.easy;

import com.lonton.leetcode.easy.Q101SymmetricBinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
/**
 * 测试二叉树是否为对称的树 <p/>
 * 输入：root = [1,2,2,3,4,4,3] <p/>
 * 输出：true <p/>
 * @author 张利红
 */
@Slf4j
public class Q101SymmetricBinaryTreeTest {
    @Test
    public void test() {
        // 构建二叉树
        Q101SymmetricBinaryTree.TreeNode treeNode = new Q101SymmetricBinaryTree.TreeNode(1,
               new Q101SymmetricBinaryTree.TreeNode(2, new Q101SymmetricBinaryTree.TreeNode(3), new Q101SymmetricBinaryTree.TreeNode(4)),
                new Q101SymmetricBinaryTree.TreeNode(2, new Q101SymmetricBinaryTree.TreeNode(4), new Q101SymmetricBinaryTree.TreeNode(3))
        );

        // 断言判断证明没错
        Assertions.assertSame(true,
                Q101SymmetricBinaryTree.isSymmetric(treeNode),"treeNode不是镜像树");
    }
}

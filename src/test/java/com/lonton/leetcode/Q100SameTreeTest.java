package com.lonton.leetcode;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

@Slf4j
public class Q100SameTreeTest {
    @Test
    public void test() {
        /**
         *  输入：p = [1,2], q = [1,null,2]
         *  输出：false
         */
        // 构建二叉树
        Q100SameTree.TreeNode treeNode1 = new Q100SameTree.TreeNode(1, new Q100SameTree.TreeNode(2), null);
        Q100SameTree.TreeNode treeNode2 = new Q100SameTree.TreeNode(1, null,new Q100SameTree.TreeNode(2));
        // 断点
        boolean expected = false;
        boolean actual = Q100SameTree.isSameTree(treeNode1, treeNode2);
        log.info("是相同的树吗-{}",actual);
        Assertions.assertSame(expected,actual);
    }
}

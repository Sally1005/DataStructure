package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Test_100_SameTree {
    @Test
    public void test() {
        /**
         *  输入：p = [1,2], q = [1,null,2]
         *  输出：false
         */
        // 构建二叉树
        _100_SameTree.TreeNode treeNode1 = new _100_SameTree.TreeNode(1, new _100_SameTree.TreeNode(2), null);
        _100_SameTree.TreeNode treeNode2 = new _100_SameTree.TreeNode(1, null,new _100_SameTree.TreeNode(2));
        // 断点
        boolean expected = false;
        boolean sameTree = _100_SameTree.isSameTree(treeNode1, treeNode2);
        log.info("是相同的树吗-{}",sameTree);
        assert expected == sameTree;
    }
}

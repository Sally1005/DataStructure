package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * 测试二叉树的层级遍历 <p/>
 * 输入：root = [3,9,20,null,null,15,7]<p/>
 * 输出：[[3],[9,20],[15,7]]
 * @author 张利红
 */
@Slf4j
public class Q102LevelOrderTest {
    @Test
    public void test() {
        // 构建二叉树
        Q102LevelOrder.TreeNode treeNode = new Q102LevelOrder.TreeNode(3,
                new Q102LevelOrder.TreeNode(9),
                new Q102LevelOrder.TreeNode(20, new Q102LevelOrder.TreeNode(15), new Q102LevelOrder.TreeNode(7))
        );

        log.info("层序遍历树：{}",new Q102LevelOrder().levelOrder(treeNode));

//        String expected = "[[3], [9, 20], [15, 7]]";
//        String actual = new Q102LevelOrder().levelOrder(treeNode).toString();
//        Assertions.assertSame(expected,actual,"NotEquals");




    }


}

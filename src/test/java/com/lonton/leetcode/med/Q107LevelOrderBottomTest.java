package com.lonton.leetcode.med;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * 测试二叉树的层级遍历 II <p/>
 * 输入：root = [3,9,20,null,null,15,7] <p/>
 * 输出：[[15,7],[9,20],[3]] <p/>
 * @author 张利红
 */
@Slf4j
public class Q107LevelOrderBottomTest {


    @Test
    public void test() {
        // 构建二叉树
        Q107LevelOrderBottom.TreeNode treeNode = new Q107LevelOrderBottom.TreeNode(3,
                new Q107LevelOrderBottom.TreeNode(9),
                new Q107LevelOrderBottom.TreeNode(20, new Q107LevelOrderBottom.TreeNode(15), new Q107LevelOrderBottom.TreeNode(7))
        );
        List<List<Integer>> actual = new Q107LevelOrderBottom().levelOrderBottom(treeNode);
        log.info("actual:{}",actual);

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3)));
        log.info("expected:{}",expected);

        // 断言
        Assertions.assertEquals(expected,actual,"NotEquals");
    }
}

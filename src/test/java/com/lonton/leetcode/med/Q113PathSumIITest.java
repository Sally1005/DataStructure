package com.lonton.leetcode.med;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * 测试路径总和 <p/>
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径<p/>
 * 示例：<p/>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * @author 张利红
 */
@Slf4j
public class Q113PathSumIITest {

    @Test
    public void test() {
        // 构建二叉树
        Q113PathSumII.TreeNode root = new Q113PathSumII.TreeNode(5,
                new Q113PathSumII.TreeNode(4,
                        new Q113PathSumII.TreeNode(11,
                                new Q113PathSumII.TreeNode(7),
                                new Q113PathSumII.TreeNode(2)),
                        null),
                new Q113PathSumII.TreeNode(8,
                        new Q113PathSumII.TreeNode(13),
                        new Q113PathSumII.TreeNode(4,
                                null,
                                new Q113PathSumII.TreeNode(1))
                )

        );

        List<List<Integer>> actual = Q113PathSumII.pathSum(root, 22);
        log.info("actual:{}",actual);

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(Arrays.asList(5,4,11,2)));
        log.info("expected:{}",expected);

        Assertions.assertEquals(expected,actual,"NotEquals");
    }

}


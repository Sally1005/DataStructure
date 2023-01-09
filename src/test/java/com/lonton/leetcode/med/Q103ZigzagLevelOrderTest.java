package com.lonton.leetcode.med;

import com.lonton.leetcode.med.Q103ZigzagLevelOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 测试二叉树的锯齿形层级遍历 <p/>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * @author 张利红
 */
@Slf4j
public class Q103ZigzagLevelOrderTest {
    @Test
    public void test() {
        // 构建二叉树
        Q103ZigzagLevelOrder.TreeNode treeNode = new Q103ZigzagLevelOrder.TreeNode(3,
                new Q103ZigzagLevelOrder.TreeNode(9),
                new Q103ZigzagLevelOrder.TreeNode(20, new Q103ZigzagLevelOrder.TreeNode(15), new Q103ZigzagLevelOrder.TreeNode(7))
        );
        List<List<Integer>> actual = new Q103ZigzagLevelOrder().zigzagLevelOrder(treeNode);
        log.info("actual:{}",actual);

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7)));
        log.info("expected:{}",expected);

        Assertions.assertEquals(expected,actual,"NotEquals");


    }

}

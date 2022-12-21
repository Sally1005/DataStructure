package com.lonton.leetcode;

import cn.hutool.core.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        Integer arr[][] = {{3},{9,20},{15,7}};
        List<List<Integer>> actual = new Q102LevelOrder().levelOrder(treeNode);
        // cn.hutool.core.util.ArrayUtil:直接打印二维数组对象，而非对象地址
        log.info("预期层序遍历树：{}",ArrayUtil.toString(arr));
        log.info("实际层序遍历树：{}",actual);
        Assertions.assertEquals(ArrayUtil.toString(arr),actual.toString(),"NotEquals");




    }

}

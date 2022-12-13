package com.lonton.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 给定二叉树 [3,9,20,null,null,15,7],返回它的最大深度 3 。
 *           3
 *          / \
 *        9    20
 *            /  \
 *           15   7
 */
@Slf4j
public class Q104MaxDepthTest {

     @Test
     public void test(){
           // 建树
          Q104MaxDepth.TreeNode tree = new Q104MaxDepth.TreeNode(3,new Q104MaxDepth.TreeNode(9),
                  new Q104MaxDepth.TreeNode(20,
                          new Q104MaxDepth.TreeNode(15),
                          new Q104MaxDepth.TreeNode(7)));

          int expected = 3;
          int actual = new Q104MaxDepth().maxDepth(tree);
          Assertions.assertSame(expected,actual,"期待值和实际值的最大深度不符");

     }




}

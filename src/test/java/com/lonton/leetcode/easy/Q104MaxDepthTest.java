package com.lonton.leetcode.easy;

import com.lonton.leetcode.easy.Q104MaxDepth;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
/**
 * 给定二叉树 [3,9,20,null,null,15,7],校验二叉树最大深度是否正确，如检验该树的最大深度是否为3。<p/>
 *            3     <p/>
 *          /  \    <p/>
 *        9     20  <p/>
 *             /  \ <p/>
 *           15   7 <p/>
 *  @author 张利红
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
           // 断言判断证明没错
          Assertions.assertSame(3,new Q104MaxDepth().maxDepth(tree),"最大深度计算错误。");

     }




}

package com.lonton.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例1~~输入：root = [3,9,20,null,null,15,7],校验二叉树最小深度是否正确，如检验该树的最小深度是否为 2。<p/>
 *       输出：2 <p/>
 *      3       <p/>
 *     / \      <p/>
 *    9   20    <p/>
 *       /  \   <p/>
 *      15   7  <p/>
 *  <p/>
 * 示例2~~输入：root = [2,null,3,null,4,null,5,null,6],校验二叉树最小深度是否正确，如检验该树的最小深度是否为 5。<p/>
 *       输出：5  <p/>
 *      2        <p/>
 *       \       <p/>
 *        3      <p/>
 *         \     <p/>
 *          4    <p/>
 *           \   <p/>
 *            5  <p/>
 *             \ <p/>
 *              6<p/>
 * 示例3~~输入：root = [2,null,3,null,4,null,5,null,6],校验二叉树最小深度是否正确，如检验该树的最小深度是否为 5。<p/>
 *       输出：5  <p/>
 *      2        <p/>
 *       \       <p/>
 *        3      <p/>
 *         \     <p/>
 *          4    <p/>
 *         /  \  <p/>
 *         1   5 <p/>
 *             \ <p/>
 *              7<p/>
 * @author 张利红
 */
public class Q111MinDepthTest {
    @Test
    public  void  test(){
         // 建树
         Q111MinDepth.TreeNode tree = new Q111MinDepth.TreeNode(3,
                new Q111MinDepth.TreeNode(9),
                new Q111MinDepth.TreeNode(20,
                        new Q111MinDepth.TreeNode(15),new Q111MinDepth.TreeNode(7)));

        Q111MinDepth.TreeNode tree2 = new Q111MinDepth.TreeNode(2,null,
                new Q111MinDepth.TreeNode(3,null,
                        new Q111MinDepth.TreeNode(4,null,
                                new Q111MinDepth.TreeNode(5,null,
                                        new Q111MinDepth.TreeNode(6))))
                );
        Q111MinDepth.TreeNode tree3 = new Q111MinDepth.TreeNode(2,null,
                new Q111MinDepth.TreeNode(3,null,
                        new Q111MinDepth.TreeNode(4,new Q111MinDepth.TreeNode(1),
                                new Q111MinDepth.TreeNode(5,null,
                                        new Q111MinDepth.TreeNode(7))))
        );

        // 断言判断证明没错
        Assertions.assertSame(2,new Q111MinDepth().minDepth(tree),"最小深度计算错误");

        // 断言判断证明没错
        Assertions.assertSame(5,new Q111MinDepth().minDepth(tree2),"最小深度计算错误");

        // 断言判断证明没错
        Assertions.assertSame(4,new Q111MinDepth().minDepth(tree3),"最小深度计算错误");
    }

}

package com.lonton.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例1~~输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *      3
 *     / \
 *    9   20
 *       /  \
 *      15   7
 *  <p/>
 * 示例2~~输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * 示例3~~输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *      2
 *       \
 *        3
 *         \
 *          4
 *         /  \
 *         1   5
 *             \
 *              7
 */
public class Q111MinDepthTest {
    @Test
    public  void  test(){
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

        int expected = 2;
        int actual = new Q111MinDepth().minDepth(tree);
        // 断言期待值和实际值是否相同
        Assertions.assertSame(expected,actual,"期待值和实际值的最小深度不符");

        int expected2 = 5;
        int actual2 = new Q111MinDepth().minDepth(tree2);
        // 断言期待值和实际值是否相同
        Assertions.assertSame(expected2,actual2,"期待值和实际值的最小深度不符");

        int expected3 = 4;
        int actual3 = new Q111MinDepth().minDepth(tree3);
        // 断言期待值和实际值是否相同
        Assertions.assertSame(expected3,actual3,"期待值和实际值的最小深度不符");
    }

}

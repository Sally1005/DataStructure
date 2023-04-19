package com.lonton.leetcode.easy;


import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 100. 测试是否为相同的树
 * <ul>
 * <li> 将数组 p = [1,2], q = [1,null,2] 构建成二叉树，并检验 p,q是否为相同的树，预期值为false。
 * </ul>
 *
 * @author 张利红
 */
public class Q100SameTreeTest {
    @Test
    public void test() {
        Integer[] p = new Integer[]{1, 2};
        Integer[] q = new Integer[]{1, null, 2};
        TreeNode<Integer>  treeNode1 = new TreeNode<Integer>().arrayToTree(p);
        TreeNode<Integer>  treeNode2 = new TreeNode<Integer>().arrayToTree(q);

        Assertions.assertFalse(new Q100SameTree().isSameTree(treeNode1, treeNode2),
                "两棵树是相同的树。");
    }
}

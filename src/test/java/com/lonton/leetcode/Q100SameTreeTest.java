package com.lonton.leetcode;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 *  输入：p = [1,2], q = [1,null,2],检验p,q是否为相同的树 <p/>
 *  输出：false
 * @author 张利红
 */
@Slf4j
public class Q100SameTreeTest {
    @Test
    public void test() {

        // 构建二叉树
        Q100SameTree.TreeNode treeNode1 = new Q100SameTree.TreeNode(1, new Q100SameTree.TreeNode(2), null);
        Q100SameTree.TreeNode treeNode2 = new Q100SameTree.TreeNode(1, null,new Q100SameTree.TreeNode(2));
        // 断言判断证明没错
        Assertions.assertSame(false,
                Q100SameTree.isSameTree(treeNode1, treeNode2),"treeNode1和treeNode2不是相同的树");

    }
}

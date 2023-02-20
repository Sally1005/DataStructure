package com.lonton.leetcode.med;


import com.lonton.leetcode.common.ListNode;
import com.lonton.leetcode.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试 将有序链表转换为二叉搜索树<p/>
 * 输入： head = [-10,-3,0,5,9],
 * head2 = [],(链表为空)
 * 判断翻转后二叉树节点是否符合预期 result1= [0,-3,9,-10,null,5]/[0，-3,9,-10,null,5];result2=[]<p/>
 *
 * @author 张利红
 */
public class Q109SortedListToBSTTest {
    @Test
    public void test() {
        // 构建链表
        ListNode head = ListNode.arrayToList(new Integer[]{-10, -3, 0, 5, 9});
        ListNode head2 = ListNode.arrayToList(new Integer[0]);

        TreeNode tree = new Q109SortedListToBST().sortedListToBST(head);
        TreeNode tree2 = new Q109SortedListToBST().sortedListToBST(head2);

        // 断言
        Assertions.assertEquals(tree.getVal(), 0, "由有序链表构建的二叉搜索树的节点与预期不相等");
        Assertions.assertEquals(tree.getLeft().getVal(), -3, "由有序链表构建的二叉搜索树的节点与预期不相等");
        Assertions.assertEquals(tree.getLeft().getLeft().getVal(), -10, "由有序链表构建的二叉搜索树的节点与预期不相等");
        Assertions.assertEquals(tree.getRight().getVal(), 9, "由有序链表构建的二叉搜索树的节点与预期不相等");
        Assertions.assertEquals(tree.getRight().getLeft().getVal(), 5, "由有序链表构建的二叉搜索树的节点与预期不相等");

        Assertions.assertEquals(tree2, null, "由有序链表构建的二叉搜索树的节点与预期不相等");

    }
}




package com.lonton.leetcode.med;


import com.lonton.leetcode.common.ListNode;
import com.lonton.leetcode.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试 将有序链表转换为二叉搜索树<p/>
 * 示例1：输入： head = [-10,-3,0,5,9],判断翻转后二叉树节点是否符合预期 result1= [0,-3,9,-10,null,5]
 * 示例2：输入：head2 = [],(链表为空)，判断翻转后二叉树节点是否符合预期 result2=[]
 *
 * @author 张利红
 */
public class Q109SortedListToBSTTest {

    @Test
    public void test1() {
        // 构建链表
        ListNode head = ListNode.arrayToList(new Integer[]{-10, -3, 0, 5, 9});
        TreeNode tree1 = new Q109SortedListToBST().sortedListToBST(head);

        // 断言
        TreeNode expected = TreeNode.arrayToTree(new Integer[]{0, -3, 9, -10, null, 5});
        Assertions.assertEquals(expected, tree1, "由有序链表构建的二叉搜索树的节点与预期不相等");
    }


    @Test
    public void test2() {
        // 构建链表
        ListNode head2 = ListNode.arrayToList(new Integer[0]);
        TreeNode tree2 = new Q109SortedListToBST().sortedListToBST(head2);

        // 断言
        Assertions.assertEquals(tree2, null, "由有序链表构建的二叉搜索树的节点与预期不相等");

    }
}




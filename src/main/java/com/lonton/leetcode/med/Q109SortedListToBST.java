package com.lonton.leetcode.med;

import com.lonton.leetcode.common.ListNode;
import com.lonton.leetcode.common.TreeNode;


/**
 * 109. 将有序链表转换为二叉搜索树<p/>
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。<p/>
 * 思路：<p/>
 * 1. 快慢指针找中间节点，将中点作为根节点；<p/>
 * 2. 递归构建树。<p/>
 *
 * @author 张利红
 */
public class Q109SortedListToBST {
    /**
     * 将有序链表转换为二叉搜索树
     *
     * @param head 头节点
     * @return 二叉搜索树
     */
    public TreeNode<Integer> sortedListToBST(ListNode<Integer> head) {
        // 快慢指针找到链表的中点，中点作为根结点，两边作为左右子树
        if (head == null) return null;
        if (head.getNext() == null) return new TreeNode<>(head.getVal());

        // slow是中点，pre是low的前一个结点，断开要置空
        ListNode<Integer> pre = null;
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            pre = slow;
            slow = slow.getNext();
        }
        assert pre != null;
        pre.setNext(null);
        //  递归构建树
        // 返回本结点所在子树
        return new TreeNode<>(
                // 根
                slow.getVal(),
                // 左
                sortedListToBST(head),
                // 右
                sortedListToBST(slow.getNext())
        );
    }
}

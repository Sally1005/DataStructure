package com.lonton.leetcode.common;

import lombok.Data;

/**
 * 定义链表（题目给出条件）
 *
 * @author 张利红
 */
@Data
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 数组转链表
     *
     * @param arr 数组
     * @return 链表
     */
    public static ListNode arrayToList(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}


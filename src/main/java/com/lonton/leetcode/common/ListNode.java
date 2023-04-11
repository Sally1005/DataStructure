package com.lonton.leetcode.common;

import lombok.Data;

/**
 * 定义链表（题目给出条件）
 *
 * @author 张利红
 */
@Data
public class ListNode<T> {
    private T val;
    private ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 数组转链表
     *
     * @param arr 数组
     * @return 链表
     */
    public ListNode<T> arrayToList(T[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode<T> head = new ListNode<T>(arr[0]);
        ListNode<T> tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode<T>(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}


package com.lonton.leetcode.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试数组转链表
 * <ol>
 *  <li> 测试一个非空数组，含多个元素；
 *  <li> 测试只包含一个元素的数组；
 *  <li> 测试一个非空数组。
 * </ol>
 *
 * @author 张利红
 */
public class ListNodeTest {
    @Test
    public void testNotEmpty(){
        Integer[] arr = {1,2,3};
        ListNode<Integer> list = ListNode.arrayToList(arr);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(1,list.getVal().intValue(),"当数组为一个非空数组时，转换为链表的值有误。");
        Assertions.assertEquals(2,list.getNext().getVal().intValue(),"当数组为一个非空数组时，转换为链表的值有误。");
        Assertions.assertEquals(3,list.getNext().getNext().getVal().intValue(),"当数组为一个非空数组时，转换为链表的值有误。");
        Assertions.assertNull(list.getNext().getNext().getNext());
    }

    @Test
    public void testOneElement(){
        String[] arr = {"hello"};
        ListNode<String> list = ListNode.arrayToList(arr);
        Assertions.assertNotNull(list);
        Assertions.assertEquals("hello",list.getVal(),"当数组只只包含一个元素时，转换为链表的值有误。");
        Assertions.assertNull(list.getNext());
    }

    @Test
    public void testEmpty(){
        Integer[] arr = {};
        ListNode<Integer> list = ListNode.arrayToList(arr);
        Assertions.assertNull(list);
    }
}

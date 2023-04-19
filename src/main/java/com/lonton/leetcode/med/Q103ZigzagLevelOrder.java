package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 103. 二叉树的锯齿形层序遍历 <p/>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。<p/>
 * 思路：<p/>
 * 与 Q102LevelOrder基本一样，只是多了一个 1、3、5、...、奇数层从左往右数，偶数则相反 <p/>
 * 可以增加一个标志，判断层级遍历的方向，这就可以利用集合反转的API
 *
 * @author 张利红
 */
public class Q103ZigzagLevelOrder extends TreeNode {
    /**
     * 锯齿形层序遍历
     *
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 大 list
        List<List<Integer>> bList = new LinkedList<>();
        if (root == null) {
            return bList;
        }
        // 创建一个队列，并将根结点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFromLeft = true;
        // 当队列为空时，结束循环
        while (!queue.isEmpty()) {
            // 求队列当前的大小
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // 每一层的数据个数
            while (size > 0) {
                // 当队列里有元素时，就将该队列的首元素出队列
                TreeNode cur = queue.poll();
                if (cur != null) {
                    // 就将cur里的元素放进list里
                    list.add((Integer) cur.getVal());
                    if (cur.getLeft() != null) {
                        // 将cur.left入队列
                        queue.offer(cur.getLeft());
                    }
                    if (cur.getRight() != null) {
                        queue.offer(cur.getRight());
                    }
                }
                // 小 list 中元素自减
                size--;
            }
            if (!isFromLeft) {
                Collections.reverse(list);
            }
            // 将list里的元素放入大 list
            bList.add(list);
            isFromLeft = !isFromLeft;
        }
        return bList;
    }

}

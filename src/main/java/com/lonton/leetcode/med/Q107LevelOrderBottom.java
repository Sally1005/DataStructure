package com.lonton.leetcode.med;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II <p/>
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）<p/>
 * 思路：<p/>
 * 与二叉树的层序遍历不同之处仅在于遍历的方向由从上至下改为从下至上。子节点->根节点<p/>
 * 队列是先进先出，栈是后进先出，在队列基础上加个栈即可实现。<p/>
 * 利用 list集合 add(int index, E element) 可以减少部分代码
 * @author 张利红
 */

public class Q107LevelOrderBottom {
    /**
     * 层序遍历
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 大 list
            List<List<Integer>> bList = new LinkedList<>();
            if (root == null) {
                return bList;
            }
            // 创建一个队列，并将根结点加入队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
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
                        list.add(cur.val);
                        if (cur.left != null) {
                            // 将cur.left入队列
                            queue.offer(cur.left);
                        }
                        if (cur.right != null) {
                            queue.offer(cur.right);
                        }
                    }
                    // 小 list 中元素自减
                    size--;
                }
                // add（0，element）,将数据每次插入到最前面
                bList.add(0,list);
            }
            return bList;
        }


    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 两棵树上的节点数目都在范围 [0, 2000] 内<br/>
     * -1000 <= Node.val <= 1000
     */
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}





















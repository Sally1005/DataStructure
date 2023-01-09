package com.lonton.leetcode.med;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历 <p/>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。<p/>
 * 思路：<p/>
 * 与 Q102LevelOrder基本一样，只是多了一个 1、3、5、...、奇数层从左往右数，偶数则相反 <p/>
 * 可以增加一个标志，判断层级遍历的方向，这就可以利用集合反转的API
 * @author 张利红
 */
public class Q103ZigzagLevelOrder {
    /**
     * 锯齿形层序遍历
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 大 list
        List<List<Integer>> bList = new LinkedList<>();
        if(root==null){
            return bList;
        }
        // 创建一个队列，并将根结点加入队列
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean isFromLeft = true;
        // 当队列为空时，结束循环
        while(!queue.isEmpty()){
            // 求队列当前的大小
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            // 每一层的数据个数
            while(size>0) {
                // 当队列里有元素时，就将该队列的首元素出队列
               TreeNode cur = queue.poll();
                if(cur!=null){
                    // 就将cur里的元素放进list里
                    list.add(cur.val);
                    if(cur.left!=null){
                        // 将cur.left入队列
                        queue.offer(cur.left);
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                }
                // 小 list 中元素自减
                size--;
            }
            if (!isFromLeft){
                Collections.reverse(list);
            }

            // 将list里的元素放入大 list
            bList.add(list);
            isFromLeft = !isFromLeft;

        }
        return bList;
    }


















    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 两棵树上的节点数目都在范围 [0, 2000] 内<br/>
     * -1000 <= Node.val <= 1000
     */

    public static class TreeNode {
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

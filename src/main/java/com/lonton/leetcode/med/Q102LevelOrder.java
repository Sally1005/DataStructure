package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历 <p/>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。<p/>
 * 思路：<p/>
 * 与之前写的递归遍历二叉树深度搜索和返回值为一维数组不同，<p/>
 * 层序遍历为广度优先搜索，且示例的返回值为二维数组，<p/>
 * 参考可以使用队列进行计数，大 list 里面 包含几个小 list (树有几层就有几个小 list )
 *
 * @author 张利红
 */
public class Q102LevelOrder extends TreeNode {
    /**
     * 层序遍历
     *
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                    list.add(cur.getVal());
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
            // 将list里的元素放入大 list
            bList.add(list);
        }
        return bList;
    }
}

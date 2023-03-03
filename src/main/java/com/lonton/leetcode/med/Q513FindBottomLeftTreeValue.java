package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值<p/>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。<p/>
 * 假设二叉树中至少有一个节点。<p/>
 * 思路：<p/>
 * 起初对题目没有理解清楚---“最底层 最左边 ”,
 * 不应考虑左下角的值是否指的是右子树上的节点,
 * 不考虑的话就是一个简单的调转遍历顺序从右至左的层序遍历。
 *
 * @author 张利红
 */
public class Q513FindBottomLeftTreeValue {
    /**
     * 求树左下角的值
     *
     * @param root 根节点
     * @return 树左下角的值
     */
    public int findBottomLeftValue(TreeNode root) {
        // 先创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列中
        queue.offer(root);
        // 定义循环条件(踩坑：null是指对象本身没分配内存，isEmpty是指这个对象指象的内在单元中没有数据)
        while (!queue.isEmpty()){
            // 不断覆盖被队列pull出来的元素
            root = queue.poll();
            // 层序遍历，先右再左，由于队列先进先出
            if (root.getRight() != null){
                queue.offer(root.getRight());
            }
            if (root.getLeft() != null){
                queue.offer(root.getLeft());
            }
        }
      return (int)root.getVal();
    }
}

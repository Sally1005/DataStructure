package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 107. 二叉树的层序遍历 II <p/>
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）<p/>
 * 思路：<p/>
 * 与二叉树的层序遍历不同之处仅在于遍历的方向由从上至下改为从下至上。子节点->根节点<p/>
 * * 利用 list集合 add(int index, E element) 可以减少部分代码 <p/>
 * 法一： list（荐）； 法二：list + Queue <p/>
 *
 * @author 张利红
 */

public class Q107LevelOrderBottom extends TreeNode {
    /**
     * 层序遍历
     *
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // root 为空，返回空数组
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 第一层
        ArrayList<TreeNode> level = new ArrayList<>(Arrays.asList(root));
        while (! level.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            // 遍历level
            for (TreeNode node : level) {
                // 非空 根
                values.add((Integer) node.getVal());
                if (node.getLeft() != null) {
                    nextLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLevel.add(node.getRight());
                }
            }
            level = nextLevel;
            // add（0，element）,将数据每次插入到最前面
            result.add(0, values);
        }
        return result;
    }
    // 法二：list + Queue
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//            // 大 list
//            List<List<Integer>> bList = new LinkedList<>();
//            if (root == null) {
//                return bList;
//            }
//            // 创建一个队列，并将根结点加入队列
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//            // 当队列为空时，结束循环
//            while (!queue.isEmpty()) {
//                // 求队列当前的大小
//                int size = queue.size();
//                List<Integer> list = new ArrayList<>();
//                // 每一层的数据个数
//                while (size > 0) {
//                    // 当队列里有元素时，就将该队列的首元素出队列
//                    TreeNode cur = queue.poll();
//                        // 就将cur里的元素放进list里
//                        list.add(cur.getVal());
//                        if (cur.getLeft() != null) {
//                            // 将cur.left入队列
//                            queue.offer(cur.getLeft());
//                        }
//                        if (cur.getRight() != null) {
//                            queue.offer(cur.getRight());
//                        }
//                    // 小 list 中元素自减
//                    size--;
//                }
//                // add（0，element）,将数据每次插入到最前面
//                bList.add(0,list);
//            }
//            return bList;
//        }

}





















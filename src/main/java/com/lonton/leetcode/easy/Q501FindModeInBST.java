package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数 <p/>
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。<p/>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。<p/>
 * 假定 BST 满足如下定义：<p/>
 * 结点左子树中所含节点的值 小于等于 当前节点的值 <p/>
 * 结点右子树中所含节点的值 大于等于 当前节点的值 <p/>
 * 左子树和右子树都是二叉搜索树 <p/>
 * 思路：<p/>
 * 递归 <p/>
 * 1. 需要定义几个全局实例变量，分别记录 众数集合、当前节点出现的次数、出现次数最多的众数的出现次数 以及处理上一个节点的信息；<p/>
 * 2. 在做完 530. BST的最小绝对差后,可以利用中序遍历变为一个有序的升序数组（众数数组);<p/>
 * 3. 逻辑主要在处理当前节点部分。<p/>
 * 感觉这道题还是有难度，不该放在简单题内。
 *
 * @author 张利红
 */
public class Q501FindModeInBST {

    /**
     * 当前节点出现的次数
     */
    static int curCount = 0;
    /**
     * 出现次数最多的众数的出现次数
     */
    static int maxCount = 0;
    /**
     * 上一个节点
     */
    static int pre = Integer.MIN_VALUE;
    /**
     * 众数集合
     */
    static List<Integer> modes = new ArrayList<>();

    /**
     * 求 BST的众数
     *
     * @param root 根节点
     * @return 众数数组
     */
    public static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        inOrder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    /**
     * 中序遍历
     *
     * @param node 当前节点
     */
    private static void inOrder(TreeNode node) {
        // 递归左子树
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }

        // 处理当前节点。当前节点与上一个值相等
        if ((int) node.getVal() == pre) {
            curCount++;
        } else {
            curCount = 1;
        }
        // 当前节点出现的次数 与 出现次数最多的众数的出现次数 相等
        if (curCount == maxCount) {
            modes.add((Integer) node.getVal());
            // 当前节点出现的次数 大于 出现次数最多的众数的出现次数
        } else if (curCount > maxCount) {
            // 清除原众数集合
            modes.clear();
            modes.add((Integer) node.getVal());
            maxCount = curCount;
        }
        // 接着处理下一条节点信息
        pre = (int) node.getVal();

        // 递归右子树
        if (node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

}

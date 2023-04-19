package com.lonton.leetcode.med;


import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II<p/>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 <p/>
 * 思路：
 * 递归计算每一条路径和，
 * 将路径总和和 targetSum 进行比较。
 * 与112相比，增加了一个path，返回路径集合。
 *
 * @author 张利红
 */

public class Q113PathSumII {
    /**
     * 求路径总和
     *
     * @param root      根节点
     * @param targetSum 目标和
     * @return 符合条件的路径集合
     */
    public List<List<Integer>> pathSum(TreeNode<Integer> root, int targetSum) {
        // 符合条件的路径集合
        List<List<Integer>> result = new ArrayList<>();
        // 到当前节点之前的所有父节点的路径
        List<Integer> path = new ArrayList<>();
        recurve(root, path, 0, targetSum, result);
        return result;
    }

    /**
     * 递归计算
     *
     * @param treeNode  当前递归到的节点
     * @param path      到当前节点之前的所有父节点的路径
     * @param preSum    递归到当前节点之前的所有父节点之和
     * @param targetSum 目标和
     * @param result    符合条件的路径集合
     */
    public void recurve(TreeNode<Integer> treeNode, List<Integer> path, int preSum, int targetSum, List<List<Integer>> result) {
        // 当前递归到的节点为空，直接跳出方法
        if (treeNode == null) {
            return;
        }
        path.add(treeNode.getVal());
        preSum += treeNode.getVal();

        // 左递归路径值
        recurve(treeNode.getLeft(), path, preSum, targetSum, result);
        // 右递归路径值
        recurve(treeNode.getRight(), path, preSum, targetSum, result);

        // 判断是否找到等于目标和的路径 (叶子节点)
        if (treeNode.getLeft() == null && treeNode.getRight() == null && preSum == targetSum) {
            result.add(new ArrayList<>(path));
            // 回溯 减少递归 降低内存
            path.remove(path.size() - 1);
            return;
        }

        // 回溯
        path.remove(path.size() - 1);
    }

}

package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径 <p/>
 * 给你一个二叉树的根节点 ，按 任意顺序，返回所有从根节点到叶子节点的路径。<p/>
 * 思路：<p/>
 * 分为两种情况，一种是当前节点为叶子节点，则直接输出；二是非叶子节点，则继续进行递归。
 *
 * @author 张利红
 */
public class Q257AllPathsToBinaryTrees  {

    /**
     * 二叉树所有路径
     *
     * @param root 根节点
     * @return list集合
     */
    public List<String> binaryTreePaths(TreeNode<Integer>  root) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(root, list, sb);
        return list;
    }

    /**
     * 深度优先遍历
     *
     * @param root 根节点
     * @param list 集合
     * @param sb   字符串缓冲
     */
    public void dfs(TreeNode<Integer> root, List<String> list, StringBuffer sb) {
        if (root == null) {
            return;
        }
        sb.append("->").append(root.getVal());

        // 叶子节点
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(sb.substring(2));
        }

        dfs(root.getLeft(), list, new StringBuffer(sb));
        dfs(root.getRight(), list, new StringBuffer(sb));
    }
}

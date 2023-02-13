package com.lonton.leetcode.common;

import lombok.Data;



/**
 * 定义树（题目给出条件）
 *
 * @author 张利红
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

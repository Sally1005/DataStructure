package com.lonton.leetcode.easy;

/**
 * 617. 合并二叉树 <p/>
 * 给你两棵二叉树：root1 和 root2。<p/>
 * 你需要将这两棵树合并成一棵新二叉树。<p/>
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；<p/>
 * 否则，不为 null 的节点将直接作为新二叉树的节点。<p/>
 * 返回合并后的二叉树。<p/>
 * 注意: 合并过程必须从两个树的根节点开始。<p/>
 * @author 张利红
 */
public class Q617MergingTrees {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // roo1、root2 均非空,将两个节点的值在root1上相加并赋值
        if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
            return root1;
        } else { // roo1 为空，root2 非空 或  roo2 为空，root1 非空
            return root1 == null ? root2 :root1 ;
        }
    }




    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * 两棵树中的节点数目在范围内 [0, 2000]<br/>
     * -104 <= Node.val <= 104
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

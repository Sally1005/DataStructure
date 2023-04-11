package com.lonton.leetcode.easy;

import com.lonton.leetcode.common.TreeNode;

/**
 * 617. 合并二叉树 <p/>
 * 给你两棵二叉树：root1 和 root2。<p/>
 * 你需要将这两棵树合并成一棵新二叉树。<p/>
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；<p/>
 * 否则，不为 null 的节点将直接作为新二叉树的节点。<p/>
 * 返回合并后的二叉树。<p/>
 * 注意: 合并过程必须从两个树的根节点开始。<p/>
 *
 * @author 张利红
 */
public class Q617MergingTrees extends TreeNode {
    /**
     * 合并二叉树
     *
     * @param root1 树1
     * @param root2 树2
     * @return 新树
     */
    public  TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // roo1、root2 均非空,将两个节点的值在root1上相加并赋值
        if (root1 != null && root2 != null) {
            root1.setVal((Integer)root1.getVal() + (Integer)root2.getVal());
            root1.setLeft(mergeTrees(root1.getLeft(), root2.getLeft()));
            root1.setRight(mergeTrees(root1.getRight(), root2.getRight()));
            return root1;
        } else { // roo1 为空，root2 非空 或  roo2 为空，root1 非空
            return root1 == null ? root2 : root1;
        }
    }
}

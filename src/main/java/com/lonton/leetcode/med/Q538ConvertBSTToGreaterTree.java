package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树 <p/>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。<p/>
 * 提醒一下，二叉搜索树满足下列约束条件：<p/>
 * 节点的左子树仅包含键 小于 节点键的节点。<p/>
 * 节点的右子树仅包含键 大于 节点键的节点。<p/>
 * 左右子树也必须是二叉搜索树。<p/>
 * 思路：<p/>
 * 根据BST的特性，中序遍历后的树，即为一个有序的升序数组，那么反过来就是一个有序的降序数组，然后累加就好了。
 *
 * @author 张利红
 */
public class Q538ConvertBSTToGreaterTree {
    int sum = 0;

    /**
     * 将二叉树转换成累加树
     *
     * @param root 根节点
     * @return 累加树
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // 右
            convertBST(root.getRight());
            sum += (int) root.getVal();
            // 根
            root.setVal(sum);
            // 左
            convertBST(root.getLeft());
        }
        return root;
    }
}

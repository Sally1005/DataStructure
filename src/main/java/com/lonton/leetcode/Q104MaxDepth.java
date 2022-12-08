package com.lonton.leetcode;
/**
 * 二叉树的最大深度 ~~ 求树的高度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p/>
 * 树的深度和高度的区别：
 * 对于整棵树来说，最深的叶结点的深度就是树的深度；树根的高度就是树的高度。这样树的高度和深度是相等的。
 * 对于树中相同深度的每个结点来说，它们的高度不一定相同，这取决于每个结点下面的叶结点的深度。
 * 树的深度 = 层数（从上至下）
 * 树的高度 = 层数 + 1（从下至上
 * @author 张利红
 */
public class Q104MaxDepth {
    /**
     * 求二叉树的最大深度
     * @param root 根节点
     * @return 二叉树的最大深度值
     */
    public  int maxDepth(TreeNode root){
         // 根节点为null,空树
        if(root == null){
            return 0;
        }
         // 递归左子树的深度
        int leftMaxDepth = maxDepth(root.left);
         // 递归右子树的深度
        int rightMaxDepth = maxDepth(root.right);
         // 比较左右子树的深度
        return  (leftMaxDepth > rightMaxDepth) ? (leftMaxDepth + 1 ): (rightMaxDepth + 1) ;

    }

    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * <br/>
     * 树中节点数目在范围 [0, 100] 内<br/>
     * -100 <= Node.val <= 100
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

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

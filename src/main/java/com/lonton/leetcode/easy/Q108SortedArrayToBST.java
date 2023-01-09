package com.lonton.leetcode.easy;

/**
 * 108. 将有序数组转换为二叉搜索树<p/>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。<p/>
 * 思路：<p/>
 * 元素已排好序，就类似于二分查找图书，从中间值开始，向左向右将树构建好。
 * 二分法查找,也称为折半法，是一种在有序数组中查找特定元素的搜索算法。<p/>
 * 公式：<p/>
 * let mid = left + (right - left) / 2(如果 left 和 right 都很大，有的编程语言会有整数溢出的情况（例如 C++，Java）)
 * @author 张利红
 */
public class Q108SortedArrayToBST {
    /**
     * 将有序数组转换为二叉搜索树
     * @param nums 整数数组
     * @return TreeNode
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArraysToBST(nums, 0, nums.length-1 );

    }

    /**
     * 二分组装树
     * @param nums 整数数组 nums
     * @param l 左边界值 index
     * @param r 右边界值 index
     * @return TreeNode
     */
    private TreeNode sortedArraysToBST(int[] nums, int l, int r){
         // 左下标比右下标大，栈溢出
        if(l>r){
            return null;
        }
          // 计算中间值
         int mid = l + (r-l)/2;
          // 赋值当前节点
        TreeNode treeNode = new TreeNode(nums[mid]);
          // 递归左节点
        treeNode.left = sortedArraysToBST(nums, l, mid-1);
          // 递归右节点
        treeNode.right = sortedArraysToBST(nums, mid+1, r );
        return treeNode;

    }




    /**
     * 定义二叉树 （题目给出条件）<br/>
     * 提示：<br/>
     * <br/>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
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

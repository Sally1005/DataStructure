package com.lonton.leetcode.easy;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 617. 测试合并二叉树
 * 输入：root1 = [1], root2 = [1,2]<p/>
 * 输出：[2,2] <p/>
 * @author 张利红
 */
public class Q617MergingTreesTest {

    @Test
    public  void  test(){
        // 构建二叉树
        Q617MergingTrees.TreeNode treeNode1 = new Q617MergingTrees.TreeNode(1);
        Q617MergingTrees.TreeNode treeNode2 = new Q617MergingTrees.TreeNode(1, new Q617MergingTrees.TreeNode(2), null);

       Assertions.assertEquals(2,Q617MergingTrees.mergeTrees(treeNode1,treeNode2).val,"合并二叉树失败");
    }

}

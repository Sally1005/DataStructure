package com.lonton.leetcode.easy;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * 测试 将有序数组转换为二叉搜索树<p/>
 * 输入：nums = [-10,-3,0,5,9]<p/>
 * 输出：[0,-3,9,-10,null,5]<p/>
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案。<p/>
 * @author 张利红
 */
@Slf4j
public class Q108SortedArrayToBSTTest {

    @Test
    public void test(){
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        Q108SortedArrayToBST.TreeNode actual = new Q108SortedArrayToBST().sortedArrayToBST(nums);
        // 构树
        Q108SortedArrayToBST.TreeNode expected = new Q108SortedArrayToBST.TreeNode(0);
        expected.left = new Q108SortedArrayToBST.TreeNode(-10);
        expected.left.right = new Q108SortedArrayToBST.TreeNode(-3);
        expected.right = new Q108SortedArrayToBST.TreeNode(5);
        expected.right.right = new Q108SortedArrayToBST.TreeNode(9);

        assertTrue(isSameTree(expected, actual));

    }

    /**
     * 判断是否为相同的树  复制 Q100
     * @param p 根节点 p
     * @param q 根节点 q
     * @return boolean
     */
    private boolean isSameTree(Q108SortedArrayToBST.TreeNode p, Q108SortedArrayToBST.TreeNode q) {
         // 如果两棵树的根节点都为空，那么它们为相同的树
                 if(p == null && q == null){
                     return true;
                 }
                   // 如果两棵树要么一棵树根节点为空，要么另一棵树根节点不为空，不是相同的树（上面已对都为空的情况进行判断）
                 if(p == null || q == null){
                     return false;
                  }
                  // 排除不相等的情况，再讨论两棵树相同情况下的条件
               return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}




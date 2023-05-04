package com.lonton.leetcode.med;

import com.lonton.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 450. 删除二叉搜索树
 * <ol>
 *     <li> 未找到目标节点或根节点为空；给定数组为 root = [5,3,6,2,4,null,7], key = 0,判断是否符合预期[5,3,6,2,4,null,7]。
 *     <li> 找到目标节点。为叶子节点（左空 & 右空）；给定数组为 root = [5,3,6,2,4,null,7], key = 2,判断是否符合预期[5,3,6,null,4,null,7]。
 *     <li> （左空 & 右非空）；给定数组为 root = [5,3,6,2,4,null,7], key = 6,判断是否符合预期[5,3,7,2,4]。
 *     <li> （左非空 & 右空）；给定数组为 root = [5,3,8,2,4,7], key = 8,判断是否符合预期[5,3,7,2,4]。
 *     <li> （左非空 & 右非空）：给定数组为 root = [5,3,6,2,4,null,7], key = 3,判断是否符合预期[5,4,6,2,null,null,7]。
 * </ol>
 *
 * @author 张利红
 */
public class Q450DeleteNodeInBSTTest {

    @Test
    public void testEmpty() {
        TreeNode<Integer> root = TreeNode.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode<Integer> tree = new Q450DeleteNodeInBST().deleteNode(root, 0);

        Assertions.assertArrayEquals(new Integer[]{5, 3, 6, 2, 4, null, 7}, tree.treeToArray(tree),
                "当未找到目标节点或根节点为空时，删除二叉搜索树结果与实际预期不相等。");
    }

    @Test
    public void testLeafNode() {
        TreeNode<Integer> root = TreeNode.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode<Integer> tree = new Q450DeleteNodeInBST().deleteNode(root, 2);

        Assertions.assertArrayEquals(new Integer[]{5, 3, 6, null, 4, null, 7}, tree.treeToArray(tree),
                "当为叶子节点时，删除二叉搜索树结果与实际预期不相等。");
    }

    @Test
    public void testLeftNull() {
        TreeNode<Integer> root = TreeNode.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode<Integer> tree = new Q450DeleteNodeInBST().deleteNode(root, 6);

        Assertions.assertArrayEquals(new Integer[]{5, 3, 7, 2, 4}, tree.treeToArray(tree),
                "当节点左空 & 右非空时，删除二叉搜索树结果与实际预期不相等。");
    }

    @Test
    public void testRightNull() {
        TreeNode<Integer> root = TreeNode.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode<Integer> tree = new Q450DeleteNodeInBST().deleteNode(root, 0);

        Assertions.assertArrayEquals(new Integer[]{5, 3, 6, 2, 4, null, 7}, tree.treeToArray(tree),
                "当节点左非空 & 右空时，删除二叉搜索树结果与实际预期不相等。");
    }

    @Test
    public void testNotNUll() {
        TreeNode<Integer> root = TreeNode.arrayToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode<Integer> tree = new Q450DeleteNodeInBST().deleteNode(root, 3);

        Assertions.assertArrayEquals(new Integer[]{5, 4, 6, 2, null, null, 7}, tree.treeToArray(tree),
                "当节点左非空 & 右非空时，删除二叉搜索树结果与实际预期不相等。");
    }
}

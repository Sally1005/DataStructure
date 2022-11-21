package com.lonton.binaryTree.tree.impl;

import com.lonton.binaryTree.tree.IVisitor;
import com.lonton.binaryTree.tree.pojo.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 访问树高
 * 　<p/>
 * @author 张利红
 */
@Slf4j
public class HeightVisitor implements IVisitor {
    @Override
    public int visit(BinaryTree binaryTree) {
        BinaryTree.TreeNode root = binaryTree.getRoot();
        int res = 0;
        if (root == null)
            return 0;
           // log.info("树的高度为：{}",String.valueOf(0));
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
         // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                BinaryTree.TreeNode curNode = queue.poll();
                if (curNode.getLeft() != null)
                    queue.add(curNode.getLeft());
                if (curNode.getRight() != null)
                    queue.add(curNode.getRight());
            }
            res++;
        }
        return res;
       //log.info("树的高度为：{}",String.valueOf(res));

    }
}

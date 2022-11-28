package com.lonton.binarytree.dao;

import com.lonton.binarytree.tree.pojo.BinaryTree;

import java.util.List;
/**
 * TreeNode的mapper接口
 * <p/>
 * @author 张利红
 */
public interface TreeNodeMapper{
    /**
     * 查询节点列表
     * <br>
     * @return 节点列表
     */
    List<BinaryTree.TreeNode> list();
    }

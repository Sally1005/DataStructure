package com.lonton.binarytree.mapper;

import com.lonton.binarytree.pojo.BinaryTree;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * TreeNode的mapper接口
 * <p/>
 * @author 张利红
 */
@Repository // 解决Mapper注入爆红问题
public interface TreeNodeMapper{
    /**
     * 查询节点列表
     * <br>
     * @return 节点列表
     */
    List<BinaryTree.TreeNode> list();
    }

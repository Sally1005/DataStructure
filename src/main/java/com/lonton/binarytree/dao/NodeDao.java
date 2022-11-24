package com.lonton.binarytree.dao;

import com.lonton.binarytree.tree.pojo.BinaryTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 节点DAO层
 *　<p/>
 * @author 张利红
 */

@Mapper
public interface NodeDao extends Mapper {

     // 查询多行
    @Select("select id,data,weight from score")
    List<BinaryTree.TreeNode> getNodeList();


}

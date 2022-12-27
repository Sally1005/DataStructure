package com.lonton.binarytree.pojo;
import com.lonton.binarytree.pojo.vo.TreeNodeListItemVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 二叉树类
 * <p/>
 * @author 张利红
 */

@Slf4j
@Data
public class BinaryTree<T> {


    /**
     * 根节点
     */
    private TreeNode<T> root;

    /**
     * 节点数
     */
    private int nodeCount;


    /**
     * 在构造函数中创建二叉树
     * @param nodes 节点集
     */
    public BinaryTree(List<TreeNodeListItemVO> nodes) {
     // 以节点id为key 生成映射表 在查找左右子节点时提高效率
    HashMap<Integer, TreeNode> map = new HashMap<>();
     // 先找到根节点 组装二叉树
        TreeNodeListItemVO vo = nodes.get(0);
    TreeNode top = new TreeNode<String>();
    top.setId(vo.getId());
    top.setData(vo.getData());
    top.setLevel(vo.getLevel());
    this.root = top;
    map.put(top.getId(), top);
     // 循环遍历树节点
    for (int i = 1; i < nodes.size(); i++) {
        TreeNodeListItemVO nodeVo = nodes.get(i);
        TreeNode node = new TreeNode<String>();
         // 节点id
        Integer voId = nodeVo.getId();
        node.setId(voId);
        node.setData(nodeVo.getData());
        node.setLevel(nodeVo.getLevel());
        map.put(voId, node);
        // 构建父子节点关系
        TreeNode parentNode = map.get(nodeVo.getParentId());
        if (nodeVo.getIsLeft() == 1){
            parentNode.setLeftNode(node);
        }else {
            parentNode.setRightNode(node);
        }
    }
    // 节点数量就等于map集合中元素的个数
    nodeCount = nodes.size();
}

        @Data
        public static class TreeNode<T> extends TreeNodeListItemVO {

            /**
             * 左子节点
             */
            private TreeNode leftNode;

            /**
             * 右子节点
             */
            private TreeNode rightNode;

        }
    }



package com.lonton.binarytree.tree.pojo.vo;


import lombok.Data;

/**
 * TreeNode列表项VO
 * <p/>
 * @author 张利红
 */
@Data
public class TreeNodeListItemVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 当前节点
     */
    private String data;

    /**
     * 权重
     */
    private int weight;
}

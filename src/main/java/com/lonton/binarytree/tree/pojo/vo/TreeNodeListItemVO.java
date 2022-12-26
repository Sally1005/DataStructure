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
     * 父节点id
     */
    Integer parentId;

    /**
     * 是否为左子节点 1 为左 0为右
     */
    private Integer isLeft;

    /**
     * 当前节点层级
     */
    private Integer level;
}

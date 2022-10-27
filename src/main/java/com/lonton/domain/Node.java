package com.lonton.domain;

import lombok.Data;

/**
 * 节点类
 * @author 张利红
 */
@Data
public class Node {
  /**
   * id主键
   */
  private int id;

  /**
   * 名称
   */
  private String name;
  /**
   * 父节点id
   */
  private int parent_id;
  /**
   * 左节点
   * 右节点
   */
  public Node left,right;

}

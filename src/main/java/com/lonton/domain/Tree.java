package com.lonton.domain;

import com.lonton.dao.NodeDao;
import com.lonton.tree.BinaryTree;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 启动类
 * @author 张利红
 */
@Slf4j
public class Tree extends BinaryTree {

  public static void main(String[] args) {
    String sql = "select * from fruit";
    NodeDao nodeDao = new NodeDao();
    List<Node> nodes = nodeDao.queryMulti(sql, Node.class, null);
    /**
     * 构建二叉树
     */
    Node root = null;
    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      int parentId = node.getParent_id();
      if (parentId == 0) {
        root = node;
      }
      for (int j = 0; j < nodes.size(); j++) {
        if (i == j) {
          continue;
        }
        Node n = nodes.get(j);
        if (n.getId() == parentId) {
          if (n.left == null) {
            n.left = node;
          } else {
            n.right = node;
          }
        }
      }
    }
    traverse(root);
  }

  /**
   * 前序遍历
   * @param node 当前节点
   */
  public static void traverse(Node node) {
    if (node == null) {
      return;
    }
    System.out.println(node.getName());
    traverse(node.left);
    traverse(node.right);
  }
}






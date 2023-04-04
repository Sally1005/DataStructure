package com.lonton.binarytree;

import com.lonton.binarytree.pojo.BinaryTree;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 访问visitor 抽象类
 *
 * @author 张利红
 */

@Data
public abstract class AVisitor {
    /**
     * 过滤属性
     */
    private List<Predicate<BinaryTree.TreeNode>> filters = new ArrayList<>();

    /**
     * 添加过滤器
     */
    public void addFilter(Predicate<BinaryTree.TreeNode> filter) {
        filters.add(filter);
    }

    /**
     * 访问树
     *
     * @param node   节点
     * @param filter 过滤器
     * @return 任意类型
     */
    public Object visit(BinaryTree.TreeNode node, Predicate<BinaryTree.TreeNode> filter) {
        for (Predicate<BinaryTree.TreeNode> f : filters) {
            // 逐一添加所有过滤器
            filter = filter.and(f);
        }
        if (filter.test(node)) {
            return doVisit(node);
        } else {
            return null;
        }
    }

    /**
     * 方便重载以便具体实现类返回相应的返回值
     *
     * @param node 节点
     * @return 任意类型
     */
    protected abstract Object doVisit(BinaryTree.TreeNode node);
}

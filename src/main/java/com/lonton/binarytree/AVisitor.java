package com.lonton.binarytree;

import com.lonton.binarytree.pojo.BinaryTree;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * 访问visitor 抽象类
 * @author 张利红
 */

@Data
public abstract class AVisitor {
    /**
     * 过滤属性
     */
    private Predicate filter;

    /**
     * 过滤(与关系)
     *
     * @return 满足过滤条件的数据
     */
    public List<Predicate<BinaryTree.TreeNode>> addFilter(){
        return new ArrayList<>();

    }
}

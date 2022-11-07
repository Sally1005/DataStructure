package com.lonton.dao;

import com.lonton.tree.pojo.TreeNode;
import com.lonton.utils.ToolDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;
/**
 * 节点DAO层
 *
 * @author 张利红
 * date:2022-11-07
 */
public class NodeDao {
    private final QueryRunner queryRunner = new QueryRunner();

    //查询多行
    private List<TreeNode> queryMulti(String sql, Class<TreeNode> tClass, Object... parameters) {
        Connection connection = null;
        try {
            connection = ToolDruid.connect();

            List<TreeNode> list = queryRunner.query(connection, sql, new BeanListHandler<TreeNode>(tClass), parameters);
            return list;
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        } finally {
            ToolDruid.close(null, null, connection);
        }
    }

    public List<TreeNode> getNodeList() {
        return this.queryMulti("select * from fruit", TreeNode.class);
    }


}

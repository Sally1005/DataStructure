package com.lonton.dao;

import com.lonton.utils.ToolDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

/**
 *开发BasicDao，作为其他Dao的父类
 * @author 张利红
 */
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 返回多个对象（即查询的结果是多行的）
     * @param sql SQL语句，可以有 ?
     * @param tClass 传入一个类的 Class 对象
     * @param parameters 传入 ? 的具体值，可以有多个
     * @return 根据 Node.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> tClass, Object... parameters) {
        Connection connection = null;
        try {
            connection = ToolDruid.connect();
            List<T> list = queryRunner.query(connection, sql, new BeanListHandler<>(tClass), parameters);
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e); // 将编译异常转为运行异常
        } finally {
            ToolDruid.close(null, null, connection);
        }

    }

}

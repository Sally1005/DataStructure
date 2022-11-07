package com.lonton.binaryTree.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *数据库连接池
 *
 * @author 张利红
 * date:2022-11-07
 */
@Slf4j
public class ToolDruid {
    private static DataSource dataSource;

    static { // 在静态代码块中对dataSource进行初始化
        Properties properties = new Properties();
        properties.put("driverClassName","com.mysql.cj.jdbc.Driver");
        properties.put("url","jdbc:mysql://localhost:3306/tree?serverTimezone=UTC&rewriteBatchedStatements=true");
        properties.put("username","root");
        properties.put("password","root");
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            log.error("获取连接池对象失败");
        }
    }

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            log.error("数据库连接异常");
        }
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }


}

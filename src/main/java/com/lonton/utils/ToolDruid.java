package com.lonton.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接池
 * @author 张利红
 */
public class ToolDruid {
    private static DataSource dataSource;
    static { // 在静态块中完成对 DataSource 的初始化
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src//druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection connect() { // 获取 Connection 连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(ResultSet resultSet, Statement statement, Connection connection) { // 放回连接
        try { // 判断是否为空
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

package com.lonton.binarytree.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.util.List;


/**
 * Mybatis的配置类
 * <p/>
 * @author 张利红
 */
@Slf4j
@Configuration
@MapperScan("com.lonton.binarytree.mapper")
public class MybatisConfig {

    public MybatisConfig() {
        log.info("加载配置类：MybatisConfiguration");
    }

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;


}

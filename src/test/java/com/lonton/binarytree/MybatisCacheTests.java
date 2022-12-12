package com.lonton.binarytree;

import com.lonton.binarytree.mapper.TreeNodeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Mybatis单元测试
 * <p/>
 * @author 张利红
 */
@Slf4j
@SpringBootTest
public class MybatisCacheTests {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    void testCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TreeNodeMapper treeNodeMapper = sqlSession.getMapper(TreeNodeMapper.class);
        log.debug("执行查询……");
        treeNodeMapper.list();}
}

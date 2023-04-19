
# data-structure [![Junit](https://github.com/Sally1005/data-structure/actions/workflows/workflow.yml/badge.svg?event=push)](https://github.com/Sally1005/data-structure/actions/workflows/workflow.yml)  [![codecov](https://codecov.io/gh/Sally1005/data-structure/graph/badge.svg)](https://codecov.io/gh/Sally1005/data-structure)
 ![Checkstyle](https://img.shields.io/badge/Checkstyle-passing-brightgreen)





# 项目介绍

该工程是一个springboot工程项目。主要是练习数据结构中的树。包括二叉树的递归遍历和非递归遍历，以及查找树、打印树、计算树高、计算节点等。<br/>
同时，还包括对力扣网上题目的一些练习，由于能力有限，主要集中在简单和中等题型。以下是LeetCode个人页链接：<https://leetcode.cn/u/cool-hawking8aq/>
                      

# 目录结构

```          
├─assets
│     └─database                            数据资源
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─lonton
│  │  │          └─leetcode                 力扣网刷题
│  │  │          │  ├─easy
│  │  │          │  ├─hard
│  │  │          │  └─med
│  │  │          └─binaryTree
│  │  │                  ├─impl             实现类
│  │  │                  ├─mapper           mapper
│  │  │                  ├─pojo             实体类
│  │  │                  ├─utils            工具包
│  │  │                  ├─AVistitor        访问抽象类
│  │  │                  ├─ITraverser       遍历接口     
│  │  │                  ├─IVisitor         二叉树访问数据接口
│  │  │                  └─TreeApplication  启动项                                      
│  │  └─resources                           mapper.xml文件及一些配置
│  │        └─mapper                         
│  │                            
│  └─test                                   leetcode及binaryTree包下的测试  
└─.gitigore                                 忽略文件
└─ pom.xml                                  Maven配置

```








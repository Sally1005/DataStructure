
-- 删表如果存在fruit表
DROP TABLE IF EXISTS fruit;

-- 水果表：创建数据表
CREATE TABLE fruit (
                         id INT(11) NOT NULL AUTO_INCREMENT,
                         data VARCHAR(20) DEFAULT NULL COMMENT '当前节点',
                         is_left INT(11)  DEFAULT 1 COMMENT '左子节点',
                         level INT(11)  DEFAULT NULL COMMENT '当前节点层级',
                         parent_id INT(11)  DEFAULT NULL COMMENT '父节点id',
                         PRIMARY KEY (id)
) COMMENT '水果表' CHARSET utf8mb4;
-- 水果表：插入测试数据
INSERT INTO fruit VALUES (1, '水果', 0, 1, 0);
INSERT INTO fruit VALUES (2, '柑橘类', 1, 2, 1);
INSERT INTO fruit VALUES (3, '瓜果类', 0, 2, 1);
INSERT INTO fruit VALUES (4, '橙子', 1, 3, 2);
INSERT INTO fruit VALUES (5, '沃柑', 0, 3, 2);
INSERT INTO fruit VALUES (6, '西瓜', 1, 3, 3);
INSERT INTO fruit VALUES (7, '哈密瓜', 0, 3, 3);



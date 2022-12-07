/*删表如果存在fruit表*/
DROP TABLE IF EXISTS `fruit`;
/*重新建表，添加表字段*/
CREATE TABLE `fruit` (
                         `id` INT(11) NOT NULL,
                         `data` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `left_node` INT(11) NULL DEFAULT NULL,
                         `right_node` INT(11) NULL DEFAULT NULL,
                         `level` INT(11) NULL DEFAULT NULL,
                         `parent_id` INT(11) NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE ) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;
/*插入数据*/
INSERT INTO `fruit` VALUES (1, '水果', 2,3,1,0);
INSERT INTO `fruit` VALUES (2, '柑橘类', 4,5,2, 1);
INSERT INTO `fruit` VALUES (3, '瓜果类', 6,7,2,1);
INSERT INTO `fruit` VALUES (4, '橙子', NULL, NULL,3, 2);
INSERT INTO `fruit` VALUES (5, '沃柑', NULL, NULL,3, 2);
INSERT INTO `fruit` VALUES (6, '西瓜',NULL, NULL,3, 3);
INSERT INTO `fruit` VALUES (7, '哈密瓜', NULL, NULL,3, 3);
SET FOREIGN_KEY_CHECKS = 1;

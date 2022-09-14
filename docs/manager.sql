/*
 Navicat Premium Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : 192.168.1.6:3306
 Source Schema         : manager

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 13/09/2022 20:31:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `unique_id` bigint(20) NOT NULL COMMENT 'user唯一id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '用户删除标记 0(FALSE)：用户启用 1(TRUE)：用户禁用 默认 0(FALSE)',
  `insert` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `update` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_extends
-- ----------------------------
DROP TABLE IF EXISTS `user_extends`;
CREATE TABLE `user_extends`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `unique_id` bigint(20) NOT NULL COMMENT '用户唯一id',
  `field` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '拓展字段',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拓展字段值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

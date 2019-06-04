/*
 Navicat Premium Data Transfer

 Source Server         : 101.132.108.4
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 101.132.108.4:3306
 Source Schema         : seat_select

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 04/06/2019 14:38:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ss_seats
-- ----------------------------
DROP TABLE IF EXISTS `ss_seats`;
CREATE TABLE `ss_seats` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `x` int(11) DEFAULT NULL COMMENT 'X坐标',
  `y` int(11) DEFAULT NULL COMMENT 'Y坐标',
  `row` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '排',
  `col` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `type` varchar(24) DEFAULT NULL COMMENT '对应seat_type表中的id',
  `flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '预留标示位 0位有效 1为无效',
  `templete_id` int(11) DEFAULT NULL COMMENT '对应模版id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `templete_index` (`templete_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3723 DEFAULT CHARSET=utf8 COMMENT='座位表';

SET FOREIGN_KEY_CHECKS = 1;

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

 Date: 04/06/2019 14:40:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ss_seat_templete
-- ----------------------------
DROP TABLE IF EXISTS `ss_seat_templete`;
CREATE TABLE `ss_seat_templete` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) DEFAULT NULL COMMENT '模版名称',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `flag` char(1) DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='座位模版表';

SET FOREIGN_KEY_CHECKS = 1;

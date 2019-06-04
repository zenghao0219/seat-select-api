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

 Date: 04/06/2019 14:46:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ss_seat_type
-- ----------------------------
DROP TABLE IF EXISTS `ss_seat_type`;
CREATE TABLE `ss_seat_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(24) DEFAULT NULL COMMENT '座位类型',
  `name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标地址',
  `is_show` char(1) DEFAULT NULL COMMENT '是否展示在移动端',
  `position` varchar(10) DEFAULT NULL COMMENT '展示在移动端上方还是下方',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='座位类型表';

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : echarts
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-08-23 12:12:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for keys
-- ----------------------------
DROP TABLE IF EXISTS `keys`;
CREATE TABLE `keys` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `name` varchar(255) NOT NULL COMMENT '店铺名称',
  `url` varchar(255) NOT NULL COMMENT '商铺URL',
  `type` varchar(255) NOT NULL COMMENT '商铺类型',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

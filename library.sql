/*
Navicat MySQL Data Transfer

Source Server         : s
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-11-22 22:31:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` bigint(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(50) NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for book_borrow
-- ----------------------------
DROP TABLE IF EXISTS `book_borrow`;
CREATE TABLE `book_borrow` (
  `borrowid` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookid` varchar(255) NOT NULL,
  `userid` varchar(255) NOT NULL,
  `borrowdate` date DEFAULT NULL,
  `returndate` date DEFAULT NULL,
  `borrowstate` varchar(255) NOT NULL,
  PRIMARY KEY (`borrowid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hotgoods
-- ----------------------------
DROP TABLE IF EXISTS `hotgoods`;
CREATE TABLE `hotgoods` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `styleNumber` varchar(255) NOT NULL COMMENT '款号',
  `datatime` varchar(255) NOT NULL COMMENT '日期（到日）',
  `pictureUrl` varchar(255) DEFAULT NULL COMMENT '图片url',
  `tagPrice` int(11) DEFAULT NULL COMMENT '吊牌价',
  `Newquotation` int(11) DEFAULT NULL COMMENT '上新价',
  `discount` varchar(255) DEFAULT NULL COMMENT '折扣',
  `fabric` varchar(255) DEFAULT NULL COMMENT '面料',
  `typeVersion` varchar(255) DEFAULT NULL COMMENT '版型',
  `year` varchar(255) DEFAULT NULL COMMENT '年份',
  `season` varchar(255) DEFAULT NULL COMMENT '季节',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `productLine` varchar(255) DEFAULT NULL COMMENT '产品线',
  `flow` int(11) DEFAULT NULL COMMENT '流量',
  `plus` int(11) DEFAULT NULL COMMENT '加购',
  `money` int(11) DEFAULT NULL COMMENT '金额',
  `purchaseRate` varchar(255) DEFAULT NULL COMMENT '加购率',
  `conversion` varchar(255) DEFAULT NULL COMMENT '转化率',
  `price` int(11) DEFAULT NULL COMMENT '单价',
  `payment` int(11) DEFAULT NULL COMMENT '支付',
  `category` varchar(255) DEFAULT NULL COMMENT '品类',
  PRIMARY KEY (`id`,`styleNumber`,`datatime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for permissionmodel
-- ----------------------------
DROP TABLE IF EXISTS `permissionmodel`;
CREATE TABLE `permissionmodel` (
  `permissionid` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) NOT NULL COMMENT '权限',
  `description` varchar(255) NOT NULL COMMENT '描述',
  PRIMARY KEY (`permissionid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rolemodel
-- ----------------------------
DROP TABLE IF EXISTS `rolemodel`;
CREATE TABLE `rolemodel` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'roleid',
  `role` varchar(255) NOT NULL COMMENT '角色',
  `description` varchar(255) NOT NULL COMMENT '描述',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rolepermissionmodel
-- ----------------------------
DROP TABLE IF EXISTS `rolepermissionmodel`;
CREATE TABLE `rolepermissionmodel` (
  `roleid` int(11) NOT NULL COMMENT 'roleid',
  `permissionid` int(11) NOT NULL COMMENT 'permissionid',
  PRIMARY KEY (`roleid`,`permissionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shengecanmou
-- ----------------------------
DROP TABLE IF EXISTS `shengecanmou`;
CREATE TABLE `shengecanmou` (
  `recordtime` date NOT NULL COMMENT '记录日期',
  `id` varchar(255) NOT NULL COMMENT '商品ID',
  `title` varchar(255) NOT NULL COMMENT '商品标题',
  `terminal` varchar(255) NOT NULL COMMENT '所属终端',
  `state` varchar(255) NOT NULL COMMENT '商品在线状态',
  `url` varchar(255) NOT NULL COMMENT '商品连接',
  `views` varchar(255) NOT NULL COMMENT '浏览量',
  `visitors` varchar(255) NOT NULL COMMENT '访客数',
  `staytime` varchar(255) NOT NULL COMMENT '平均停留时长',
  `detailspage` varchar(255) NOT NULL COMMENT '详情页跳出率',
  `orderconrate` varchar(255) NOT NULL COMMENT '下单转化率',
  `payconrate` varchar(255) NOT NULL COMMENT '支付转化率',
  `payamount` varchar(255) NOT NULL COMMENT '支付金额',
  `paygoods` varchar(255) NOT NULL COMMENT '支付商品件数',
  `paybuyers` varchar(255) NOT NULL COMMENT '支付买家数',
  `orderpayconrate` varchar(255) NOT NULL COMMENT '下单支付转化率',
  `ordergoods` varchar(255) NOT NULL COMMENT '下单金额',
  `orderamount` varchar(255) NOT NULL COMMENT '下单商品件数',
  `orderbuyers` varchar(255) NOT NULL COMMENT '下单买家数',
  `purchase` varchar(255) NOT NULL COMMENT '加购件数',
  `visitorsvalue` varchar(255) NOT NULL COMMENT '访客平均价值',
  `clicktimes` varchar(255) NOT NULL COMMENT '点击次数',
  `clickrate` varchar(255) NOT NULL COMMENT '点击率',
  `exposure` varchar(255) NOT NULL COMMENT '曝光率',
  `collection` varchar(255) NOT NULL COMMENT '收藏人数',
  `unitprice` varchar(255) NOT NULL COMMENT '客单价',
  `searchpay` varchar(255) NOT NULL COMMENT '搜索支付转化率',
  `searchbuyers` varchar(255) NOT NULL COMMENT '搜索引导支付买家数',
  `searchvisitors` varchar(255) NOT NULL COMMENT '搜索引导访客数',
  `refundamount` varchar(255) NOT NULL COMMENT '售中售后成功退款金额',
  `refundnumbers` varchar(255) NOT NULL COMMENT '售中售后成功退款笔数',
  PRIMARY KEY (`recordtime`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shengejing
-- ----------------------------
DROP TABLE IF EXISTS `shengejing`;
CREATE TABLE `shengejing` (
  `id` varchar(255) NOT NULL COMMENT '商品ID',
  `name` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `hotword` varchar(255) DEFAULT NULL COMMENT '热搜词',
  `pc` varchar(255) DEFAULT NULL COMMENT 'PC流量',
  `app` varchar(255) DEFAULT NULL COMMENT '手淘流量',
  `shop` varchar(255) NOT NULL COMMENT '店铺名称',
  `code` varchar(255) DEFAULT NULL COMMENT '商家编码',
  `type` varchar(255) DEFAULT NULL COMMENT '行业类目',
  `uptime` datetime DEFAULT NULL COMMENT '上架时间',
  `recordtime` datetime NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`,`shop`,`recordtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for taobaoshop
-- ----------------------------
DROP TABLE IF EXISTS `taobaoshop`;
CREATE TABLE `taobaoshop` (
  `shop` varchar(255) NOT NULL COMMENT '店铺',
  `URL` varchar(255) NOT NULL COMMENT '商品URL',
  `ID` varchar(255) NOT NULL COMMENT '商品ID',
  `totalSale` varchar(255) NOT NULL COMMENT '总销量',
  `tPrice` varchar(255) NOT NULL COMMENT '价格',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `pic` varchar(255) NOT NULL COMMENT '图片',
  `brand` varchar(255) NOT NULL COMMENT '品牌',
  `material` varchar(255) NOT NULL COMMENT '材质成分',
  `season` varchar(255) NOT NULL COMMENT '季节',
  `color` varchar(255) NOT NULL COMMENT '颜色',
  `sex` varchar(255) NOT NULL COMMENT '性别',
  `fabric` varchar(255) NOT NULL COMMENT '面料',
  `style` varchar(255) NOT NULL COMMENT '风格',
  `paint` varchar(255) NOT NULL COMMENT '图案',
  `huohao` varchar(255) NOT NULL COMMENT '货号',
  `qudao` varchar(255) NOT NULL COMMENT '渠道',
  `oPrice` varchar(255) NOT NULL COMMENT '原价',
  `sizeColor` varchar(255) NOT NULL COMMENT '色码',
  `SKU` varchar(255) NOT NULL COMMENT '商品SKU',
  `stock` varchar(255) NOT NULL COMMENT '库存',
  `recordTime` datetime NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`SKU`,`recordTime`,`shop`,`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint(11) NOT NULL AUTO_INCREMENT,
  `userpassword` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `userclass` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for usermodel
-- ----------------------------
DROP TABLE IF EXISTS `usermodel`;
CREATE TABLE `usermodel` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userid',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `userpassword` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT 'salt',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userrolemodel
-- ----------------------------
DROP TABLE IF EXISTS `userrolemodel`;
CREATE TABLE `userrolemodel` (
  `userid` int(11) NOT NULL COMMENT 'userid',
  `roleid` int(11) NOT NULL COMMENT 'roleid',
  PRIMARY KEY (`userid`,`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

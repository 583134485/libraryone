/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-06-03 12:06:09
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('0', '交流空间链');
INSERT INTO `book` VALUES ('1', '9999');
INSERT INTO `book` VALUES ('2', '哈哈');
INSERT INTO `book` VALUES ('3', '东风公司');
INSERT INTO `book` VALUES ('5', '西游士大夫');
INSERT INTO `book` VALUES ('7', '');
INSERT INTO `book` VALUES ('8', 'dfg ');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_borrow
-- ----------------------------
INSERT INTO `book_borrow` VALUES ('3', '1', '2', '2017-06-01', '2017-06-07', '6');
INSERT INTO `book_borrow` VALUES ('4', '100', '55', '2017-06-03', '2017-06-03', '44');
INSERT INTO `book_borrow` VALUES ('5', '2', '2', '2017-05-05', '2017-06-10', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'ddd', '第三方', '啊阿三大树');
INSERT INTO `user` VALUES ('3', 'sad', 'asd', 'ads');
INSERT INTO `user` VALUES ('5', 'abc', '付哦小', 'bc');
INSERT INTO `user` VALUES ('6', 'fff', 'sssss', 'class1');
INSERT INTO `user` VALUES ('7', 'fff', 'sssss', 'class1');
INSERT INTO `user` VALUES ('8', 'fff', 'sssss', 'class1');
INSERT INTO `user` VALUES ('9', 'fff', '渣渣', 'class1');
INSERT INTO `user` VALUES ('10', 'fff', '渣渣炸', 'class1');
INSERT INTO `user` VALUES ('11', 'fff', 'sdf a', 'class1');
INSERT INTO `user` VALUES ('13', 'sdfsa', 'sda', 'sfdasf');

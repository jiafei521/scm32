/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : scm

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2016-08-11 22:45:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `sys_param_id` bigint(20) NOT NULL auto_increment,
  `sys_param_field` varchar(50) default NULL,
  `sys_param_value` varchar(100) default NULL,
  `sys_param_text` varchar(50) default NULL,
  `sys_param_type` int(11) default NULL,
  PRIMARY KEY  (`sys_param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('1', 'supType', '1', '一级供应商', null);
INSERT INTO `sys_param` VALUES ('2', 'supType', '2', '二级供应商', null);
INSERT INTO `sys_param` VALUES ('3', 'supType', '3', '普通供应商', null);
INSERT INTO `sys_param` VALUES ('4', 'goodsColor', '1', '红色', null);
INSERT INTO `sys_param` VALUES ('5', 'goodsColor', '2', '绿色', null);
INSERT INTO `sys_param` VALUES ('6', 'goodsColor', '3', '蓝色', null);
INSERT INTO `sys_param` VALUES ('7', 'shId', 'select s.sh_id as sys_param_value,s.sh_name as sys_param_text from store_house s', null, '1');

/*
Navicat MySQL Data Transfer

Source Server         : TTT
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : boss

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-03-21 18:11:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `name` varchar(255) DEFAULT '' COMMENT '部门名称',
  `dept_desc` varchar(255) DEFAULT '' COMMENT '部门描述',
  `parent_id` int(11) DEFAULT NULL COMMENT '父部门编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '总裁办', '总裁办', '0');
INSERT INTO `t_dept` VALUES ('2', '人事部', '人事部', '1');
INSERT INTO `t_dept` VALUES ('3', '市场部', '市场管理部', '1');

-- ----------------------------
-- Table structure for t_function
-- ----------------------------
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `functionCode` varchar(50) DEFAULT NULL COMMENT '权限编码',
  `functionName` varchar(255) DEFAULT NULL COMMENT '权限名字',
  `parentId` int(11) DEFAULT NULL COMMENT '父权限ID',
  `type` int(2) DEFAULT NULL COMMENT '权限类型',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('1', 'M1', '系统设置', '0', '0', '1', '1', null, '2019-03-21 14:01:34', null);
INSERT INTO `t_function` VALUES ('2', 'A1', '新增用户', '3', '2', '1', '1', null, '2019-03-21 14:02:21', null);
INSERT INTO `t_function` VALUES ('3', 'R1', '用户管理', '1', '1', '1', '1', null, '2019-03-21 14:02:45', null);
INSERT INTO `t_function` VALUES ('4', 'UQ1', '用户查询', '3', '2', '1', '1', null, '2019-03-21 16:43:45', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(2) DEFAULT NULL COMMENT '角色状态',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '系统超级管理员', '1', '1', null, '2019-03-21 14:00:40', null);
INSERT INTO `t_role` VALUES ('2', '用户管理员', '用户操作管理员', '1', '1', null, '2019-03-21 14:03:39', null);

-- ----------------------------
-- Table structure for t_role_function
-- ----------------------------
DROP TABLE IF EXISTS `t_role_function`;
CREATE TABLE `t_role_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleID` int(11) DEFAULT NULL COMMENT '用户ID',
  `functionID` int(11) DEFAULT NULL COMMENT '角色ID',
  `status` int(2) DEFAULT NULL COMMENT '状态(0失效1可用)',
  `isActice` int(2) DEFAULT NULL COMMENT '是否可用',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_function
-- ----------------------------
INSERT INTO `t_role_function` VALUES ('1', '1', '1', '1', '1', '1', null, '2019-03-21 14:01:51', null);
INSERT INTO `t_role_function` VALUES ('2', '2', '1', '1', '1', '1', null, '2019-03-21 14:03:57', null);
INSERT INTO `t_role_function` VALUES ('3', '2', '3', '1', '1', '1', null, '2019-03-21 14:07:22', null);
INSERT INTO `t_role_function` VALUES ('4', '1', '2', '1', '1', '1', null, '2019-03-21 16:03:22', null);
INSERT INTO `t_role_function` VALUES ('5', '1', '3', '1', '1', '1', null, '2019-03-21 16:03:45', null);
INSERT INTO `t_role_function` VALUES ('6', '1', '4', '1', '1', '1', null, '2019-03-21 16:43:58', null);
INSERT INTO `t_role_function` VALUES ('7', '2', '2', '1', '1', '1', null, '2019-03-21 17:00:50', null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(65) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(18) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `job_mo` varchar(18) DEFAULT NULL COMMENT '工号',
  `work_place` varchar(30) DEFAULT NULL COMMENT '工作地点',
  `deptId` varchar(50) DEFAULT NULL COMMENT '部门',
  `status` int(1) DEFAULT NULL COMMENT '员工状态',
  `in_time` timestamp NULL DEFAULT NULL COMMENT '入职时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_username` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '超管', '1', '17621101265', '17621101265@163.com', '10001', '河南省郑州市摩根居易中心', '1', '1', '2019-03-18 08:30:00', '1', null, '2019-03-21 14:00:11', null);
INSERT INTO `t_user` VALUES ('2', 'yixiaobai', 'E10ADC3949BA59ABBE56E057F20F883E', '易小白', '1', '17621101265', '17621101265@163.com', '10001', '河南省郑州市摩根居易中心', '2', '1', '2019-03-18 08:30:00', '1', null, '2019-03-21 14:04:57', null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userID` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleID` int(11) DEFAULT NULL COMMENT '角色ID',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `isActice` int(2) DEFAULT NULL COMMENT '是否可用',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '1', '1', '1', null, '2019-03-21 14:01:45', null);
INSERT INTO `t_user_role` VALUES ('2', '2', '2', '1', '1', '1', null, '2019-03-21 14:06:59', null);

-- ----------------------------
-- View structure for v_user_role_function
-- ----------------------------
DROP VIEW IF EXISTS `v_user_role_function`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_user_role_function` AS SELECT
	u.id AS userID,
	u.user_name AS userName,
	u. PASSWORD AS `password`,
	u.deptId AS deptId,
	d.`name` AS deptName,
	r.id AS roleID,
	r.role_name AS roleName,
	f.functionCode AS functionCode,
	f.functionName AS functionName,
	f.id AS functionId,
	f.parentId AS parentId,
	f.type AS type
FROM
	t_user u
LEFT JOIN t_user_role ur ON (u.id = ur.userId AND ur.`status` = 1)
LEFT JOIN t_role r ON (ur.roleID = r.id and r.`status` = 1)
LEFT JOIN t_role_function rf ON (rf.roleID = r.id AND rf.`status` = 1)
LEFT JOIN t_function f ON (f.id = rf.functionID AND f.`status` = 1)
LEFT JOIN t_dept d ON d.id = u.deptId ;

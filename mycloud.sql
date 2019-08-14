/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : mycloud

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 14/08/2019 16:08:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `realname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '真实姓名',
  `lock` int(1) NOT NULL DEFAULT 0 COMMENT '状态（0启用，1锁定）',
  `sex` int(1) NOT NULL COMMENT '性别（0男，1女）',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `level` int(1) NOT NULL DEFAULT 2 COMMENT '账号等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '张三', 0, 0, 'admin@qq.com', '13555555555', '2019-08-12 16:35:57', '2019-08-12 16:35:57', 1);

-- ----------------------------
-- Table structure for user_account_role
-- ----------------------------
DROP TABLE IF EXISTS `user_account_role`;
CREATE TABLE `user_account_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL COMMENT '账号ID',
  `rid` int(11) NOT NULL COMMENT '角色ID',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of user_account_role
-- ----------------------------
INSERT INTO `user_account_role` VALUES (1, 1, 1, '2019-08-13 10:08:11', '2019-08-13 10:08:11');
INSERT INTO `user_account_role` VALUES (2, 2, 2, '2019-08-13 10:48:02', '2019-08-13 10:48:02');

-- ----------------------------
-- Table structure for user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `user_permissions`;
CREATE TABLE `user_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL DEFAULT 0 COMMENT '父权限ID',
  `type` int(1) NOT NULL DEFAULT 1 COMMENT '权限类型  1、分类，2、权限',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '权限名称',
  `resource` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '资源编码',
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求方法',
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求地址',
  `describes` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `level` int(1) NOT NULL DEFAULT 2 COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_permissions
-- ----------------------------
INSERT INTO `user_permissions` VALUES (1, 0, 1, '用户管理', '', '', '', '', '2019-08-12 18:05:34', '2019-08-12 18:05:34', 1);
INSERT INTO `user_permissions` VALUES (2, 1, 2, '添加用户', 'account:add', 'POST', '/account/add', '添加用户', '2019-08-12 18:05:40', '2019-08-12 18:05:40', 1);
INSERT INTO `user_permissions` VALUES (3, 1, 2, '修改用户', 'account:upd', 'PUT', '/account/upd', '修改用户', '2019-08-12 18:06:06', '2019-08-12 18:06:06', 1);
INSERT INTO `user_permissions` VALUES (4, 1, 2, '批量删除用户', 'account:del', 'DELETE', '/account/del', '批量删除用户', '2019-08-12 18:06:51', '2019-08-12 18:06:51', 1);
INSERT INTO `user_permissions` VALUES (5, 1, 2, '根据ID获取用户', 'account:get', 'GET', '/account/get', '根据ID获取用户', '2019-08-12 18:07:17', '2019-08-12 18:07:17', 1);
INSERT INTO `user_permissions` VALUES (6, 1, 2, '用户列表（分页）', 'account:list', 'GET', '/account/list', '用户列表（分页）', '2019-08-12 18:07:37', '2019-08-12 18:07:37', 1);
INSERT INTO `user_permissions` VALUES (7, 1, 2, '批量修改账号状态', 'account:lock', 'PATCH', '/account/lock', '批量修改账号状态', '2019-08-12 18:11:51', '2019-08-12 18:11:51', 1);
INSERT INTO `user_permissions` VALUES (8, 0, 1, '角色管理', '', '', '', '', '2019-08-12 18:12:12', '2019-08-12 18:12:12', 1);
INSERT INTO `user_permissions` VALUES (9, 8, 2, '添加角色', 'role:add', 'POST', '/role/add', '添加角色', '2019-08-12 18:12:47', '2019-08-12 18:12:47', 1);
INSERT INTO `user_permissions` VALUES (10, 8, 2, '根据ID修改角色', 'role:upd', 'PUT', '/role/upd', '根据ID修改角色', '2019-08-12 18:13:25', '2019-08-12 18:13:25', 1);
INSERT INTO `user_permissions` VALUES (11, 8, 2, '根据ID批量删除角色', 'role:del', 'DELETE', '/role/del', '根据ID批量删除角色', '2019-08-12 18:13:47', '2019-08-12 18:13:47', 1);
INSERT INTO `user_permissions` VALUES (12, 8, 2, '根据ID查找角色', 'role:get', 'GET', '/role/get', '根据ID查找角色', '2019-08-12 18:14:22', '2019-08-12 18:14:22', 1);
INSERT INTO `user_permissions` VALUES (13, 8, 2, '列表（分页）', 'role:list', 'GET', '/role/list', '列表（分页）', '2019-08-12 18:14:41', '2019-08-12 18:14:41', 1);
INSERT INTO `user_permissions` VALUES (14, 0, 1, '权限管理', '', '', '', '', '2019-08-12 18:15:21', '2019-08-12 18:15:21', 1);
INSERT INTO `user_permissions` VALUES (15, 14, 2, '添加权限', 'permission:add', 'POST', '/permission/add', '添加权限', '2019-08-12 18:15:59', '2019-08-12 18:15:59', 1);
INSERT INTO `user_permissions` VALUES (16, 14, 2, '根据ID修改权限', 'permission:upd', 'PATCH', '/permission/upd', '根据ID修改权限', '2019-08-12 18:16:17', '2019-08-12 18:16:17', 1);
INSERT INTO `user_permissions` VALUES (17, 14, 2, '根据ID批量删除权限', 'permission:del', 'DELETE', '/permission/del', '根据ID批量删除权限', '2019-08-12 18:16:38', '2019-08-12 18:16:38', 1);
INSERT INTO `user_permissions` VALUES (18, 14, 2, '根据ID获取权限', 'permission:get', 'GET', '/permission/get', '根据ID获取权限', '2019-08-12 18:17:00', '2019-08-12 18:17:00', 1);
INSERT INTO `user_permissions` VALUES (19, 14, 2, '列表（分页）', 'permission:list', 'GET', '/permission/list', '列表（分页）', '2019-08-12 18:17:20', '2019-08-12 18:17:20', 1);
INSERT INTO `user_permissions` VALUES (20, 14, 2, '根据类型查找数据（分页）', 'permission:list:type', 'GET', '/permission/list/type', '根据类型查找数据（分页）', '2019-08-13 09:41:25', '2019-08-13 09:41:25', 1);
INSERT INTO `user_permissions` VALUES (21, 14, 2, '根据ID查找子类数据（分页）', 'permission:list:pid', 'GET', '/permission/list/pid', '根据ID查找子类数据（分页）', '2019-08-13 09:41:42', '2019-08-13 09:41:42', 1);
INSERT INTO `user_permissions` VALUES (22, 1, 2, '给用户添加角色', 'account:add:role', 'POST', '/account/add/role', '给用户添加角色', '2019-08-13 10:10:13', '2019-08-13 10:10:13', 1);
INSERT INTO `user_permissions` VALUES (23, 1, 2, '根据ID批量删除用户的角色', 'account:del:role', 'DELETE', '/account/del/role', '根据ID批量删除用户的角色', '2019-08-13 10:11:10', '2019-08-13 10:11:10', 1);
INSERT INTO `user_permissions` VALUES (24, 8, 2, '根据ID批量删除角色的权限', 'role:del:permission', 'DELETE', '/role/del/permission', '根据ID批量删除角色的权限', '2019-08-13 10:39:28', '2019-08-13 10:39:28', 1);
INSERT INTO `user_permissions` VALUES (25, 8, 2, '批量给角色添加权限', 'role:add:permission', 'POST', '/role/add/permission', '批量给角色添加权限', '2019-08-13 10:39:51', '2019-08-13 10:39:51', 1);
INSERT INTO `user_permissions` VALUES (26, 8, 2, '获取所有的角色', 'role:list:all', 'GET', '/list/all', '获取所有的角色', '2019-08-14 15:27:44', '2019-08-14 15:27:44', 1);
INSERT INTO `user_permissions` VALUES (27, 8, 2, '根据ID获取用户的角色', 'role:list:aid', 'GET', '/list/aid', '根据ID获取用户的角色', '2019-08-14 15:28:59', '2019-08-14 15:28:59', 1);
INSERT INTO `user_permissions` VALUES (28, 14, 2, '获取所有权限', 'permission:list:all', 'GET', '/list/all', '获取所有权限', '2019-08-14 15:52:57', '2019-08-14 15:52:57', 1);
INSERT INTO `user_permissions` VALUES (29, 14, 2, '获取某角色的所有权限', 'permission:list:rid', 'GET', '/list/rid/{rid}', '获取某角色的所有权限', '2019-08-14 15:53:30', '2019-08-14 15:53:30', 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `lock` int(1) NOT NULL DEFAULT 0 COMMENT '状态（0启用，1锁定）',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `level` int(1) NOT NULL DEFAULT 2 COMMENT '角色等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '管理员', 'admin', 0, '2019-08-12 17:24:02', '2019-08-12 17:24:02', 1);

-- ----------------------------
-- Table structure for user_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `user_role_permissions`;
CREATE TABLE `user_role_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL COMMENT '权限ID',
  `rid` int(11) NOT NULL COMMENT '角色ID',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of user_role_permissions
-- ----------------------------
INSERT INTO `user_role_permissions` VALUES (1, 2, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (2, 3, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (3, 4, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (4, 5, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (5, 6, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (6, 7, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (7, 9, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (8, 10, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (9, 11, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (10, 12, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (11, 13, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (12, 15, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (13, 16, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (14, 17, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (15, 18, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (16, 19, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (17, 20, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (18, 21, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (19, 22, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (20, 23, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (21, 24, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (22, 25, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (23, 26, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (24, 27, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (25, 28, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');
INSERT INTO `user_role_permissions` VALUES (26, 29, 1, '2019-08-13 10:40:19', '2019-08-13 10:40:19');

SET FOREIGN_KEY_CHECKS = 1;

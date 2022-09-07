/*
 Navicat Premium Data Transfer

 Source Server         : mysql_localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/09/2022 16:17:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_image_relation
-- ----------------------------
DROP TABLE IF EXISTS `app_image_relation`;
CREATE TABLE `app_image_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '关联图片id',
  `relation_id` int(0) NOT NULL COMMENT '关联应用id',
  `image_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片链接',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名称',
  `apply_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '应用类型，10说说',
  `deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_image_relation
-- ----------------------------
INSERT INTO `app_image_relation` VALUES (3, 2, 'http://baidu.com', '1', '10', '0', '2022-08-30 14:17:01');
INSERT INTO `app_image_relation` VALUES (4, 2, 'http://codewolf.com', '2', '10', '0', '2022-08-30 14:17:01');
INSERT INTO `app_image_relation` VALUES (5, 1, 'tt1', '3', '10', '0', '2022-08-30 16:24:56');
INSERT INTO `app_image_relation` VALUES (6, 1, 'tt22', '4', '10', '0', '2022-08-30 16:24:56');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `user_id` int(0) NOT NULL COMMENT '作者用户id',
  `category_id` int(0) NOT NULL COMMENT '分类id',
  `article_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `article_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章缩略图',
  `article_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
  `article_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章类型，1：原创，2：转载，3：翻译',
  `origin_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '原文链接',
  `is_top` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '置顶状态：1置顶，0否',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态1：公开，2：私密，3：草稿',
  `deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除，0没有删除1：删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (8, 2, 5, '测试123', '测试123', '测试123', '1', '', '1', '1', '0', '2022-08-17 14:17:37', NULL);
INSERT INTO `article` VALUES (9, 2, 5, '测试123', '测试123', '测试123', '1', '', '1', '1', '0', '2022-08-17 14:17:39', NULL);
INSERT INTO `article` VALUES (10, 2, 5, '测试123', '测试123', '测试123', '1', '', '1', '1', '0', '2022-08-17 14:17:40', NULL);
INSERT INTO `article` VALUES (11, 2, 5, '测试123', '测试123', '测试123', '1', '', '1', '1', '0', '2022-08-17 14:17:41', NULL);
INSERT INTO `article` VALUES (12, 2, 5, '测试123', '测试123', '测试123', '1', '', '1', '1', '0', '2022-08-17 14:20:02', NULL);

-- ----------------------------
-- Table structure for article_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `article_tag_relation`;
CREATE TABLE `article_tag_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章标签关联id',
  `article_id` int(0) NOT NULL COMMENT '文章id',
  `tag_id` int(0) NOT NULL COMMENT '标签id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag_relation
-- ----------------------------
INSERT INTO `article_tag_relation` VALUES (1, 3, 3, '2022-08-11 15:09:07');
INSERT INTO `article_tag_relation` VALUES (2, 4, 3, '2022-08-11 15:09:45');
INSERT INTO `article_tag_relation` VALUES (5, 7, 3, '2022-08-11 15:09:47');
INSERT INTO `article_tag_relation` VALUES (6, 5, 4, '2022-08-12 10:16:52');
INSERT INTO `article_tag_relation` VALUES (7, 6, 4, '2022-08-12 16:22:28');
INSERT INTO `article_tag_relation` VALUES (8, 6, 5, '2022-08-12 16:22:28');
INSERT INTO `article_tag_relation` VALUES (9, 8, 3, '2022-08-17 14:17:37');
INSERT INTO `article_tag_relation` VALUES (10, 9, 3, '2022-08-17 14:17:39');
INSERT INTO `article_tag_relation` VALUES (11, 10, 3, '2022-08-17 14:17:40');
INSERT INTO `article_tag_relation` VALUES (12, 11, 3, '2022-08-17 14:17:41');
INSERT INTO `article_tag_relation` VALUES (13, 12, 3, '2022-08-17 14:20:02');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (5, '1', '2022-08-11 15:09:07', NULL);
INSERT INTO `category` VALUES (6, '分类5', '2022-08-12 10:16:52', NULL);
INSERT INTO `category` VALUES (7, 'categoryName=%E6%B5%8B%E8%AF%95', '2022-08-16 14:35:00', NULL);
INSERT INTO `category` VALUES (8, '测试', '2022-08-16 14:38:22', NULL);
INSERT INTO `category` VALUES (9, ' ', '2022-08-16 14:38:48', NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(0) NOT NULL COMMENT '评论用户Id',
  `topic_id` int(0) NULL DEFAULT NULL COMMENT '评论主题id',
  `comment_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `reply_user_id` int(0) NULL DEFAULT NULL COMMENT '回复用户id',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父评论id',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论类型 1.文章 2.友链 3.说说',
  `deleted` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否删除  0否 1是',
  `review_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '是否审核 0待审核，1审核通过，2审核不通过',
  `create_time` datetime(0) NOT NULL COMMENT '评论时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 2, 8, '测试', NULL, NULL, '1', '0', '1', '2022-08-17 14:18:31', NULL);
INSERT INTO `comment` VALUES (2, 2, 9, '测试2', 2, 1, '1', '0', '1', '2022-08-17 14:19:33', NULL);
INSERT INTO `comment` VALUES (3, 2, 10, '测试3', NULL, NULL, '2', '0', '1', '2022-08-17 14:26:27', NULL);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '访问路径',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组件',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图标',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `order_num` int(0) NOT NULL COMMENT '排序',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父容器id',
  `is_hidden` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否隐藏0否，1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '首页', '/', '/app/home.vue', '123', '2022-08-19 16:44:54', NULL, 1, NULL, '0');
INSERT INTO `menu` VALUES (2, '文章管理', '/article-submenu', 'layout', '333', '2022-08-22 08:41:11', NULL, 2, NULL, '0');
INSERT INTO `menu` VALUES (3, '发布文章', '/articles', '/article/article.vue', '12', '2022-08-22 08:42:37', NULL, 1, 2, '0');
INSERT INTO `menu` VALUES (4, '修改文章', '/article/*', '/article/Article.vue', '23', '2022-08-22 08:43:54', NULL, 2, 2, '0');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `message_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '留言内容',
  `ip_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ip',
  `ip_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户地址',
  `time` tinyint(1) NULL DEFAULT NULL COMMENT '弹幕速度',
  `review_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '审核状态0：待审核1；审核通过3：审核不通过',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '11', '11', '11', '1', '11', 1, '1', '2022-08-09 16:20:49', '2022-08-19 16:21:58', '1');
INSERT INTO `message` VALUES (2, '11', '11', '11', '1', '11', 1, '1', '2022-08-09 16:20:49', '2022-08-19 16:21:58', '1');
INSERT INTO `message` VALUES (3, '11', '11', '11', '1', '11', 1, '1', '2022-08-09 16:20:49', '2022-08-19 16:21:58', '1');

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '页面id',
  `page_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '页面名称',
  `page_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '页面标签',
  `page_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '页面封面',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES (1, '首页', 'home', 'http://baidu.com', '2022-09-07 15:37:25', NULL);

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '照片id',
  `album_id` int(0) NOT NULL COMMENT '相册id',
  `photo_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '照片名称',
  `photo_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '照片描述',
  `photo_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '照片链接',
  `deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES (1, 4, '11', '22', '33', '0', '2022-09-01 15:07:33', '2022-09-01 15:10:49');
INSERT INTO `photo` VALUES (2, 3, 'ceshiupdate', 'ceshiupdate', '123', '0', '2022-09-02 10:01:39', '2022-09-02 11:28:02');
INSERT INTO `photo` VALUES (3, 3, '9b5a77408bcd4bac9b5a2bced1cab2d0', NULL, '12333', '1', '2022-09-02 10:01:39', '2022-09-02 11:28:02');

-- ----------------------------
-- Table structure for photo_album
-- ----------------------------
DROP TABLE IF EXISTS `photo_album`;
CREATE TABLE `photo_album`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '相册id',
  `album_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '相册名称',
  `album_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '相册描述',
  `album_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '相册封面',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '状态1公开2私密',
  `deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photo_album
-- ----------------------------
INSERT INTO `photo_album` VALUES (3, '1', '1', '1', '1', '0', '2022-09-01 15:55:21', NULL);
INSERT INTO `photo_album` VALUES (4, '2', '2', '2', '1', '0', '2022-09-01 15:55:30', '2022-09-05 17:33:23');
INSERT INTO `photo_album` VALUES (5, '3', '3', '3', '1', '0', '2022-09-01 15:55:37', NULL);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `resource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源名称',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源路径',
  `request_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方法',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父模块id',
  `is_anonymous` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否允许匿名访问0否，1是',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除 0否1是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资源信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '用户管理模块', NULL, NULL, NULL, '0', 0, '2022-08-05 15:42:31', NULL);
INSERT INTO `resource` VALUES (2, '用户注册', '/blog/userAuth/register', 'post', 1, '0', 0, '2022-08-05 15:43:27', NULL);
INSERT INTO `resource` VALUES (3, '分类模块', '', '', NULL, '', 0, '2022-08-23 14:13:06', NULL);
INSERT INTO `resource` VALUES (4, '菜单模块', NULL, NULL, NULL, '0', 1, '2022-08-23 14:14:25', NULL);
INSERT INTO `resource` VALUES (5, 'test', '/jslkfd', 'POST', 4, '1', 1, '2022-08-23 14:15:32', '2022-08-23 14:19:11');
INSERT INTO `resource` VALUES (6, '添加菜单', '/test', 'GET', 4, '0', 1, '2022-08-23 14:19:27', NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `role_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色描述',
  `is_disable` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否禁用角色',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int(0) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '管理员', '0', '2022-08-05 15:40:57', '2022-08-26 16:56:41', 0);
INSERT INTO `role` VALUES (2, '用户', 'user', '0', '2022-08-25 10:45:50', NULL, 0);
INSERT INTO `role` VALUES (3, '普通用户', 'normal-user', '0', '2022-08-25 11:24:54', NULL, 0);
INSERT INTO `role` VALUES (4, '普通用户1', 'test1r', '0', '2022-08-26 15:06:33', NULL, 0);
INSERT INTO `role` VALUES (5, '普通用户11', 'test1r1', '0', '2022-08-26 15:07:34', '2022-08-26 16:18:40', 0);
INSERT INTO `role` VALUES (6, '普通用户112', 'test1r12', '0', '2022-08-26 15:09:20', '2022-08-26 16:18:12', 0);
INSERT INTO `role` VALUES (7, '普通用户1123', 'test1r123', '0', '2022-08-26 16:13:12', '2022-08-29 10:23:08', 1);
INSERT INTO `role` VALUES (8, '普通用户112366', 'test1r12366', '0', '2022-08-26 16:21:48', '2022-08-29 10:23:08', 1);

-- ----------------------------
-- Table structure for role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE `role_menu_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色菜单关联id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `menu_id` int(0) NOT NULL COMMENT '菜单id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2080481284 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_relation
-- ----------------------------
INSERT INTO `role_menu_relation` VALUES (-272592894, 1, 1, '2022-08-26 16:57:23');
INSERT INTO `role_menu_relation` VALUES (-272592893, 1, 2, '2022-08-26 16:57:23');
INSERT INTO `role_menu_relation` VALUES (-272592892, 1, 3, '2022-08-26 16:57:23');
INSERT INTO `role_menu_relation` VALUES (-272592891, 1, 77, '2022-08-26 16:57:23');

-- ----------------------------
-- Table structure for role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_relation`;
CREATE TABLE `role_resource_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色资源关系id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `resource_id` int(0) NOT NULL COMMENT '资源id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2105647108 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色资源关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource_relation
-- ----------------------------
INSERT INTO `role_resource_relation` VALUES (-230649855, 1, 2, '2022-08-26 16:57:23', NULL);
INSERT INTO `role_resource_relation` VALUES (-230649854, 1, 88, '2022-08-26 16:57:23', NULL);
INSERT INTO `role_resource_relation` VALUES (-230649853, 1, 4, '2022-08-26 16:57:23', NULL);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tag_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (3, '1', '2022-08-11 15:09:07', NULL);
INSERT INTO `tag` VALUES (4, '标签散散', '2022-08-12 10:16:52', NULL);
INSERT INTO `tag` VALUES (5, '标签2323', '2022-08-12 16:22:28', NULL);

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '说说id',
  `user_info_id` int(0) NOT NULL COMMENT '用户id',
  `content` varchar(2500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '说说内容',
  `is_top` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否制定0否1是',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '1公开，2私密',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES (1, 2, 'test', '1', '1', '2022-08-30 14:16:34', '2022-08-30 16:24:56');
INSERT INTO `talk` VALUES (2, 2, '123456123', '0', '1', '2022-08-30 14:17:01', NULL);

-- ----------------------------
-- Table structure for user_auth
-- ----------------------------
DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户账号表主键',
  `user_info_id` int(0) NOT NULL COMMENT '用户信息id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `login_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录类型1：系统，2：qq,3:weibo',
  `ip_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户登录ip',
  `ip_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ip来源',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次登录时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户认证信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_auth
-- ----------------------------
INSERT INTO `user_auth` VALUES (1, 2, '2546972682@qq.com', '$2a$10$ofEs8Fs.iny7Pm2nxpYzteTanBJB1ZCc4FyjR4JFd/5Kr54PLWXmq', '1', NULL, NULL, '2022-08-05 11:36:47', '2022-09-07 16:10:49', NULL, 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户信息id',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `avatar` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户头像',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人简介',
  `website` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人网站',
  `is_disabled` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否禁用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户详细信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (2, 'xinyi ', 'hhhahaha', 'ceshi gengxin ', 'cdoe wofls', '0', '2022-08-05 11:36:47', '2022-09-07 15:40:05', 0);

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联id',
  `user_info_id` int(0) NOT NULL COMMENT '用户id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO `user_role_relation` VALUES (2, 2, 1, '2022-08-30 10:44:28', NULL);
INSERT INTO `user_role_relation` VALUES (3, 2, 3, '2022-08-30 10:44:28', NULL);
INSERT INTO `user_role_relation` VALUES (4, 4, 1, '2022-08-30 10:45:11', NULL);
INSERT INTO `user_role_relation` VALUES (5, 4, 3, '2022-08-30 10:45:11', NULL);

-- ----------------------------
-- Table structure for web_info_config
-- ----------------------------
DROP TABLE IF EXISTS `web_info_config`;
CREATE TABLE `web_info_config`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '网站配置id',
  `web_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '网站头像',
  `web_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '网站名称',
  `web_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '网站作者',
  `web_intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '网站简介',
  `web_create_time` datetime(0) NOT NULL COMMENT '网站创建时间',
  `web_notice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网站公告',
  `beian_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备案号',
  `qq_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'qq登录标志',
  `weibo_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微博登录标志',
  `qq_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'qq账号',
  `github_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'github账号',
  `gitee_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'gitee账号',
  `user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `visitor_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游客头像',
  `default_article_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '默认文章封面',
  `email_notice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '邮箱通知',
  `comment_verify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '评论审核',
  `message_verify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '留言审核',
  `reward_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '打赏状态',
  `wechat_pay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信收款码',
  `ali_pay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付宝收款码',
  `chat_room` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '聊天室',
  `websocket_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'websocket地址',
  `music_player` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '音乐播放器',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of web_info_config
-- ----------------------------
INSERT INTO `web_info_config` VALUES (1, 'webavaatar', '王哲的个人博客', '王哲', '个人博客', '2022-11-23 11:30:50', '这里是网站公告', '湘ICP备19021924号', '1', 'weibo pay', '123', 'http://gitee', 'http://gitee', 'http://useravatar', 'http://useravatar', 'https://baidu.com', '0', '0', '0', '0', 'wechat pay', '修改时代峰峻', '0', 'http://123', '0', '2022-09-07 15:04:16', '2022-09-07 15:36:37');

SET FOREIGN_KEY_CHECKS = 1;

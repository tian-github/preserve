/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : preserve_blog

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2013-05-14 02:03:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `create_time` timestamp NULL DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `creator_id` int(50) DEFAULT NULL,
  `order_num` int(50) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `creator_id` (`creator_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`creator_id`) REFERENCES `users` (`fd_id`),
  CONSTRAINT `category_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `category` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `create_time` timestamp NULL DEFAULT NULL,
  `comment_author` varchar(50) NOT NULL,
  `fd_post_id` int(50) DEFAULT NULL,
  `comment_content` text,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `fd_post_id` (`fd_post_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`fd_post_id`) REFERENCES `posts` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for `comments_meta`
-- ----------------------------
DROP TABLE IF EXISTS `comments_meta`;
CREATE TABLE `comments_meta` (
  `meta_key` varchar(500) DEFAULT NULL,
  `meta_value` varchar(500) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `comments_meta_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments_meta
-- ----------------------------

-- ----------------------------
-- Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `link_url` varchar(500) DEFAULT NULL,
  `link_description` varchar(500) DEFAULT NULL,
  `link_image` varchar(500) DEFAULT NULL,
  `order_num` int(50) DEFAULT NULL,
  `link_creator` int(50) DEFAULT NULL,
  `link_name` varchar(50) NOT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `link_creator` (`link_creator`),
  CONSTRAINT `link_ibfk_1` FOREIGN KEY (`link_creator`) REFERENCES `users` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `url` varchar(500) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `posts`
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `create_time` timestamp NULL DEFAULT NULL,
  `post_type` varchar(50) NOT NULL,
  `publish_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `comment_status` varchar(50) NOT NULL,
  `category_id` int(50) DEFAULT NULL,
  `order_num` int(50) DEFAULT NULL,
  `post_content` text,
  `author_id` int(50) DEFAULT NULL,
  `post_excerpt` text,
  `post_title` varchar(50) NOT NULL,
  `alter_time` timestamp NULL DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `users` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posts
-- ----------------------------

-- ----------------------------
-- Table structure for `posts_meta`
-- ----------------------------
DROP TABLE IF EXISTS `posts_meta`;
CREATE TABLE `posts_meta` (
  `meta_key` varchar(500) DEFAULT NULL,
  `meta_value` varchar(500) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  `posts_id` int(11) NOT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `posts_id` (`posts_id`),
  CONSTRAINT `posts_meta_ibfk_1` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posts_meta
-- ----------------------------

-- ----------------------------
-- Table structure for `posts_tags`
-- ----------------------------
DROP TABLE IF EXISTS `posts_tags`;
CREATE TABLE `posts_tags` (
  `fd_tag_id` int(50) DEFAULT NULL,
  `fd_post_id` int(50) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `fd_tag_id` (`fd_tag_id`),
  KEY `fd_post_id` (`fd_post_id`),
  CONSTRAINT `posts_tags_ibfk_1` FOREIGN KEY (`fd_tag_id`) REFERENCES `tags` (`fd_id`),
  CONSTRAINT `posts_tags_ibfk_2` FOREIGN KEY (`fd_post_id`) REFERENCES `posts` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posts_tags
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE `role_permissions` (
  `permission_id` int(50) DEFAULT NULL,
  `role_id` int(50) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `role_permissions_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`fd_id`),
  CONSTRAINT `role_permissions_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for `tags`
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `tag_img` varchar(500) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `creator_id` int(50) DEFAULT NULL,
  `order_num` int(50) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `creator_id` (`creator_id`),
  CONSTRAINT `tags_ibfk_1` FOREIGN KEY (`creator_id`) REFERENCES `users` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_nicename` varchar(50) NOT NULL,
  `user_url` varchar(500) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `user_status` varchar(10) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_login` varchar(50) NOT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for `user_meta`
-- ----------------------------
DROP TABLE IF EXISTS `user_meta`;
CREATE TABLE `user_meta` (
  `meta_key` varchar(500) DEFAULT NULL,
  `meta_value` varchar(500) DEFAULT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_meta_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_meta
-- ----------------------------

-- ----------------------------
-- Table structure for `user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `fd_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fd_id`),
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`fd_id`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_roles
-- ----------------------------

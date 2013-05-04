/*
MySQL Data Transfer
Source Host: 127.0.0.1
Source Database: preserve
Target Host: 127.0.0.1
Target Database: preserve
Date: 5/4/2013 8:30:26 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `pwd` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------

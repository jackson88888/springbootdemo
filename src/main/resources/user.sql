DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
INSERT INTO `user` VALUES ('1', 'zhangsan', '123456', '张三');
INSERT INTO `user` VALUES ('2', 'lisi', '123456', '李四');
INSERT INTO `user` VALUES ('3', 'wangwu', '123456', '王五');
INSERT INTO `user` VALUES ('4', 'zhangwei', '123456', '张伟');
INSERT INTO `user` VALUES ('5', 'lina', '123456', '李娜');
INSERT INTO `user` VALUES ('6', 'lilei', '123456', '李磊');
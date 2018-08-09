CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名(英文不重复)',
  `password` varchar(20) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '电话',
  `turename` varchar(20) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `role` tinyint(1) NOT NULL DEFAULT '1' COMMENT '角色',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户状态：0正常；1锁定；2待验证',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除：0 ok;-1 del',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
   `create_by` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   `update_by` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
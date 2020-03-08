CREATE TABLE `tb_SuperAdmin` (
  `admin_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID,不用于查询',
  `adminname` VARCHAR(16) NOT NULL COMMENT '用户名',
  `avatar_url` VARCHAR(255) NOT NULL DEFAULT 'https://weleness-1300955279.cos.ap-guangzhou.myqcloud.com/cdn/imgs/photo.jpg' COMMENT '用户头像地址',
  `password` VARCHAR(75) NOT NULL COMMENT '用户密码',
  `phone` VARCHAR(11) NOT NULL DEFAULT '0' COMMENT '不要求用户绑定手机号，0表示没有',
  `email` VARCHAR(33) NOT NULL COMMENT '用户邮箱',
  `gender` BIGINT(1) NOT NULL COMMENT '用户性别',
  `age` TINYINT(4) UNSIGNED NOT NULL DEFAULT '18' COMMENT '用户年龄',
  `area` VARCHAR(33) NOT NULL DEFAULT '无' COMMENT '用户所在地区，0表示用户没有填写',
  `login_count` int(11)  UNSIGNED NOT NULL DEFAULT '1' COMMENT '管理员登陆次数',
  `last_login` timestamp NOT NULL COMMENT '管理员最后一次登陆的时间',
  `create_time` timestamp NOT NULL COMMENT '管理员账号创建时间',
  `message_count` SMALLINT(6) UNSIGNED NOT NULL DEFAULT '0' COMMENT '管理员收到的消息数',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `unique_key` (`adminname`)
) ENGINE=InnoDB AUTO_INCREMENT=2584419330884243457 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';
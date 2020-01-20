CREATE TABLE tb_oauth(
 `oauth_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '主键ID',
 `oauth_type` VARCHAR(32) NOT NULL COMMENT '第三方平台类型:github,qq,wechat等',
 `github_open_id` VARCHAR(55) NOT NULL  COMMENT 'github平台的open id',
 `qq_open_id` VARCHAR(55) NOT NULL COMMENT 'qq平台的open id',
 `wechat_open_id` VARCHAR(55) NOT NULL  COMMENT '微信平台的open id',
 PRIMARY KEY(`oauth_id`),
 CONSTRAINT  `github_open_id_unique` UNIQUE(`github_open_id`),
 CONSTRAINT  `qq_open_id_unique`     UNIQUE(`qq_open_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和第三方认证信息关联表';
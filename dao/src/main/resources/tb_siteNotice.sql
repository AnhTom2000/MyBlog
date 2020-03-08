CREATE TABLE tb_siteNotice(
siteNotice_id  BIGINT(20) UNSIGNED NOT NULL COMMENT '网站公告主键',
siteNotice_content VARCHAR (255) NOT NULL  COMMENT '网站公告内容',
create_time TIMESTAMP NOT NULL COMMENT '发布时间',
PRIMARY KEY (siteNotice_id)
)ENGINE=InnoDB,DEFAULT CHARSET=utf8mb4,COMMENT '网站公告表'
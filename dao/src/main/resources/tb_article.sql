CREATE TABLE tb_article(
article_id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章主键',
article_name VARCHAR(33) NOT NULL COMMENT '文章名称',
u_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章对应的用户主键',
article_text TEXT not null COMMENT '文章主体',
create_time DATETIME NOT NULL COMMENT '文章创建时间',
last_update DATETIME NOT NULL COMMENT '文章最后一次修改的时间',
View_statistics INT(11) UNSIGNED NOT NULL COMMENT '文章观看量统计',
Likes_statistics INT (11) UNSIGNED NOT NULL COMMENT '点赞量统计',
article_description VARCHAR(255) NOT NULL DEFAULT '0' COMMENT '扩展字段，文章描述，没有描述时默认为0',
article_collected_Number INT(11) NOT NULL COMMENT '文章收藏数',
PRIMARY KEY (article_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';
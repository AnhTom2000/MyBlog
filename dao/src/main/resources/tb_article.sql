CREATE TABLE tb_article(
article_id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章主键',
article_name VARCHAR(100) NOT NULL COMMENT '文章名称',
u_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章对应的用户主键',
archive_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章归档id',
article_text MEDIUMTEXT not null COMMENT '文章主体',
markdown BIT NOT NULL DEFAULT 1 COMMENT '文章是否是markdown所写,默为true',
create_time TIMESTAMP NOT NULL COMMENT '文章创建时间', -- 经过再三考虑,虽然TIMESTAMP有缺陷,仅支持到203x年,但是先用着吧
last_update TIMESTAMP NOT NULL COMMENT '文章最后一次修改的时间',
category_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章所属类别id',
View_statistics INT(11) UNSIGNED NOT NULL DEFAULT  '0' COMMENT '文章观看量统计',
Likes_statistics INT (11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '点赞量统计',
article_description VARCHAR(255) NOT NULL DEFAULT '0' COMMENT '扩展字段，文章描述，没有描述时默认为0',
article_collected_Number INT(11) NOT NULL  DEFAULT 0  COMMENT '文章收藏数',
checked BIT NOT NULL DEFAULT 0 COMMENT '文章是否审核通过',
PRIMARY KEY (article_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';
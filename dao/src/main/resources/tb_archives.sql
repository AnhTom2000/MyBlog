-- 归档表
CREATE TABLE tb_archive(
archive_id  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '归档主键',
archive_name VARCHAR(32) NOT NULL COMMENT '归档日期,类似于2020年1月',
archive_article_count INT(19) UNSIGNED NOT NULL  COMMENT '当前归档的文章数量',
createTime TIMESTAMP NOT NULL COMMENT '归档创建时间',
PRIMARY KEY(archive_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '归档表'
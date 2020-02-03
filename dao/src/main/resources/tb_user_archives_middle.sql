CREATE TABLE tb_user_archives_middle(
user_archives_id INT(11) UNSIGNED  NOT NULL AUTO_INCREMENT COMMENT '用户归档中间主键',
archive_id INT(11)  UNSIGNED NOT NULL COMMENT  '归档主键',
user_id BIGINT(20) UNSIGNED NOT NULL  COMMENT '用户主键',
PRIMARY KEY(user_archives_id)
)ENGINE=InnoDB  DEFAULT  CHARSET = utf8mb4 COMMENT '用户归档中间表'
--  标签表
CREATE TABLE tb_tag(
tag_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签id',
tag_name VARCHAR(30) NOT NULL COMMENT '标签名称',
PRIMARY KEY(tag_id),
UNIQUE KEY unique_key (tag_name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表'
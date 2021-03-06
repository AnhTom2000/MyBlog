CREATE TABLE tb_category(
category_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
category_name VARCHAR(10) NOT NULL COMMENT '分类名称',
PRIMARY KEY(category_id),
UNIQUE KEY unique_key (category_name)
)ENGINE =InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类表'
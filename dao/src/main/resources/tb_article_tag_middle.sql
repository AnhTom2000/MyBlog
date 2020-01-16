# 中间表
CREATE TABLE tb_article_tag_category_middle(
article_tag_middle_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章标签中间表主键',
article_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章id',
tag_id INT(11) UNSIGNED NOT NULL COMMENT '标签id',
category_id INT(11) UNSIGNED NOT NULL COMMENT '文章类别id',
PRIMARY KEY (article_tag_middle_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章标签中间表';


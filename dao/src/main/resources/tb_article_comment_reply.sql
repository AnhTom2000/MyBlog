CREATE TABLE tb_comment_reply(
comment_reply_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论回复表主键',
comment_reply_text VARCHAR(255) NOT NULL DEFAULT '0' COMMENT '评论回复内容',
user_id BIGINT(20) NOT NULL COMMENT '用户主键，表示谁回复了这个评论',
article_comment_id BIGINT(11) UNSIGNED NOT NULL COMMENT '表示回复的是哪一个评论',
comment_reply_time DATETIME NOT NULL COMMENT '回复时间',
PRIMARY KEY(comment_reply_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论回复表'
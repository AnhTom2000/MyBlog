CREATE TABLE tb_article_comment(
comment_id BIGINT(19) UNSIGNED NOT NULL  COMMENT '文章评论的主键，0表示没有评论',
comment_text VARCHAR(255) NOT NULL DEFAULT '0' COMMENT '文章评论的内容，0表示没有评论',
comment_like_count INT(11) UNSIGNED  DEFAULT 0 COMMENT '评论点赞统计',
user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '用户的主键，表示谁评论的这篇文章',
article_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章主键，表示评论的是哪篇文章',
comment_time TIMESTAMP NOT NULL COMMENT '评论时间',
PRIMARY KEY (comment_id)
)ENGINE =InnoDB DEFAULT CHARSET =utf8mb4 COMMENT ='评论表'
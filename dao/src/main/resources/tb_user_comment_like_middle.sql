-- 评论用户点赞中间表
CREATE TABLE tb_user_comment_like_middle(
user_comment_like_middle_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论用户点赞中间表主键',
user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '用户主键，表示谁点赞了哪个评论',
article_comment_id INT(11) UNSIGNED NOT NULL COMMENT '评论id，表示哪个评论被点赞了',
PRIMARY KEY(user_comment_like_middle_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论用户点赞中间表'
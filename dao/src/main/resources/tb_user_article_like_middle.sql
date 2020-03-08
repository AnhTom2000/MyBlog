  CREATE TABLE tb_user_article_like_middle(
  user_article_like_middle_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户文章点赞关系中间表主键',
  user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id，表示谁点赞了哪篇文章',
  article_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章id，表示哪篇文章被点赞了',
  PRIMARY KEY (user_article_like_middle_id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章用户点赞中间表'
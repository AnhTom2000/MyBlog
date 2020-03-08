CREATE TABLE tb_article_comment_Notification(
article_comment_Notification_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章评论消息推送表主键',
user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '评论用户id',
auth_id BIGINT(20) UNSIGNED NOT NULL COMMENT '被点赞用户的id',
article_id  BIGINT(20) UNSIGNED NOT NULL COMMENT '评论和回复所属的文章id',
comment_id BIGINT(19) UNSIGNED NOT NULL  DEFAULT  0 COMMENT '评论id',
reply_id INT(11) UNSIGNED NOT NULL DEFAULT  0 COMMENT '回复id',
comment_content VARCHAR(255) NOT NULL COMMENT '评论内容或回复内容',
type VARCHAR(30) NOT NULL COMMENT '消息类型',
create_time TIMESTAMP  NOT NULL COMMENT '消息创建时间',
markread BIT NOT NULL COMMENT '是否已读',
PRIMARY KEY (article_comment_Notification_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '文章评论消息推送表'
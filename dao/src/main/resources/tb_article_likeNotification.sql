CREATE TABLE tb_likeNotification(
likeNotification_id BIGINT(20) UNSIGNED NOT NULL COMMENT '文章、评论点赞消息推送表主键',
user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '点赞的用户',
auth_id BIGINT(20) UNSIGNED NOT NULL COMMENT '被点赞用户的id',
article_id BIGINT(20) UNSIGNED NOT NULL  COMMENT '文章id',
article_title VARCHAR(255) NOT NULL  DEFAULT '0' COMMENT  '文章标题',
comment_content VARCHAR(255) NOT NULL DEFAULT '0' COMMENT  '评论内容',
type VARCHAR(30) NOT NULL COMMENT '消息类型',
create_time TIMESTAMP NOT NULL COMMENT '消息创建时间',
markread BIT NOT NULL COMMENT '标记消息是否已读',
PRIMARY KEY(likeNotification_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '文章点赞消息推送表'
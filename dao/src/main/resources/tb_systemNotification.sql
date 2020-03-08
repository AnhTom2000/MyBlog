  CREATE TABLE tb_systemNotification(
systemNotification_id  BIGINT(20) UNSIGNED NOT NULL COMMENT '系统通知主键',
user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '通知的用户',
type VARCHAR (30) NOT NULL COMMENT '消息类型',
message_title VARCHAR (255) NOT NULL COMMENT '消息标题，例如您的文章以通过审核',
source_id BIGINT(20) UNSIGNED NOT NULL DEFAULT  0 COMMENT '例如文章id',
message_content VARCHAR (255) NOT NULL COMMENT '消息内容,例如 文章标题',
create_time TIMESTAMP NOT NULL COMMENT '消息创建时间',
markread BIT NOT NULL COMMENT '标记消息是否已读',
PRIMARY KEY (systemNotification_id)
)ENGINE=InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '系统通知表'
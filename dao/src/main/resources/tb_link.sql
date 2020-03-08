CREATE TABLE tb_link (
  link_id   INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '链接id',
  link_name VARCHAR(50)      NOT NULL
  COMMENT '链接名',
  href      VARCHAR(255)     NOT NULL
  COMMENT '链接',
  PRIMARY KEY (link_id),
  CONSTRAINT link_name_unique UNIQUE (link_name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '友情链接表';
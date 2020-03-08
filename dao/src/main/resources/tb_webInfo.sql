CREATE TABLE tb_web_info(
    `web_info_id` SMALLINT(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'web info id',
    `description` VARCHAR(255) NOT NULL COMMENT 'meta的description',
    `keywords` VARCHAR(255) NOT NULL COMMENT 'meta的keywords',
    `icp_info` VARCHAR(100) NOT NULL COMMENT '网站的备案信息',
    `copyright` VARCHAR(100) NOT NULL COMMENT '备案信息',
    `logo_url` VARCHAR(255) NOT NULL COMMENT 'logo url',
    PRIMARY KEY(`web_info_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='web info网站信息数据表';
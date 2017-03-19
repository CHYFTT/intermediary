use intermediary;
create TABLE td_community  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '小区名称',
  `type` int(10) NOT NULL DEFAULT -1 COMMENT '小区类型：10 正常小区，20 回迁房',
  `location` varchar(255) NOT NULL DEFAULT '' COMMENT '小区位置',
  `description` varchar(2048) NOT NULL DEFAULT '' COMMENT '小区介绍',
  `description_source` varchar(255) NOT NULL DEFAULT '' COMMENT '小区介绍-资料来源',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '更新人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_name_city` (`name`, `city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='小区';

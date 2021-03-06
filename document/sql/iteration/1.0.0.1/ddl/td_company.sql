use intermediary;
create TABLE td_company  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '公司名称',
  `type` int(10) NOT NULL DEFAULT -1 COMMENT '公司类型：10 中介公司，20 代理',
  `black_score_overall` int(10) NOT NULL DEFAULT 0 COMMENT '黑心指数',
  `leader` varchar(255) NOT NULL DEFAULT '' COMMENT '公司负责人',
  `description` varchar(2048) NOT NULL DEFAULT '' COMMENT '公司介绍',
  `description_source` varchar(255) NOT NULL DEFAULT '' COMMENT '公司介绍-资料来源',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20)  NOT NULL DEFAULT '-1' COMMENT '更新人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_name` (`name`),
  KEY `index_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='公司';

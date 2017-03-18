use intermediary;
create TABLE tb_experience  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `location_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '城市-公司-小区关系id',
  `content` varchar(2048) NOT NULL DEFAULT '' COMMENT '事情经过',
  `score` int(10) NOT NULL DEFAULT 0 COMMENT '黑心指数',
  `count_read` int(10) NOT NULL DEFAULT 0 COMMENT '浏览次数',
  `count_agree` int(10) NOT NULL DEFAULT 0 COMMENT '顶次数',
  `count_disagree` int(10) NOT NULL DEFAULT 0 COMMENT '踩次数',
  `count_comment` int(10) NOT NULL DEFAULT 0 COMMENT '评论数',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '更新人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_location` (`location_id`),
  KEY `index_add_user_id` (`add_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='事情经历';

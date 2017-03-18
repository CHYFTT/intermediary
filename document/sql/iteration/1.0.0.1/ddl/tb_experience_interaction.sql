use intermediary;
create TABLE tb_experience_interaction  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `experience_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '事情经过id',
  `type` int(10) NOT NULL DEFAULT -1 COMMENT '操作类型：1 浏览, 10 顶，-10 踩，20：评论',
  `value` int(10) NOT NULL DEFAULT 1 COMMENT '操作权值',
  `ip_addr` varchar(255) NOT NULL DEFAULT '' COMMENT 'ip地址',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '更新人id',
  `is_active` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效，1有效，0无效',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_experience_type` (experience_id, `type`),
  KEY `index_experience_type_user` (experience_id, `type`, add_user_id, ip_addr )
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='事情经过互动记录';

use intermediary;
create TABLE tb_relation_experience_fraud  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `experience_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '事情经过id',
  `fraud_means_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '欺骗手段id',
  `score` int(10) NOT NULL DEFAULT 0 COMMENT '手段程度',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '更新人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_experience_id` (experience_id)
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='事情经过-欺骗手段-关系表';

use intermediary;
create TABLE td_contacts  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '业务员名称',
  `mobile` varchar(255) NOT NULL DEFAULT '' COMMENT '业务员联系方式',
  `company_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '所属公司id',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '更新人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_name` (`name`),
  KEY `index_mobile` (`mobile`),
  KEY `index_company_id` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='联系人';

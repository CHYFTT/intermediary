use intermediary;
create TABLE tb_experience_comment  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `experience_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '事情经过id',
  `parent_comment_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '回复的评论id，不是对评论的回复时置为-1',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '内容',
  `count_agree` int(10) NOT NULL DEFAULT 0 COMMENT '顶次数',
  `count_disagree` int(10) NOT NULL DEFAULT 0 COMMENT '踩次数',
  `add_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '添加时间',
  `add_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '添加人id',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '更新人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `index_experience` (experience_id),
  KEY `index_parent_comment_id` (parent_comment_id)
) ENGINE=InnoDB AUTO_INCREMENT=1488440019246646006 DEFAULT CHARSET=utf8 COMMENT='评论';

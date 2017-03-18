package com.henrrycheng.chyftt.intermediary.experienceComment.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.experienceComment.bo.ExperienceComment;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.experienceComment.bo.ExperienceCommentBase
 * @author chengyong
 */
@SqlMapper
public interface ExperienceCommentMapper extends DaoMapper<ExperienceComment, Long> {
}
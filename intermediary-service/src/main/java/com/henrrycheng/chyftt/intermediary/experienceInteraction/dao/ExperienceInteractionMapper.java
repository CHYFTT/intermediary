package com.henrrycheng.chyftt.intermediary.experienceInteraction.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.bo.ExperienceInteraction;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.experienceInteraction.bo.ExperienceInteractionBase
 * @author chengyong
 */
@SqlMapper
public interface ExperienceInteractionMapper extends DaoMapper<ExperienceInteraction, Long> {
}
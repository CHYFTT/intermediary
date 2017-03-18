package com.henrrycheng.chyftt.intermediary.experience.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.experience.bo.Experience;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.experience.bo.ExperienceBase
 * @author chengyong
 */
@SqlMapper
public interface ExperienceMapper extends DaoMapper<Experience, Long> {
}
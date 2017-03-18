package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
@SqlMapper
public interface RelationExperienceFraudMapper extends DaoMapper<RelationExperienceFraud, Long> {
}
package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
@SqlMapper
public interface RelationExperienceFraudMapper extends DaoMapper<RelationExperienceFraud, Long> {

    /**
     * 根据条件查询
     *
     * @param experienceId
     *
     * @param fraudMeansId
     *
     * @return FraudMeans
     */
    RelationExperienceFraud queryByCondition(@Param("experienceId") Long experienceId,
                                             @Param("fraudMeansId") Long fraudMeansId);
}
package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
public interface RelationExperienceFraudDao extends SqlMapDao<RelationExperienceFraud, Long> {

    /**
     * 根据条件查询
     *
     * @param experienceId
     *
     * @param fraudMeansId
     *
     * @return FraudMeans
     */
    RelationExperienceFraud queryByCondition(Long experienceId, Long fraudMeansId);
}
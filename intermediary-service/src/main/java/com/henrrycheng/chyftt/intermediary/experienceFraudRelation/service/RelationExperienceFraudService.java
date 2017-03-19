package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;

import java.util.List;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
public interface RelationExperienceFraudService extends GenericService<RelationExperienceFraud, Long> {

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

    /**
     * 批量保存吐槽记录和欺骗手段对应关系
     *
     * @param experienceId
     *
     * @param fraudMeansNameList
     *
     * @return id
     */
    void saveRelationWithName(Long experienceId, List<String> fraudMeansNameList);

    /**
     * 批量保存吐槽记录和欺骗手段对应关系
     *
     * @param experienceId
     *
     * @param fraudMeansId
     *
     * @return id
     */
    void saveRelation(Long experienceId, List<Long> fraudMeansId);

    /**
     * 保存吐槽记录和欺骗手段对应关系
     *
     * @param experienceId
     *
     * @param fraudMeansId
     *
     * @return id
     */
    Long saveRelation(Long experienceId, Long fraudMeansId);
}
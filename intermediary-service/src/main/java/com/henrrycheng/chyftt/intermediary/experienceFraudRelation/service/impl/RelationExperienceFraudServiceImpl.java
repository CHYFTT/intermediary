package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import com.henrrycheng.chyftt.intermediary.experience.constant.ExperenceScoreEnum;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.RelationExperienceFraudDao;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.service.RelationExperienceFraudService;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import com.henrrycheng.chyftt.intermediary.fraudMeans.service.FraudMeansService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
@Service("relationExperienceFraudService")
public class RelationExperienceFraudServiceImpl extends GenericSqlMapServiceImpl<RelationExperienceFraud, Long> implements RelationExperienceFraudService {

    private static final Logger logger = Logger.getLogger(RelationExperienceFraudServiceImpl.class);

    /**
     * Dao 'relationExperienceFraudDao' reference.
     */
    @Resource(name = "relationExperienceFraudDao")
    private RelationExperienceFraudDao relationExperienceFraudDao;

    @Resource(name = "fraudMeansService")
    private FraudMeansService fraudMeansService;


    /**
     * 批量保存吐槽记录和欺骗手段对应关系
     *
     * @param experienceId
     *
     * @param fraudMeansNameList
     *
     * @return id
     */
    public void saveRelationWithName(Long experienceId, List<String> fraudMeansNameList) {
        if (experienceId == null) {
            logger.error("saveRelationWithName: experienceId is null.");
            return ;
        }
        if (CollectionUtils.isEmpty(fraudMeansNameList)) {
            logger.error("saveRelationWithName: fraudMeansNameList is null.");
            return ;
        }

        /**
         * 查询已存在或新增欺骗手段标签
         */
        List<FraudMeans> fraudMeansList =  fraudMeansService.queryByConditionWithSave(fraudMeansNameList);
        if (CollectionUtils.isEmpty(fraudMeansList)) {
            logger.error("saveRelationWithName: get fraudMeansList by queryByConditionWithSave is empty, experienceId = "
                + experienceId + ", fraudMeansNameList = " + fraudMeansNameList);
            return ;
        }

        List<Long> fraudMeansIdList = Lists.transform(fraudMeansList, new Function<FraudMeans, Long>() {
            @Override
            public Long apply (FraudMeans fraudMeans) {
                return fraudMeans.getId();
            }
        });

        saveRelation(experienceId, fraudMeansIdList);
    }


    /**
     * 批量保存吐槽记录和欺骗手段对应关系
     *
     * @param experienceId
     *
     * @param fraudMeansIdList
     *
     * @return id
     */
    public void saveRelation(Long experienceId, List<Long> fraudMeansIdList) {

        if (experienceId == null) {
            logger.error("saveRelation: experienceId is null.");
            return ;
        }
        if (CollectionUtils.isEmpty(fraudMeansIdList)) {
            logger.error("saveRelation: fraudMeansIdList is null.");
            return ;
        }

        for (Long fraudMeansId : fraudMeansIdList) {
            Long id = saveRelation(experienceId, fraudMeansId);
            if (id == null) {
                logger.error("saveRelation: id is null, experienceId = " + experienceId + ", experienceId = " + experienceId);
            }
        }
    }

    /**
     * 保存吐槽记录和欺骗手段对应关系
     *
     * @param experienceId
     *
     * @param fraudMeansId
     *
     * @return id
     */
    public Long saveRelation(Long experienceId, Long fraudMeansId) {

        if (experienceId == null) {
            logger.error("saveRelation: experienceId is null.");
            return null;
        }
        if (fraudMeansId == null) {
            logger.error("saveRelation: fraudMeansId is null.");
            return null;
        }

        /**
         * 检查是否已存在
         */
        RelationExperienceFraud relationExperienceFraud = queryByCondition(experienceId, fraudMeansId);
        if (relationExperienceFraud != null) {
            // 吐槽反馈和欺骗手段的关系已存在！
            logger.error("saveRelation: get relationExperienceFraud by queryByCondition is already exist!!," +
                    " experienceId = " + experienceId + ", fraudMeansId = " + fraudMeansId);
            return relationExperienceFraud.getId();

        } else {
            // 不存在吐槽反馈和欺骗手段的对应关系，新增

            relationExperienceFraud = new RelationExperienceFraud();
            relationExperienceFraud.setExperienceId(experienceId);
            relationExperienceFraud.setFraudMeansId(fraudMeansId);
            relationExperienceFraud.setScore(ExperenceScoreEnum.TEN.getCode());

            SaveAndUpdateUtils.setCommonFieldsWhenSave(relationExperienceFraud);
            return saveEntity(relationExperienceFraud);
        }
    }

    /**
     * 根据条件查询
     *
     * @param experienceId
     *
     * @param fraudMeansId
     *
     * @return FraudMeans
     */
    public RelationExperienceFraud queryByCondition(Long experienceId, Long fraudMeansId) {
        return relationExperienceFraudDao.queryByCondition(experienceId, fraudMeansId);
    }


    @Override
    public SqlMapDao<RelationExperienceFraud, Long> getDao() {
        return relationExperienceFraudDao;
    }
}
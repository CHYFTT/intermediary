package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.RelationExperienceFraudDao;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.RelationExperienceFraudMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
@Service("relationExperienceFraudDao")
public class RelationExperienceFraudDaoImpl extends ConfigurableBaseSqlMapDao<RelationExperienceFraud, Long> implements RelationExperienceFraudDao {

    private static final Logger logger = Logger.getLogger(RelationExperienceFraudDaoImpl.class);

    /**
     * DaoMapper 'relationExperienceFraudMapper' reference.
     */
    @Autowired
    private RelationExperienceFraudMapper relationExperienceFraudMapper;

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
        if (experienceId == null || fraudMeansId == null) {
            logger.error("queryByCondition: experienceId an fraudMeansId both can not be null.");
            return null;
        }
        return relationExperienceFraudMapper.queryByCondition(experienceId, fraudMeansId);
    }

    @Override
    public DaoMapper<RelationExperienceFraud, Long> getDaoMapper() {
        return relationExperienceFraudMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}
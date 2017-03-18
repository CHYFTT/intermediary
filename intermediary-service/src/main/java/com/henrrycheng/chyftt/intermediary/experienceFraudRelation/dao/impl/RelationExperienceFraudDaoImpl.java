package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.RelationExperienceFraudDao;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.RelationExperienceFraudMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
@Service("relationExperienceFraudDao")
public class RelationExperienceFraudDaoImpl extends ConfigurableBaseSqlMapDao<RelationExperienceFraud, Long> implements RelationExperienceFraudDao {
    /**
     * DaoMapper 'relationExperienceFraudMapper' reference.
     */
    @Autowired
    private RelationExperienceFraudMapper relationExperienceFraudMapper;

    @Override
    public DaoMapper<RelationExperienceFraud, Long> getDaoMapper() {
        return relationExperienceFraudMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Resource(name = "sqlSessionTemplate")
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        setSqlSessionTemplateInternal(sqlSessionTemplate);
    }
}
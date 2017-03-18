package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraud;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.dao.RelationExperienceFraudDao;
import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.service.RelationExperienceFraudService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo.RelationExperienceFraudBase
 * @author chengyong
 */
@Service("relationExperienceFraudService")
public class RelationExperienceFraudServiceImpl extends GenericSqlMapServiceImpl<RelationExperienceFraud, Long> implements RelationExperienceFraudService {
    /**
     * Dao 'relationExperienceFraudDao' reference.
     */
    @Resource(name = "relationExperienceFraudDao")
    private RelationExperienceFraudDao relationExperienceFraudDao;

    @Override
    public SqlMapDao<RelationExperienceFraud, Long> getDao() {
        return relationExperienceFraudDao;
    }
}
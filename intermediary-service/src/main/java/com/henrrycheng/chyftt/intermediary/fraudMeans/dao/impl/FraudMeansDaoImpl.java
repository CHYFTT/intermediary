package com.henrrycheng.chyftt.intermediary.fraudMeans.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import com.henrrycheng.chyftt.intermediary.fraudMeans.dao.FraudMeansDao;
import com.henrrycheng.chyftt.intermediary.fraudMeans.dao.FraudMeansMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
@Service("fraudMeansDao")
public class FraudMeansDaoImpl extends ConfigurableBaseSqlMapDao<FraudMeans, Long> implements FraudMeansDao {
    /**
     * DaoMapper 'fraudMeansMapper' reference.
     */
    @Autowired
    private FraudMeansMapper fraudMeansMapper;

    @Override
    public DaoMapper<FraudMeans, Long> getDaoMapper() {
        return fraudMeansMapper;
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
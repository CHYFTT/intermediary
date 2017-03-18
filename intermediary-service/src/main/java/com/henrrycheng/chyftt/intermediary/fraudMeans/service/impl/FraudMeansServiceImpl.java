package com.henrrycheng.chyftt.intermediary.fraudMeans.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import com.henrrycheng.chyftt.intermediary.fraudMeans.dao.FraudMeansDao;
import com.henrrycheng.chyftt.intermediary.fraudMeans.service.FraudMeansService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
@Service("fraudMeansService")
public class FraudMeansServiceImpl extends GenericSqlMapServiceImpl<FraudMeans, Long> implements FraudMeansService {
    /**
     * Dao 'fraudMeansDao' reference.
     */
    @Resource(name = "fraudMeansDao")
    private FraudMeansDao fraudMeansDao;

    @Override
    public SqlMapDao<FraudMeans, Long> getDao() {
        return fraudMeansDao;
    }
}
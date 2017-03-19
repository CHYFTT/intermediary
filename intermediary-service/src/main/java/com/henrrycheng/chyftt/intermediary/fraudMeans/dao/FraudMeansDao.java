package com.henrrycheng.chyftt.intermediary.fraudMeans.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
public interface FraudMeansDao extends SqlMapDao<FraudMeans, Long> {

    /**
     * 根据条件查询
     *
     * @param fraudMeansName
     *
     * @return FraudMeans
     */
    FraudMeans queryByCondition(String fraudMeansName);
}
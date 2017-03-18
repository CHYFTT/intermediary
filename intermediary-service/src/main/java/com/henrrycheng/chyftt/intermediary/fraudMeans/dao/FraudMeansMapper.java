package com.henrrycheng.chyftt.intermediary.fraudMeans.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
@SqlMapper
public interface FraudMeansMapper extends DaoMapper<FraudMeans, Long> {
}
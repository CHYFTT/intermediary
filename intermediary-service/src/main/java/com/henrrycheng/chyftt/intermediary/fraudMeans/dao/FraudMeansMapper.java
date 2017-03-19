package com.henrrycheng.chyftt.intermediary.fraudMeans.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
@SqlMapper
public interface FraudMeansMapper extends DaoMapper<FraudMeans, Long> {

    /**
     * 根据条件查询
     *
     * @param fraudMeansName
     *
     * @return FraudMeans
     */
    FraudMeans queryByCondition(@Param("name") String fraudMeansName);
}
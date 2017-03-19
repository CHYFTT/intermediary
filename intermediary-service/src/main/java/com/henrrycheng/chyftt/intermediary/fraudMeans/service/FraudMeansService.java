package com.henrrycheng.chyftt.intermediary.fraudMeans.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;

import java.util.List;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
public interface FraudMeansService extends GenericService<FraudMeans, Long> {

    /**
     * 根据条件查询
     *
     * @param fraudMeansName
     *
     * @return FraudMeans
     */
    FraudMeans queryByName (String fraudMeansName);

    /**
     * 根据条件查询, 若不存在则新建
     *
     * @param fraudMeansName
     *
     * @return FraudMeans
     */
    FraudMeans queryByConditionWithSave(String fraudMeansName);

    /**
     * 批量根据条件查询, 若不存在则新建
     *
     * @param fraudMeansNameList
     *
     * @return FraudMeans
     */
    List<FraudMeans> queryByConditionWithSave(List<String> fraudMeansNameList);
}
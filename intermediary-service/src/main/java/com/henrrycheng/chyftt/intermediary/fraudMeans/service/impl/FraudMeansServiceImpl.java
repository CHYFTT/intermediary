package com.henrrycheng.chyftt.intermediary.fraudMeans.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import com.henrrycheng.chyftt.intermediary.fraudMeans.dao.FraudMeansDao;
import com.henrrycheng.chyftt.intermediary.fraudMeans.service.FraudMeansService;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeansBase
 * @author chengyong
 */
@Service("fraudMeansService")
public class FraudMeansServiceImpl extends GenericSqlMapServiceImpl<FraudMeans, Long> implements FraudMeansService {

    private static final Logger logger = Logger.getLogger(FraudMeansServiceImpl.class);

    /**
     * Dao 'fraudMeansDao' reference.
     */
    @Resource(name = "fraudMeansDao")
    private FraudMeansDao fraudMeansDao;

    /**
     * 批量根据条件查询, 若不存在则新建
     *
     * @param fraudMeansNameList
     *
     * @return FraudMeans
     */
    public List<FraudMeans> queryByConditionWithSave(List<String> fraudMeansNameList) {
        if (CollectionUtils.isEmpty(fraudMeansNameList)) {
            logger.error("queryByConditionWithSave: fraudMeansNameList is empty.");
            return Collections.emptyList();
        }

        List<FraudMeans> fraudMeansList = new ArrayList<FraudMeans>();
        for (String freadMeans : fraudMeansNameList) {
            FraudMeans fraudMeans = queryByConditionWithSave(freadMeans);
            if (fraudMeans != null) {
                fraudMeansList.add(fraudMeans);
            }
        }
        return fraudMeansList;
    }

    /**
     * 根据条件查询
     *
     * @param fraudMeansName
     *
     * @return FraudMeans
     */
    public FraudMeans queryByName (String fraudMeansName) {
        return fraudMeansDao.queryByCondition(fraudMeansName);
    }

    /**
     * 根据条件查询, 若不存在则新建
     *
     * @param fraudMeansName
     *
     * @return FraudMeans
     */
    public FraudMeans queryByConditionWithSave(String fraudMeansName) {
        if (StringUtils.isEmpty(fraudMeansName)) {
            logger.error("queryByConditionWithSave: fraudMeansName is null.");
            return null;
        }
        FraudMeans fraudMeans = queryByName(fraudMeansName);
        if (fraudMeans != null) {
            return fraudMeans;
        }

        fraudMeans = new FraudMeans();
        fraudMeans.setName(fraudMeansName);
        fraudMeans.setFrequency(0L);
        SaveAndUpdateUtils.setCommonFieldsWhenSave(fraudMeans);

        Long id = saveEntity(fraudMeans);
        if (id == null) {
            logger.error("queryByConditionWithSave: get id by saveEntity is null, fraudMeansName = " + fraudMeansName);
            return null;
        }
        return findById(id);
    }

    @Override
    public SqlMapDao<FraudMeans, Long> getDao() {
        return fraudMeansDao;
    }
}
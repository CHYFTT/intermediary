package com.henrrycheng.chyftt.intermediary.city.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import com.henrrycheng.chyftt.intermediary.city.dao.CityDao;
import com.henrrycheng.chyftt.intermediary.city.service.CityService;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
@Service("cityService")
public class CityServiceImpl extends GenericSqlMapServiceImpl<City, Long> implements CityService {

    private static final Logger logger = Logger.getLogger(CityServiceImpl.class);

    /**
     * Dao 'cityDao' reference.
     */
    @Resource(name = "cityDao")
    private CityDao cityDao;

    @Override
    public SqlMapDao<City, Long> getDao() {
        return cityDao;
    }

    /**
     * 根据条件查询
     *
     * @param cityName
     *
     * @return City
     */
    public City queryByName (String cityName) {
        return cityDao.queryByCondition(cityName, null);
    }

    /**
     * 根据条件查询, 若不存在则新建
     *
     * @param cityName
     *
     * @return City
     */
    public City queryByConditionWithSave(String cityName) {
        if (StringUtils.isEmpty(cityName)) {
            logger.error("queryByConditionWithSave: cityName is null.");
            return null;
        }
        City city = queryByName(cityName);
        if (city != null) {
            return city;
        }

        city = new City();
        city.setName(cityName);
        SaveAndUpdateUtils.setCommonFieldsWhenSave(city);

        Long id = saveEntity(city);
        if (id == null) {
            logger.error("queryByConditionWithSave: get id by saveEntity is null, cityName = " + cityName);
            return null;
        }
        return findById(id);
    }
}
package com.henrrycheng.chyftt.intermediary.city.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import com.henrrycheng.chyftt.intermediary.city.dao.CityDao;
import com.henrrycheng.chyftt.intermediary.city.service.CityService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
@Service("cityService")
public class CityServiceImpl extends GenericSqlMapServiceImpl<City, Long> implements CityService {
    /**
     * Dao 'cityDao' reference.
     */
    @Resource(name = "cityDao")
    private CityDao cityDao;

    @Override
    public SqlMapDao<City, Long> getDao() {
        return cityDao;
    }
}
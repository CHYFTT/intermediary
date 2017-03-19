package com.henrrycheng.chyftt.intermediary.city.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.city.bo.City;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
public interface CityDao extends SqlMapDao<City, Long> {

    /**
     * 根据条件查询
     *
     * @param cityName
     *
     * @return City
     */
    City queryByCondition(String cityName, Long id);
}
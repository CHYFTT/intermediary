package com.henrrycheng.chyftt.intermediary.city.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.city.bo.City;

import java.util.List;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
public interface CityService extends GenericService<City, Long> {

    /**
     * 根据条件查询
     *
     * @param cityName
     *
     * @return City
     */
    City queryByName (String cityName);

    /**
     * 根据条件查询, 若不存在则新建
     *
     * @param cityName
     *
     * @return City
     */
    City queryByConditionWithSave(String cityName);
}
package com.henrrycheng.chyftt.intermediary.city.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
@SqlMapper
public interface CityMapper extends DaoMapper<City, Long> {

    /**
     * 根据条件查询
     *
     * @param cityName
     *
     * @return City
     */
    City queryByCondition(@Param("cityName") String cityName, @Param("id") Long id);
}
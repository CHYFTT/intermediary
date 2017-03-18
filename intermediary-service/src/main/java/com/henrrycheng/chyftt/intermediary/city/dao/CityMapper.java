package com.henrrycheng.chyftt.intermediary.city.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.city.bo.City;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
@SqlMapper
public interface CityMapper extends DaoMapper<City, Long> {


}
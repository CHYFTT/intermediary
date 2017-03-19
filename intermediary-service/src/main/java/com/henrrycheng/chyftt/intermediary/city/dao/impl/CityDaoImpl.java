package com.henrrycheng.chyftt.intermediary.city.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import com.henrrycheng.chyftt.intermediary.city.dao.CityDao;
import com.henrrycheng.chyftt.intermediary.city.dao.CityMapper;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.city.bo.CityBase
 * @author chengyong
 */
@Service("cityDao")
public class CityDaoImpl extends ConfigurableBaseSqlMapDao<City, Long> implements CityDao {
    /**
     * DaoMapper 'cityMapper' reference.
     */
    @Autowired
    private CityMapper cityMapper;

    /**
     * 根据条件查询
     *
     * @param cityName
     *
     * @return City
     */
    public  City queryByCondition(String cityName, Long id) {
        if (StringUtils.isEmpty(cityName)) {
            return null;
        }
        return cityMapper.queryByCondition(cityName, id);
    }

    @Override
    public DaoMapper<City, Long> getDaoMapper() {
        return cityMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}
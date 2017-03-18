package com.henrrycheng.chyftt.intermediary.city.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import com.henrrycheng.chyftt.intermediary.city.dao.CityDao;
import com.henrrycheng.chyftt.intermediary.city.dao.CityMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
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

    @Override
    public DaoMapper<City, Long> getDaoMapper() {
        return cityMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Resource(name = "sqlSessionTemplate")
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        setSqlSessionTemplateInternal(sqlSessionTemplate);
    }
}
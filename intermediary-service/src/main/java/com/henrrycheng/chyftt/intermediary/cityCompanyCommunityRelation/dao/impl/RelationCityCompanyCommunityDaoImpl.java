package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.RelationCityCompanyCommunityDao;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.RelationCityCompanyCommunityMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
@Service("relationCityCompanyCommunityDao")
public class RelationCityCompanyCommunityDaoImpl extends ConfigurableBaseSqlMapDao<RelationCityCompanyCommunity, Long> implements RelationCityCompanyCommunityDao {
    /**
     * DaoMapper 'relationCityCompanyCommunityMapper' reference.
     */
    @Autowired
    private RelationCityCompanyCommunityMapper relationCityCompanyCommunityMapper;

    @Override
    public DaoMapper<RelationCityCompanyCommunity, Long> getDaoMapper() {
        return relationCityCompanyCommunityMapper;
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
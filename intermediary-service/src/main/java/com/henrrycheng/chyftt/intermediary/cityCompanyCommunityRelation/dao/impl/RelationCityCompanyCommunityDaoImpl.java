package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.RelationCityCompanyCommunityDao;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.RelationCityCompanyCommunityMapper;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.experience.service.impl.ExperienceServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
@Service("relationCityCompanyCommunityDao")
public class RelationCityCompanyCommunityDaoImpl extends ConfigurableBaseSqlMapDao<RelationCityCompanyCommunity, Long> implements RelationCityCompanyCommunityDao {

    private static final Logger logger = Logger.getLogger(RelationCityCompanyCommunityDaoImpl.class);

    /**
     * DaoMapper 'relationCityCompanyCommunityMapper' reference.
     */
    @Autowired
    private RelationCityCompanyCommunityMapper relationCityCompanyCommunityMapper;


    /**
     * 根据条件查询关系id
     *
     * @param cityId      城市id
     *
     * @param companyId   公司id
     *
     * @param communityId 小区Id
     *
     * @return RelationCityCompanyCommunity
     *
     * @author chengyong
     */
    public List<RelationCityCompanyCommunity> queryByCondition(Long cityId, Long companyId, Long communityId) {
        if (cityId == null && companyId == null && communityId == null) {
            logger.error("queryByName: cityId, companyId, communityId can not null meantime.");
            return Collections.emptyList();
        }
        return relationCityCompanyCommunityMapper.queryByCondition(cityId, companyId, communityId);
    }

    @Override
    public DaoMapper<RelationCityCompanyCommunity, Long> getDaoMapper() {
        return relationCityCompanyCommunityMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}
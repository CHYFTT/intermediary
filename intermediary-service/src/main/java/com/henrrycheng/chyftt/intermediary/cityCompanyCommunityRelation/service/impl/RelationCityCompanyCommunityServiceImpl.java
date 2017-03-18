package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.RelationCityCompanyCommunityDao;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.service.RelationCityCompanyCommunityService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
@Service("relationCityCompanyCommunityService")
public class RelationCityCompanyCommunityServiceImpl extends GenericSqlMapServiceImpl<RelationCityCompanyCommunity, Long> implements RelationCityCompanyCommunityService {
    /**
     * Dao 'relationCityCompanyCommunityDao' reference.
     */
    @Resource(name = "relationCityCompanyCommunityDao")
    private RelationCityCompanyCommunityDao relationCityCompanyCommunityDao;

    @Override
    public SqlMapDao<RelationCityCompanyCommunity, Long> getDao() {
        return relationCityCompanyCommunityDao;
    }
}
package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;

import java.util.List;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
public interface RelationCityCompanyCommunityDao extends SqlMapDao<RelationCityCompanyCommunity, Long> {

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
    List<RelationCityCompanyCommunity> queryByCondition(Long cityId, Long companyId, Long communityId);
}
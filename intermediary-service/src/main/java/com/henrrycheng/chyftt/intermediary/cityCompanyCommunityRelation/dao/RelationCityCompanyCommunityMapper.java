package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
@SqlMapper
public interface RelationCityCompanyCommunityMapper extends DaoMapper<RelationCityCompanyCommunity, Long> {

    /**
     * 根据条件查询关系id
     *
     * @param cityId      城市id
     *
     * @param companyId   公司id
     *
     * @param communityId 小区Id
     *
     * @return relationId
     *
     * @author chengyong
     */
    List<RelationCityCompanyCommunity> queryByCondition(@Param("cityId") Long cityId,
                                                        @Param("companyId") Long companyId,
                                                        @Param("communityId") Long communityId);
}
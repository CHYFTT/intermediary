package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
@SqlMapper
public interface RelationCityCompanyCommunityMapper extends DaoMapper<RelationCityCompanyCommunity, Long> {
}
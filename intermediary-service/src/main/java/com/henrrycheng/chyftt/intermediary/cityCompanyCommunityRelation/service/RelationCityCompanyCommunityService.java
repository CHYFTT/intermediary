package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;

import java.util.List;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
public interface RelationCityCompanyCommunityService extends GenericService<RelationCityCompanyCommunity, Long> {

    /**
     * 根据条件返回关系，如果已存在该组合则直接返回，否则新建并返回
     *
     * 三个参数都不能为空
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
    RelationCityCompanyCommunity queryByWholeConditionWithSave(Long cityId, Long companyId, Long communityId);

    /**
     * 根据条件返回关系，如果已存在该组合则直接返回，否则新建并返回
     *
     * 三个参数都不能为空
     *
     * @param cityName      城市
     *
     * @param companyName   公司
     *
     * @param communityName 小区
     *
     * @return RelationCityCompanyCommunity
     *
     * @author chengyong
     */
    RelationCityCompanyCommunity queryByWholeConditionWithSave(String cityName, String companyName,
                                                               String communityName);

    /**
     * 根据条件查询关系
     *
     * 三个参数不能同时为空
     *
     * @param cityId      城市id
     *
     * @param companyId   公司id
     *
     * @param communityId 小区Id
     *
     * @return List<RelationCityCompanyCommunity>
     *
     * @author chengyong
     */
    List<RelationCityCompanyCommunity> queryByCondition(Long cityId, Long companyId, Long communityId);

    /**
     * 保存新的关系
     *
     * @param cityId
     *
     * @param companyId
     *
     * @param communityId
     *
     * @return id
     */
    Long saveRelation(Long cityId, Long companyId, Long communityId);
}
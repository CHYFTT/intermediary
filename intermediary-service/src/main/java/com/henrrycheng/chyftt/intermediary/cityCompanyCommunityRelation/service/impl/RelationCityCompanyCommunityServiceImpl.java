package com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.city.bo.City;
import com.henrrycheng.chyftt.intermediary.city.service.CityService;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.dao.RelationCityCompanyCommunityDao;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.service.RelationCityCompanyCommunityService;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.service.CommunityService;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.service.CompanyService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunityBase
 * @author chengyong
 */
@Service("relationCityCompanyCommunityService")
public class RelationCityCompanyCommunityServiceImpl extends GenericSqlMapServiceImpl<RelationCityCompanyCommunity, Long> implements RelationCityCompanyCommunityService {

    private static final Logger logger = Logger.getLogger(RelationCityCompanyCommunityServiceImpl.class);

    /**
     * Dao 'relationCityCompanyCommunityDao' reference.
     */
    @Resource(name = "relationCityCompanyCommunityDao")
    private RelationCityCompanyCommunityDao relationCityCompanyCommunityDao;

    @Resource(name = "cityService")
    private CityService cityService;

    @Resource(name = "companyService")
    private CompanyService companyService;

    @Resource(name = "communityService")
    private CommunityService communityService;

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
    public RelationCityCompanyCommunity queryByWholeConditionWithSave(String cityName, String companyName,
                                                                      String communityName) {

        if (StringUtils.isEmpty(cityName)) {
            logger.error("cityName is null.");
            return null;
        }

        /**
         * 获取或新建城市
         */
        City city = cityService.queryByConditionWithSave(cityName);
        if (city == null) {
            logger.error("get city by cityService with save is null, cityName = " + cityName);
            return null;
        }
        Long cityId = city.getId();

        /**
         * 获取或新建公司
         */
        Company company = companyService.queryByNamePreciseWithSave(companyName);
        if (company == null) {
            logger.error("get company by companyService  with save is null, companyName = " + companyName);
            return null;
        }
        Long companyId = company.getId();

        /**
         * 获取或新建小区
         */
        Community community = communityService.queryByNamePreciseWithSave(communityName);
        if (community == null) {
            logger.error("get community by communityService  with save is null, communityName = " + communityName);
            return null;
        }
        Long communityId = community.getId();

        return queryByWholeConditionWithSave(cityId, companyId, communityId);
    }


    /**
     * 根据三个条件返回关系，如果已存在该组合则直接返回，否则新建并返回
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
    public RelationCityCompanyCommunity queryByWholeConditionWithSave(Long cityId, Long companyId, Long communityId) {

        if (cityId == null || companyId == null || communityId == null) {
            logger.error("queryByWholeConditionWithSave: cityId, companyId, communityId can not be null, cityId = "
                + cityId + ", companyId = " + companyId + ", communityId = " + communityId);
            return null;
        }

        /**
         * 存在则返回关系
         */
        List<RelationCityCompanyCommunity> relationExistList = relationCityCompanyCommunityDao.queryByCondition(cityId,
                companyId, communityId);
        if(CollectionUtils.isNotEmpty(relationExistList)) {
            logger.error("queryByWholeConditionWithSave: relationExistList is not unique, cityId = " + cityId
                    + ", companyId = " + companyId + ", communityId = " + communityId);
            return relationExistList.get(0);
        }

        /**
         * 不存在则新建
         */
        Long id = saveRelation(cityId, companyId, communityId);
        if (id == null) {
            logger.error("queryByWholeConditionWithSave: get id by saveRelation is null, cityId = " + cityId
                    + ", companyId = " + companyId + ", communityId = " + communityId);
            return null;
        }
        return findById(id);
    }

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
    public List<RelationCityCompanyCommunity> queryByCondition(Long cityId, Long companyId, Long communityId) {
        return relationCityCompanyCommunityDao.queryByCondition(cityId, companyId, communityId);
    }

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
    public Long saveRelation(Long cityId, Long companyId, Long communityId) {
        if (cityId == null || companyId == null || communityId == null) {
            logger.error("saveRelation: cityId, companyId, communityId can not be null, cityId = " + cityId
                    + ", companyId = " + companyId + ", communityId = " + communityId);
            return null;
        }

        RelationCityCompanyCommunity relation = new RelationCityCompanyCommunity();
        relation.setCityId(cityId);
        relation.setCompanyId(companyId);
        relation.setCommunityId(communityId);
        SaveAndUpdateUtils.setCommonFieldsWhenSave(relation);

        return saveEntity(relation);
    }

    @Override
    public SqlMapDao<RelationCityCompanyCommunity, Long> getDao() {
        return relationCityCompanyCommunityDao;
    }
}
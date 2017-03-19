package com.henrrycheng.chyftt.intermediary.community.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dao.CommunityDao;
import com.henrrycheng.chyftt.intermediary.community.dto.CommunityQueryDto;
import com.henrrycheng.chyftt.intermediary.community.service.CommunityService;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.community.constant.CommunityTypeEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
@Service("communityService")
public class CommunityServiceImpl extends GenericSqlMapServiceImpl<Community, Long> implements CommunityService {

    private static final Logger logger = Logger.getLogger(CommunityServiceImpl.class);

    /**
     * Dao 'communityDao' reference.
     */
    @Resource(name = "communityDao")
    private CommunityDao communityDao;

    /**
     * 根据条件查询
     *
     * @param community
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    public List<Community> queryByCondition(CommunityQueryDto community) {
        return communityDao.queryByCondition(community);
    }

    /**
     * 根据名称精确查询
     *
     * @param communityName
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    public Community queryByNamePrecise(String communityName) {
        List<Community> communityList = queryByName(communityName, false);
        if (CollectionUtils.isEmpty(communityList)) {
            logger.warn("queryByNamePrecise: get communityList by queryByName is empty, communityName = " + communityName);
            return null;
        }
        return communityList.get(0);
    }

    /**
     * 根据名称精确查询，如果不存在则新建
     *
     * @param communityName
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    public Community queryByNamePreciseWithSave(String communityName) {
        Community communityByQuery = queryByNamePrecise(communityName);
        if (communityByQuery != null) {
            return communityByQuery;
        }
        Long id = saveCommunity(communityName);
        if (id == null) {
            logger.error("get id by saveCommunity is null, communityName = " + communityName);
            return null;
        }
        return findById(id);
    }

    /**
     * 根据名称模糊查询
     *
     * @param communityName
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    public List<Community> queryByNameFuzzy(String communityName) {
        return queryByName(communityName, true);
    }

    /**
     * 新增公司
     *
     * @param communityName
     *
     * @return id
     *
     * @author chengyong
     */
    public Long saveCommunity(String communityName) {
        Community community = new Community();
        community.setName(communityName);
        return saveCommunity(community);
    }

    /**
     * 新增公司
     *
     * @param community
     *
     * @return id
     *
     * @author chengyong
     */
    public Long saveCommunity(Community community) {
        if (community == null) {
            logger.warn("community is null, not save.");
            return null;
        }
        if (StringUtils.isEmpty(community.getName())) {
            logger.warn("communityName is null, not save.");
            return null;
        }
        if (community.getType() == null) {
            community.setType(CommunityTypeEnum.INTERMEDIARY.getCode());
        }
        if (StringUtils.isEmpty(community.getLocation())) {
            community.setLocation(StringUtils.EMPTY);
        }
        if (StringUtils.isEmpty(community.getDescription())) {
            community.setDescription(StringUtils.EMPTY);
        }
        if (StringUtils.isEmpty(community.getDescriptionSource())) {
            community.setDescriptionSource(StringUtils.EMPTY);
        }
        SaveAndUpdateUtils.setCommonFieldsWhenSave(community);
        return saveEntity(community);
    }

    /**
     * 根据公司名称查询
     *
     * @param communityName
     *
     * @param isFuzzy 是否模糊
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    private List<Community> queryByName(String communityName, boolean isFuzzy) {
        if (StringUtils.isEmpty(communityName)) {
            logger.warn("queryByName is null.");
            return Collections.emptyList();
        }
        CommunityQueryDto communityQueryDto = new CommunityQueryDto();
        communityQueryDto.setName(communityName);
        communityQueryDto.setNameIsFuzzy(isFuzzy);
        return communityDao.queryByCondition(communityQueryDto);
    }

    @Override
    public SqlMapDao<Community, Long> getDao() {
        return communityDao;
    }
}
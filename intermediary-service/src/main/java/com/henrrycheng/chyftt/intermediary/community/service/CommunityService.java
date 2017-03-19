package com.henrrycheng.chyftt.intermediary.community.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dto.CommunityQueryDto;

import java.util.List;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
public interface CommunityService extends GenericService<Community, Long> {

    /**
     * 根据条件查询
     *
     * @param community
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    List<Community> queryByCondition(CommunityQueryDto community);

    /**
     * 根据小区名称精确查询
     *
     * @param communityName
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    Community queryByNamePrecise(String communityName);

    /**
     * 根据小区名称模糊查询
     *
     * @param communityName
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    List<Community> queryByNameFuzzy(String communityName);

    /**
     * 根据小区名称精确查询，如果不存在则新建
     *
     * @param communityName
     *
     * @return List<Community>
     *
     * @author chengyong
     */
    Community queryByNamePreciseWithSave(String communityName);

    /**
     * 新增小区
     *
     * @param communityName
     *
     * @return id
     *
     * @author chengyong
     */
    Long saveCommunity(String communityName);

    /**
     * 新增小区
     *
     * @param community
     *
     * @return id
     *
     * @author chengyong
     */
    Long saveCommunity(Community community);
}
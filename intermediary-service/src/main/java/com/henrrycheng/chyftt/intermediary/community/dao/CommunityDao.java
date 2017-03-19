package com.henrrycheng.chyftt.intermediary.community.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dto.CommunityQueryDto;

import java.util.List;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
public interface CommunityDao extends SqlMapDao<Community, Long> {

    List<Community> queryByCondition(CommunityQueryDto community);
}
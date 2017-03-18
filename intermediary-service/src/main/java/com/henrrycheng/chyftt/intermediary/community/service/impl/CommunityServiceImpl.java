package com.henrrycheng.chyftt.intermediary.community.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dao.CommunityDao;
import com.henrrycheng.chyftt.intermediary.community.service.CommunityService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
@Service("communityService")
public class CommunityServiceImpl extends GenericSqlMapServiceImpl<Community, Long> implements CommunityService {
    /**
     * Dao 'communityDao' reference.
     */
    @Resource(name = "communityDao")
    private CommunityDao communityDao;

    @Override
    public SqlMapDao<Community, Long> getDao() {
        return communityDao;
    }
}
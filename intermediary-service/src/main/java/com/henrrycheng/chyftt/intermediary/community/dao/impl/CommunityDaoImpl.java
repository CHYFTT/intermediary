package com.henrrycheng.chyftt.intermediary.community.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dao.CommunityDao;
import com.henrrycheng.chyftt.intermediary.community.dao.CommunityMapper;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.community.dto.CommunityQueryDto;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
@Service("communityDao")
public class CommunityDaoImpl extends ConfigurableBaseSqlMapDao<Community, Long> implements CommunityDao {
    /**
     * DaoMapper 'communityMapper' reference.
     */
    @Autowired
    private CommunityMapper communityMapper;

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
        if (community == null) {
            return Collections.emptyList();
        }
        return communityMapper.queryByCondition(community);
    }

    @Override
    public DaoMapper<Community, Long> getDaoMapper() {
        return communityMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}
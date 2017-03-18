package com.henrrycheng.chyftt.intermediary.community.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dao.CommunityDao;
import com.henrrycheng.chyftt.intermediary.community.dao.CommunityMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public DaoMapper<Community, Long> getDaoMapper() {
        return communityMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Resource(name = "sqlSessionTemplate")
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        setSqlSessionTemplateInternal(sqlSessionTemplate);
    }
}
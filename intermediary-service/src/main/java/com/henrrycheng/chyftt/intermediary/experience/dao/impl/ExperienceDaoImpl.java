package com.henrrycheng.chyftt.intermediary.experience.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.experience.bo.Experience;
import com.henrrycheng.chyftt.intermediary.experience.dao.ExperienceDao;
import com.henrrycheng.chyftt.intermediary.experience.dao.ExperienceMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.experience.bo.ExperienceBase
 * @author chengyong
 */
@Service("experienceDao")
public class ExperienceDaoImpl extends ConfigurableBaseSqlMapDao<Experience, Long> implements ExperienceDao {
    /**
     * DaoMapper 'experienceMapper' reference.
     */
    @Autowired
    private ExperienceMapper experienceMapper;

    @Override
    public DaoMapper<Experience, Long> getDaoMapper() {
        return experienceMapper;
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
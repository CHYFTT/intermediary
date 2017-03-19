package com.henrrycheng.chyftt.intermediary.experienceInteraction.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.bo.ExperienceInteraction;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.dao.ExperienceInteractionDao;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.dao.ExperienceInteractionMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.experienceInteraction.bo.ExperienceInteractionBase
 * @author chengyong
 */
@Service("experienceInteractionDao")
public class ExperienceInteractionDaoImpl extends ConfigurableBaseSqlMapDao<ExperienceInteraction, Long> implements ExperienceInteractionDao {
    /**
     * DaoMapper 'experienceInteractionMapper' reference.
     */
    @Autowired
    private ExperienceInteractionMapper experienceInteractionMapper;

    @Override
    public DaoMapper<ExperienceInteraction, Long> getDaoMapper() {
        return experienceInteractionMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}
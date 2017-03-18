package com.henrrycheng.chyftt.intermediary.experienceComment.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.experienceComment.bo.ExperienceComment;
import com.henrrycheng.chyftt.intermediary.experienceComment.dao.ExperienceCommentDao;
import com.henrrycheng.chyftt.intermediary.experienceComment.dao.ExperienceCommentMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.experienceComment.bo.ExperienceCommentBase
 * @author chengyong
 */
@Service("experienceCommentDao")
public class ExperienceCommentDaoImpl extends ConfigurableBaseSqlMapDao<ExperienceComment, Long> implements ExperienceCommentDao {
    /**
     * DaoMapper 'experienceCommentMapper' reference.
     */
    @Autowired
    private ExperienceCommentMapper experienceCommentMapper;

    @Override
    public DaoMapper<ExperienceComment, Long> getDaoMapper() {
        return experienceCommentMapper;
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
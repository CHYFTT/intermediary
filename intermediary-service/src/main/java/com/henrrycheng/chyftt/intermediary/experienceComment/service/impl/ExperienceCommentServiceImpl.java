package com.henrrycheng.chyftt.intermediary.experienceComment.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.experienceComment.bo.ExperienceComment;
import com.henrrycheng.chyftt.intermediary.experienceComment.dao.ExperienceCommentDao;
import com.henrrycheng.chyftt.intermediary.experienceComment.service.ExperienceCommentService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.experienceComment.bo.ExperienceCommentBase
 * @author chengyong
 */
@Service("experienceCommentService")
public class ExperienceCommentServiceImpl extends GenericSqlMapServiceImpl<ExperienceComment, Long> implements ExperienceCommentService {
    /**
     * Dao 'experienceCommentDao' reference.
     */
    @Resource(name = "experienceCommentDao")
    private ExperienceCommentDao experienceCommentDao;

    @Override
    public SqlMapDao<ExperienceComment, Long> getDao() {
        return experienceCommentDao;
    }
}
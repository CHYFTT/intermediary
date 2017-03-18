package com.henrrycheng.chyftt.intermediary.experienceInteraction.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.bo.ExperienceInteraction;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.dao.ExperienceInteractionDao;
import com.henrrycheng.chyftt.intermediary.experienceInteraction.service.ExperienceInteractionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.experienceInteraction.bo.ExperienceInteractionBase
 * @author chengyong
 */
@Service("experienceInteractionService")
public class ExperienceInteractionServiceImpl extends GenericSqlMapServiceImpl<ExperienceInteraction, Long> implements ExperienceInteractionService {
    /**
     * Dao 'experienceInteractionDao' reference.
     */
    @Resource(name = "experienceInteractionDao")
    private ExperienceInteractionDao experienceInteractionDao;

    @Override
    public SqlMapDao<ExperienceInteraction, Long> getDao() {
        return experienceInteractionDao;
    }
}
package com.henrrycheng.chyftt.intermediary.experience.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.experience.bo.Experience;
import com.henrrycheng.chyftt.intermediary.experience.dao.ExperienceDao;
import com.henrrycheng.chyftt.intermediary.experience.service.ExperienceService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.experience.bo.ExperienceBase
 * @author chengyong
 */
@Service("experienceService")
public class ExperienceServiceImpl extends GenericSqlMapServiceImpl<Experience, Long> implements ExperienceService {
    /**
     * Dao 'experienceDao' reference.
     */
    @Resource(name = "experienceDao")
    private ExperienceDao experienceDao;

    @Override
    public SqlMapDao<Experience, Long> getDao() {
        return experienceDao;
    }
}
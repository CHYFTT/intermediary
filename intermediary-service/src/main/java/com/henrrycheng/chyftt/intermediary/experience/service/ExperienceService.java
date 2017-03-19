package com.henrrycheng.chyftt.intermediary.experience.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.common.Result;
import com.henrrycheng.chyftt.intermediary.exception.UserAppException;
import com.henrrycheng.chyftt.intermediary.experience.bo.Experience;
import com.henrrycheng.chyftt.intermediary.experience.dto.formDto.ExperienceFormDto;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.experience.bo.ExperienceBase
 *
 * @author chengyong
 */
public interface ExperienceService extends GenericService<Experience, Long> {

    /**
     * 保存新的经验反馈
     *
     * @param experienceFormDto
     *
     * @return 成功：experienceSavedId，失败：原因
     *
     * @author chengyong
     */
    Result saveExperienceResult(ExperienceFormDto experienceFormDto);

    /**
     * 保存新的经验反馈
     *
     * @param experienceFormDto
     *
     * @return 刚保存成功的id
     *
     * @author chengyong
     */
    Long saveExperience(ExperienceFormDto experienceFormDto) throws UserAppException;
}
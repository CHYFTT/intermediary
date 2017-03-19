package com.henrrycheng.chyftt.intermediary.experience.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.bo.RelationCityCompanyCommunity;
import com.henrrycheng.chyftt.intermediary.cityCompanyCommunityRelation.service.RelationCityCompanyCommunityService;
import com.henrrycheng.chyftt.intermediary.common.Result;
import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import com.henrrycheng.chyftt.intermediary.exception.UserAppException;
import com.henrrycheng.chyftt.intermediary.experience.bo.Experience;
import com.henrrycheng.chyftt.intermediary.experience.dao.ExperienceDao;
import com.henrrycheng.chyftt.intermediary.experience.dto.formDto.ExperienceFormDto;
import com.henrrycheng.chyftt.intermediary.experience.dto.viewDto.ExperienceViewDto;
import com.henrrycheng.chyftt.intermediary.experience.service.ExperienceService;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.experienceFraudRelation.service.RelationExperienceFraudService;
import com.henrrycheng.chyftt.intermediary.fraudMeans.bo.FraudMeans;
import com.henrrycheng.chyftt.intermediary.fraudMeans.service.FraudMeansService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.experience.bo.ExperienceBase
 * @author chengyong
 */
@Service("experienceService")
public class ExperienceServiceImpl extends GenericSqlMapServiceImpl<Experience, Long> implements ExperienceService {

    private static final Logger logger = Logger.getLogger(ExperienceServiceImpl.class);

    /**
     * Dao 'experienceDao' reference.
     */
    @Resource(name = "experienceDao")
    private ExperienceDao experienceDao;

    @Resource(name = "relationCityCompanyCommunityService")
    private RelationCityCompanyCommunityService relationCityCompanyCommunityService;

    @Resource(name = "relationExperienceFraudService")
    private RelationExperienceFraudService relationExperienceFraudService;

    /**
     * 保存新的经验反馈
     *
     * @param experienceFormDto
     *
     * @return 成功：experienceSavedId，失败：原因
     *
     * @author chengyong
     */
    public Result saveExperienceResult(ExperienceFormDto experienceFormDto) {

        Result result = new Result();

        try {

            Long experienceSavedId = saveExperience(experienceFormDto);
            result.setSuccess(true);
            result.setSuccessReturnValue(experienceSavedId);

        } catch (UserAppException e) {
            logger.warn("saveExperienceResult: expected error, experienceFormDto = " + experienceFormDto);
            result.setSuccess(false);
            result.setErrorMessage(e.getUserMessage());
        } catch (Exception e) {
            logger.warn("saveExperienceResult: expected error, experienceFormDto = " + experienceFormDto);
            result.setSuccess(false);
            result.setErrorMessage("保存吐槽记录失败，请稍候重试");
        }

        return result;
    }


    /**
     * 保存新的吐槽
     *
     * @param experienceFormDto
     *
     * @return ExperienceViewDto
     *
     * @author chengyong
     */
    public Long saveExperience(ExperienceFormDto experienceFormDto) throws UserAppException {

        /**
         * 将 experienceFormDto 转换为 Experience
         */
        Experience experience = convert2Experience(experienceFormDto);
        if (experience == null) {
            throw new UserAppException("saveExperience: get experience by convert2Experience is null",
                    "转存吐槽记录时出错，请稍候重试");
        }

        /**
         * 保存 experience
         */
        Long experienceSavedId = saveEntity(experience);
        if (experienceSavedId == null) {
            throw new UserAppException("saveExperience: get id by saveEntity is null", "保存吐槽记录时失败，请稍候重试");
        }

        /**
         * 保存吐槽和欺骗手段关系
         */
        relationExperienceFraudService.saveRelationWithName(experienceSavedId, experienceFormDto.getFraudMeansList());

        return experienceSavedId;
    }

    /**
     * 将 experience 转换为 ExperienceViewDto
     *
     * @param experience
     *
     * @return ExperienceViewDto
     */
    private ExperienceViewDto convert2ViewDto(Experience experience) {
        if (experience == null) {
            logger.error("convert2ViewDto: experience is null.");
            return null;
        }

        ExperienceViewDto experienceViewDto = new ExperienceViewDto();

        /**
         * TODO 转换
         */
        return experienceViewDto;
    }

    /**
     * 将 experienceFormDto 转换为 Experience
     *
     * @param experienceFormDto
     *
     * @return Experience
     */
    private Experience convert2Experience(ExperienceFormDto experienceFormDto) {

        if (experienceFormDto == null) {
            throw new UserAppException("saveExperience: experienceFormDto is null", "表单为空，无法保存");
        }
        String cityName = experienceFormDto.getCityName();
        String companyName = experienceFormDto.getCompanyName();
        String communityName = experienceFormDto.getCommunityName();

        if (StringUtils.isEmpty(cityName)) {
            throw new UserAppException("saveExperience: cityName is null", "请输入城市");
        }
        if (StringUtils.isEmpty(companyName)) {
            throw new UserAppException("saveExperience: companyName is null", "请输入中介公司名称");
        }
        if (StringUtils.isEmpty(communityName)) {
            throw new UserAppException("saveExperience: communityName is null", "请输入所在小区");
        }

        RelationCityCompanyCommunity relationCityCompanyCommunity =
                relationCityCompanyCommunityService.queryByWholeConditionWithSave(cityName, companyName, communityName);
        if (relationCityCompanyCommunity == null) {
            logger.error("saveExperience: get relationCityCompanyCommunity is null, experienceFormDto = "
                    + experienceFormDto);
            throw new UserAppException("saveExperience:  get relationCityCompanyCommunity is null", "保存城市、公司、"
                    + "小区时出错，请稍候重试");
        }

        Experience experience = new Experience();
        experience.setLocationId(relationCityCompanyCommunity.getId());
        experience.setContent(experienceFormDto.getContent());
        experience.setScore(experienceFormDto.getScore());

        /**
         * 初始数值
         */
        experience.setCountComment(0L);
        experience.setCountAgree(0L);
        experience.setCountDisagree(0L);
        experience.setCountRead(1L);

        SaveAndUpdateUtils.setCommonFieldsWhenSave(experience);
        return experience;
    }

    @Override
    public SqlMapDao<Experience, Long> getDao() {
        return experienceDao;
    }
}
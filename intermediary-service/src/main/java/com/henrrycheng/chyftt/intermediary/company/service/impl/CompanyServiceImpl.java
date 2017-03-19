package com.henrrycheng.chyftt.intermediary.company.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.common.utils.SaveAndUpdateUtils;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.constant.CompanyTypeEnum;
import com.henrrycheng.chyftt.intermediary.company.dao.CompanyDao;
import com.henrrycheng.chyftt.intermediary.company.dto.CompanyQueryDto;
import com.henrrycheng.chyftt.intermediary.company.service.CompanyService;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
@Service("companyService")
public class CompanyServiceImpl extends GenericSqlMapServiceImpl<Company, Long> implements CompanyService {

    private static final Logger logger = Logger.getLogger(CompanyServiceImpl.class);

    /**
     * Dao 'companyDao' reference.
     */
    @Resource(name = "companyDao")
    private CompanyDao companyDao;

    /**
     * 根据条件查询
     *
     * @param company
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    public List<Company> queryByCondition(CompanyQueryDto company) {
        return companyDao.queryByCondition(company);
    }

    /**
     * 根据公司名称精确查询
     *
     * @param companyName
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    public Company queryByNamePrecise(String companyName) {
        List<Company> companyList = queryByName(companyName, false);
        if (CollectionUtils.isEmpty(companyList)) {
            logger.warn("queryByNamePrecise: get companyList by queryByName is empty, companyName = " + companyName);
            return null;
        }
        return companyList.get(0);
    }

    /**
     * 根据公司名称精确查询，如果不存在则新建
     *
     * @param companyName
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    public Company queryByNamePreciseWithSave(String companyName) {
        Company companyByQuery = queryByNamePrecise(companyName);
        if (companyByQuery != null) {
            return companyByQuery;
        }
        Long id = saveCompany(companyName);
        if (id == null) {
            logger.error("get id by saveCompany is null, companyName = " + companyName);
            return null;
        }
        return findById(id);
    }

    /**
     * 根据公司名称模糊查询
     *
     * @param companyName
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    public List<Company> queryByNameFuzzy(String companyName) {
        return queryByName(companyName, true);
    }

    /**
     * 新增公司
     *
     * @param companyName
     *
     * @return id
     *
     * @author chengyong
     */
    public Long saveCompany(String companyName) {
        Company company = new Company();
        company.setName(companyName);
        return saveCompany(company);
    }

    /**
     * 新增公司
     *
     * @param company
     *
     * @return id
     *
     * @author chengyong
     */
    public Long saveCompany(Company company) {
        if (company == null) {
            logger.warn("company is null, not save.");
            return null;
        }
        if (StringUtils.isEmpty(company.getName())) {
            logger.warn("companyName is null, not save.");
            return null;
        }
        if (company.getType() == null) {
            company.setType(CompanyTypeEnum.INTERMEDIARY.getCode());
        }
        if (company.getBlackScoreOverall() == null) {
            company.setBlackScoreOverall(0L);
        }
        if (StringUtils.isEmpty(company.getLeader())) {
            company.setLeader(StringUtils.EMPTY);
        }
        if (StringUtils.isEmpty(company.getDescription())) {
            company.setDescription(StringUtils.EMPTY);
        }
        if (StringUtils.isEmpty(company.getDescriptionSource())) {
            company.setDescriptionSource(StringUtils.EMPTY);
        }
        SaveAndUpdateUtils.setCommonFieldsWhenSave(company);
        return saveEntity(company);
    }

    /**
     * 根据公司名称查询
     *
     * @param companyName
     *
     * @param isFuzzy 是否模糊
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    private List<Company> queryByName(String companyName, boolean isFuzzy) {
        if (StringUtils.isEmpty(companyName)) {
            logger.warn("queryByName is null.");
            return Collections.emptyList();
        }
        CompanyQueryDto companyQueryDto = new CompanyQueryDto();
        companyQueryDto.setName(companyName);
        companyQueryDto.setNameFuzzy(isFuzzy);
        return companyDao.queryByCondition(companyQueryDto);
    }

    @Override
    public SqlMapDao<Company, Long> getDao() {
        return companyDao;
    }
}
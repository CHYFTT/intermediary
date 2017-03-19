package com.henrrycheng.chyftt.intermediary.company.service;

import com.baidu.bjf.service.GenericService;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.dto.CompanyQueryDto;

import java.util.List;

/**
 * Service interface class for model com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
public interface CompanyService extends GenericService<Company, Long> {

    /**
     * 根据条件查询
     *
     * @param company
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    List<Company> queryByCondition(CompanyQueryDto company);

    /**
     * 根据公司名称精确查询
     *
     * @param companyName
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    Company queryByNamePrecise(String companyName);

    /**
     * 根据公司名称模糊查询
     *
     * @param companyName
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    List<Company> queryByNameFuzzy(String companyName);

    /**
     * 根据公司名称精确查询，如果不存在则新建
     *
     * @param companyName
     *
     * @return List<Company>
     *
     * @author chengyong
     */
    Company queryByNamePreciseWithSave(String companyName);

    /**
     * 新增公司
     *
     * @param companyName
     *
     * @return id
     *
     * @author chengyong
     */
    Long saveCompany(String companyName);

    /**
     * 新增公司
     *
     * @param company
     *
     * @return id
     *
     * @author chengyong
     */
    Long saveCompany(Company company);
}
package com.henrrycheng.chyftt.intermediary.company.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.dto.CompanyQueryDto;

import java.util.List;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
public interface CompanyDao extends SqlMapDao<Company, Long> {

    List<Company> queryByCondition(CompanyQueryDto company);
}
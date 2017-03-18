package com.henrrycheng.chyftt.intermediary.company.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
@SqlMapper
public interface CompanyMapper extends DaoMapper<Company, Long> {
}
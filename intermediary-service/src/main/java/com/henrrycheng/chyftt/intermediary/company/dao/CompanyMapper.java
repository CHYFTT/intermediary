package com.henrrycheng.chyftt.intermediary.company.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.dto.CompanyQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
@SqlMapper
public interface CompanyMapper extends DaoMapper<Company, Long> {

    List<Company> queryByCondition(@Param("company") CompanyQueryDto company);
}
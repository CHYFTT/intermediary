package com.henrrycheng.chyftt.intermediary.company.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.dao.CompanyDao;
import com.henrrycheng.chyftt.intermediary.company.service.CompanyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
@Service("companyService")
public class CompanyServiceImpl extends GenericSqlMapServiceImpl<Company, Long> implements CompanyService {
    /**
     * Dao 'companyDao' reference.
     */
    @Resource(name = "companyDao")
    private CompanyDao companyDao;

    @Override
    public SqlMapDao<Company, Long> getDao() {
        return companyDao;
    }
}
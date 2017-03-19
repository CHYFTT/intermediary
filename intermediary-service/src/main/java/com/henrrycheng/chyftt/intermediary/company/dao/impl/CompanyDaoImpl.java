package com.henrrycheng.chyftt.intermediary.company.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.dao.CompanyDao;
import com.henrrycheng.chyftt.intermediary.company.dao.CompanyMapper;
import javax.annotation.Resource;

import com.henrrycheng.chyftt.intermediary.company.dto.CompanyQueryDto;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.company.bo.CompanyBase
 * @author chengyong
 */
@Service("companyDao")
public class CompanyDaoImpl extends ConfigurableBaseSqlMapDao<Company, Long> implements CompanyDao {
    /**
     * DaoMapper 'companyMapper' reference.
     */
    @Autowired
    private CompanyMapper companyMapper;

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
        if (company == null) {
            return Collections.emptyList();
        }
        return companyMapper.queryByCondition(company);
    }

    @Override
    public DaoMapper<Company, Long> getDaoMapper() {
        return companyMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}
package com.henrrycheng.chyftt.intermediary.company.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.company.bo.Company;
import com.henrrycheng.chyftt.intermediary.company.dao.CompanyDao;
import com.henrrycheng.chyftt.intermediary.company.dao.CompanyMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public DaoMapper<Company, Long> getDaoMapper() {
        return companyMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Resource(name = "sqlSessionTemplate")
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        setSqlSessionTemplateInternal(sqlSessionTemplate);
    }
}
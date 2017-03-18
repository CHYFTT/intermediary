package com.henrrycheng.chyftt.intermediary.contacts.dao.impl;

import com.baidu.bjf.dao.ConfigurableBaseSqlMapDao;
import com.baidu.bjf.dao.DaoMapper;
import com.henrrycheng.chyftt.intermediary.contacts.bo.Contacts;
import com.henrrycheng.chyftt.intermediary.contacts.dao.ContactsDao;
import com.henrrycheng.chyftt.intermediary.contacts.dao.ContactsMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Dao implement class for model : com.henrrycheng.chyftt.intermediary.contacts.bo.ContactsBase
 * @author chengyong
 */
@Service("contactsDao")
public class ContactsDaoImpl extends ConfigurableBaseSqlMapDao<Contacts, Long> implements ContactsDao {
    /**
     * DaoMapper 'contactsMapper' reference.
     */
    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public DaoMapper<Contacts, Long> getDaoMapper() {
        return contactsMapper;
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
package com.henrrycheng.chyftt.intermediary.contacts.service.impl;

import com.baidu.bjf.dao.SqlMapDao;
import com.baidu.bjf.service.GenericSqlMapServiceImpl;
import com.henrrycheng.chyftt.intermediary.contacts.bo.Contacts;
import com.henrrycheng.chyftt.intermediary.contacts.dao.ContactsDao;
import com.henrrycheng.chyftt.intermediary.contacts.service.ContactsService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implement class for model : com.henrrycheng.chyftt.intermediary.contacts.bo.ContactsBase
 * @author chengyong
 */
@Service("contactsService")
public class ContactsServiceImpl extends GenericSqlMapServiceImpl<Contacts, Long> implements ContactsService {
    /**
     * Dao 'contactsDao' reference.
     */
    @Resource(name = "contactsDao")
    private ContactsDao contactsDao;

    @Override
    public SqlMapDao<Contacts, Long> getDao() {
        return contactsDao;
    }
}
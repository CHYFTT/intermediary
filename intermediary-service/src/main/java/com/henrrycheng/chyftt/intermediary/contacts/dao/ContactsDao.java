package com.henrrycheng.chyftt.intermediary.contacts.dao;

import com.baidu.bjf.dao.SqlMapDao;
import com.henrrycheng.chyftt.intermediary.contacts.bo.Contacts;

/**
 * Dao interface class for model com.henrrycheng.chyftt.intermediary.contacts.bo.ContactsBase
 * @author chengyong
 */
public interface ContactsDao extends SqlMapDao<Contacts, Long> {
}
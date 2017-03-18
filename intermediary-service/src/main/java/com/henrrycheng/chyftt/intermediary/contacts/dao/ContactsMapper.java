package com.henrrycheng.chyftt.intermediary.contacts.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.contacts.bo.Contacts;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.contacts.bo.ContactsBase
 * @author chengyong
 */
@SqlMapper
public interface ContactsMapper extends DaoMapper<Contacts, Long> {
}
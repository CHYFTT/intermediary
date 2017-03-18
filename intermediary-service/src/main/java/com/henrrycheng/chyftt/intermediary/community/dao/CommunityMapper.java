package com.henrrycheng.chyftt.intermediary.community.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
@SqlMapper
public interface CommunityMapper extends DaoMapper<Community, Long> {
}
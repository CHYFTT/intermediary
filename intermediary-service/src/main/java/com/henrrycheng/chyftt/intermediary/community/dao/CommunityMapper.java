package com.henrrycheng.chyftt.intermediary.community.dao;

import com.baidu.bjf.dao.DaoMapper;
import com.baidu.bjf.orm.mybatis.SqlMapper;
import com.henrrycheng.chyftt.intermediary.community.bo.Community;
import com.henrrycheng.chyftt.intermediary.community.dto.CommunityQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper interface class for model com.henrrycheng.chyftt.intermediary.community.bo.CommunityBase
 * @author chengyong
 */
@SqlMapper
public interface CommunityMapper extends DaoMapper<Community, Long> {

    List<Community> queryByCondition(@Param("community") CommunityQueryDto community);
}
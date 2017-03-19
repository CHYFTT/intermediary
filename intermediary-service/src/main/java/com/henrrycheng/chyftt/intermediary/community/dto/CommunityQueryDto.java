package com.henrrycheng.chyftt.intermediary.community.dto;

import com.henrrycheng.chyftt.intermediary.community.bo.Community;

import java.io.Serializable;

/**
 * Created by chengyong on 17/3/19.
 */
public class CommunityQueryDto extends Community implements Serializable {

    private static final long serialVersionUID = 453L;

    /**
     * 名称是否模糊查询
     */
    private boolean nameIsFuzzy;

    public boolean isNameIsFuzzy () {
        return nameIsFuzzy;
    }

    public void setNameIsFuzzy (boolean nameIsFuzzy) {
        this.nameIsFuzzy = nameIsFuzzy;
    }
}

package com.henrrycheng.chyftt.intermediary.community.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 小区类型
 *
 * Created by chengyong on 17/3/19.
 */
public enum CommunityTypeEnum {

    INTERMEDIARY(10L, "商品房"),

    AGENCY(20L, "回迁房");

    private Long code;
    private String desc;

    /**
     * 根据code查询描述
     *
     * @param code
     *
     * @return desc
     */
    public static String getDescByCode(Long code) {

        if (code == null) {
            return StringUtils.EMPTY;
        }

        for (CommunityTypeEnum typeEnum : CommunityTypeEnum.values()) {
            if (code.equals(typeEnum.getCode())) {
                return typeEnum.getDesc();
            }
        }
        return StringUtils.EMPTY;
    }

    CommunityTypeEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode () {
        return code;
    }

    public void setCode (Long code) {
        this.code = code;
    }

    public String getDesc () {
        return desc;
    }

    public void setDesc (String desc) {
        this.desc = desc;
    }
}

package com.henrrycheng.chyftt.intermediary.company.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 租房公司类型
 *
 * Created by chengyong on 17/3/19.
 */
public enum CompanyTypeEnum {

    INTERMEDIARY(10L, "中介"),

    AGENCY(20L, "代理"),

    LANDLORD(30L, "个人房东");

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

        for (CompanyTypeEnum typeEnum : CompanyTypeEnum.values()) {
            if (code.equals(typeEnum.getCode())) {
                return typeEnum.getDesc();
            }
        }
        return StringUtils.EMPTY;
    }

    CompanyTypeEnum(Long code, String desc) {
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

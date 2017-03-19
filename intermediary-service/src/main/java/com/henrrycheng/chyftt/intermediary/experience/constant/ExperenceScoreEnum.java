package com.henrrycheng.chyftt.intermediary.experience.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 单次吐槽记录黑心指数
 *
 * Created by chengyong on 17/3/19.
 */
public enum ExperenceScoreEnum {

    ONE(1L, "凑合"),
    TWO(2L, "还行"),
    THREE(3L, "一般"),
    FOUR(4L, "有点坑"),
    FIVE(5L, "坑"),
    SIX(6L, "太坑"),
    SEVEN(7L, "巨坑"),
    EGIHT(8L, "一袋奸雄"),
    NINE(9L, "奸诈无比"),
    TEN(10L, "不凌迟处死不解恨");

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

        for (ExperenceScoreEnum typeEnum : ExperenceScoreEnum.values()) {
            if (code.equals(typeEnum.getCode())) {
                return typeEnum.getDesc();
            }
        }
        return StringUtils.EMPTY;
    }

    ExperenceScoreEnum (Long code, String desc) {
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

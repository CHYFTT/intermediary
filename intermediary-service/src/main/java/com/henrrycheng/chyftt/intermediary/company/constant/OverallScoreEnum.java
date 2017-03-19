package com.henrrycheng.chyftt.intermediary.company.constant;

/**
 * 中介公司黑心指数评分
 *
 * Created by chengyong on 17/3/19.
 */
public enum OverallScoreEnum {

    ONE(0L, 10L, "凑合"),
    TWO(10L, 20L, "还行"),
    THREE(20L, 30L,"一般"),
    FOUR(30L, 55L,"有点坑"),
    FIVE(55L, 70L, "坑"),
    SIX(70L, 80L, "太坑"),
    SEVEN(80L, 85L, "巨坑"),
    EGIHT(85L, 90L, "一代奸雄"),
    NINE(90L, 95L, "奸诈无比"),
    TEN(95L, 100L, "不凌迟处死不解恨");

    /**
     * 黑心指数区间-左值-包含
     */
    private Long startClosed;

    /**
     * 黑心指数区间-右值-不包含
     */
    private Long endOpen;

    /**
     * 黑心指数值
     */
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
            return "暂无总评分";
        }

        for (OverallScoreEnum typeEnum : OverallScoreEnum.values()) {
            if (code.intValue() >= typeEnum.getStartClosed() && code.intValue() < typeEnum.getEndOpen()) {
                return typeEnum.getDesc();
            }
        }
        return "无法形容的坑";
    }

    OverallScoreEnum (Long start, Long end, String desc) {
        this.startClosed = start;
        this.endOpen = end;
        this.desc = desc;
    }

    public Long getStartClosed () {
        return startClosed;
    }

    public void setStartClosed (Long startClosed) {
        this.startClosed = startClosed;
    }

    public Long getEndOpen () {
        return endOpen;
    }

    public void setEndOpen (Long endOpen) {
        this.endOpen = endOpen;
    }

    public String getDesc () {
        return desc;
    }

    public void setDesc (String desc) {
        this.desc = desc;
    }
}

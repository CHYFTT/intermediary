package com.henrrycheng.chyftt.intermediary.company.dto;

import com.henrrycheng.chyftt.intermediary.company.bo.Company;

import java.io.Serializable;

/**
 * Created by chengyong on 17/3/19.
 */
public class CompanyQueryDto extends Company implements Serializable {

    private static final long serialVersionUID = 453L;

    /**
     * 公司名称是否模糊查询
     */
    private boolean isNameFuzzy;

    public boolean isNameFuzzy () {
        return isNameFuzzy;
    }

    public void setNameFuzzy (boolean nameFuzzy) {
        isNameFuzzy = nameFuzzy;
    }
}

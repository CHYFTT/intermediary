package com.henrrycheng.chyftt.intermediary.experience.dto.viewDto;

import com.henrrycheng.chyftt.intermediary.contacts.dto.ContactDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chengyong on 17/3/18.
 */
public class ExperienceViewDto implements Serializable {

    private static final long serialVersionUID = -1L;


    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 小区名称
     */
    private String communityName;

    /**
     * 联系人列表，包含contactName、contactMobile
     */
    private List<ContactDto> contactList;

    /**
     * 事情经过内容
     */
    private String content;

    /**
     * 被欺骗的方式
     */
    private List<String> fraudMeansList;

    /**
     * 黑心指数
     */
    private Integer score;

    /**
     * 黑心指数
     */
    private String scoreDesc;

    public String getCityName () {
        return cityName;
    }

    public void setCityName (String cityName) {
        this.cityName = cityName;
    }

    public String getCompanyName () {
        return companyName;
    }

    public void setCompanyName (String companyName) {
        this.companyName = companyName;
    }

    public String getCommunityName () {
        return communityName;
    }

    public void setCommunityName (String communityName) {
        this.communityName = communityName;
    }

    public List<ContactDto> getContactList () {
        return contactList;
    }

    public void setContactList (List<ContactDto> contactList) {
        this.contactList = contactList;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public List<String> getFraudMeansList () {
        return fraudMeansList;
    }

    public void setFraudMeansList (List<String> fraudMeansList) {
        this.fraudMeansList = fraudMeansList;
    }

    public Integer getScore () {
        return score;
    }

    public void setScore (Integer score) {
        this.score = score;
    }

}

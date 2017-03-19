package com.henrrycheng.chyftt.intermediary.contacts.dto;

import java.io.Serializable;

/**
 * Created by chengyong on 17/3/18.
 */
public class ContactDto implements Serializable {

    private static final long serialVersionUID = -1L;

    private String contactName;

    private String contactMobile;

    public String getContactName () {
        return contactName;
    }

    public void setContactName (String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile () {
        return contactMobile;
    }

    public void setContactMobile (String contactMobile) {
        this.contactMobile = contactMobile;
    }
}

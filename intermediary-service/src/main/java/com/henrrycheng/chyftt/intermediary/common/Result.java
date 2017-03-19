package com.henrrycheng.chyftt.intermediary.common;

/**
 * Created by chengyong on 17/3/18.
 */
public class Result {

    private boolean isSuccess;

    private Object successReturnValue;

    private String errorMessage;

    public Object getResult () {
        if (isSuccess) {
            return successReturnValue;
        }
        return errorMessage;
    }

    public boolean isSuccess () {
        return isSuccess;
    }

    public void setSuccess (boolean success) {
        isSuccess = success;
    }

    public Object getSuccessReturnValue () {
        return successReturnValue;
    }

    public void setSuccessReturnValue (Object successReturnValue) {
        this.successReturnValue = successReturnValue;
    }

    public String getErrorMessage () {
        return errorMessage;
    }

    public void setErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

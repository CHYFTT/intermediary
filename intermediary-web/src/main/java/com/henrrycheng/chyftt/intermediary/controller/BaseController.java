package com.henrrycheng.chyftt.intermediary.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * base controller
 */
public class BaseController extends BaseServicesInjectController {

    protected static final Logger logger = Logger.getLogger(BaseController.class);

    /**
     * 基于@ExceptionHandler异常处理
     */
    // @ExceptionHandler
    public void exception(HttpServletRequest request, Exception ex) {
        logger.error(ex.getMessage(), ex);
    }

    protected static JsonResult successJsonResult(Object obj) {
        return new JsonResult(obj);
    }

    protected JsonResult makeUnknowErrorJsonResult() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(999);
        jsonResult.setStatusInfo("未知错误");
        return jsonResult;
    }

    protected JsonResult makeArgumentError(String statusInfo) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(1);
        if (StringUtils.isBlank(statusInfo)) {
            jsonResult.setStatusInfo("参数异常");
        } else {
            jsonResult.setStatusInfo(statusInfo);
        }
        return jsonResult;
    }
}

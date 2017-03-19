package com.henrrycheng.chyftt.intermediary.common.utils;

import org.apache.log4j.Logger;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by chengyong on 17/3/19.
 */
public class SaveAndUpdateUtils {

    private static final Logger logger = Logger.getLogger(SaveAndUpdateUtils.class);

    /**
     * 设置记录保存通用字段
     */
    public static void setCommonFieldsWhenSave(Object boObj) {

        try {

            BeanInfo beanInfo = Introspector.getBeanInfo(boObj.getClass(), Object.class);
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : properties) {
                if ("id".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, IDGeneratorUtil.generateBigIntKey());
                    continue;
                }

                /**
                 * TODO 待保存用户id
                 */
                if ("addUserId".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, -1L);
                    continue;
                }
                if ("addTime".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, new Date());
                    continue;
                }

                /**
                 * TODO 待保存用户id
                 */
                if ("updateUserId".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, -1L);
                    continue;
                }
                if ("updateTime".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, new Date());
                    continue;
                }
                if ("isDeleted".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, (byte) 0);
                    continue;
                }
            }
        } catch (Exception e) {
            logger.error("failed to set common fields when save", e);
            throw new RuntimeException("failed to set common fields when save", e);
        }
    }

    /**
     * 设置记录更新通用字段
     */
    public static void setCommonFieldsWhenUpdate(Object boObj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(boObj.getClass(), Object.class);
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();

            /**
             * TODO 待保存用户id
             */
            for (PropertyDescriptor property : properties) {
                if ("updateUserId".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, -1L);
                    continue;
                }
                if ("updateTime".equals(property.getName())) {
                    Method method = property.getWriteMethod();
                    method.invoke(boObj, new Date());
                    continue;
                }
            }
        } catch (Exception e) {
            logger.error("failed to set common fields when update entity", e);
            throw new RuntimeException("failed to set common fields when update entity", e);
        }
    }
}

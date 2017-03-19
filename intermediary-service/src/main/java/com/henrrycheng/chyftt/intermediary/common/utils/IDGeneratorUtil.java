package com.henrrycheng.chyftt.intermediary.common.utils;

import com.baidu.rigel.ipangu.common.IDGenerator;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 产生一个20位长度的主键id工具
 *
 * Created by chengyong on 17/3/19.
 */
public class IDGeneratorUtil {

    private static Logger logger = Logger.getLogger(IDGenerator.class);
    private static AtomicInteger currIndex = new AtomicInteger(0);
    private static String instanceID = "";
    private static int intInstanceID = 0;

    public IDGeneratorUtil() {
    }

    public static Long generateBigIntKey() {
        return Long.valueOf(generateBigIntStringKey());
    }

    public static String generateBigIntStringKey() {
        int tempIndex = currIndex.incrementAndGet() % 1000;
        long id = System.currentTimeMillis();
        id = (id * 1000L + (long)intInstanceID) * 1000L + (long)tempIndex;
        return String.valueOf(id);
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getInstanceID() {
        return instanceID;
    }

    public static void setInstanceID(String instanceID) {
        IDGeneratorUtil.instanceID = instanceID;
        int tempID = intInstanceID;

        try {
            tempID = Integer.parseInt(instanceID);
            intInstanceID = tempID;
        } catch (Exception var3) {
            logger.error("instance id be seted as " + instanceID, var3);
        }

        logger.info("instance id be seted as " + instanceID);
    }

    public static void main(String[] args) {
        System.out.println(generateBigIntStringKey());
    }

    static {
        intInstanceID = (new Random()).nextInt(1000);
        instanceID = "000" + String.valueOf(intInstanceID);
        instanceID = instanceID.substring(instanceID.length() - 3, instanceID.length());
        logger.info("instance id is inited with random value " + instanceID);
    }
}

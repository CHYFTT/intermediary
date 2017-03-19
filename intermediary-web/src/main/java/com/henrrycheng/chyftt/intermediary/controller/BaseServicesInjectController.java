package com.henrrycheng.chyftt.intermediary.controller;

import com.henrrycheng.chyftt.intermediary.experience.service.ExperienceService;

import javax.annotation.Resource;

/**
 * Created by zhanghu02 on 2016/9/11.
 */
public class BaseServicesInjectController {

    @Resource(name = "experienceService")
    protected ExperienceService experienceService;
}

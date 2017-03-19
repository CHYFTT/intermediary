package com.henrrycheng.chyftt.intermediary.experience;

import com.henrrycheng.chyftt.intermediary.common.Result;
import com.henrrycheng.chyftt.intermediary.controller.BaseController;
import com.henrrycheng.chyftt.intermediary.controller.JsonResult;
import com.henrrycheng.chyftt.intermediary.experience.dto.formDto.ExperienceFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/experence")
public class ExperienceController extends BaseController {

    /**
     * 新增加反馈记录
     */
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public JsonResult addExperience(ExperienceFormDto experience) {

        if (experience == null) {
            return makeArgumentError("对象为空，无法保存记录");
        }

        Result result = experienceService.saveExperienceResult(experience);
        if (result.isSuccess()) {
            return successJsonResult(result.getSuccessReturnValue());
        } else {
            return makeArgumentError(result.getErrorMessage());
        }
    }
}

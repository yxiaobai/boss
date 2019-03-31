package com.qiye.boss.controller;

import com.qiye.boss.model.Gradation;
import com.qiye.boss.service.GradationService;
import com.qiye.boss.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-31
 * 级差表
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/gradation")
public class GradationController {

    @Autowired
    private GradationService gradationService;

    /**
     * 新增/修改  级差奖
     * @param gradation
     * @return
     */
    @RequestMapping(value = "/updateGradation",method = RequestMethod.POST)
    @ResponseBody
    private ApiResult<Boolean> updateGradation(@RequestBody Gradation gradation){
        ApiResult<Boolean> result = gradationService.addGradation(gradation);
        return result;
    }

    /**
     * 获取当前商品的列表
     * @param id
     * @return
     */
    @RequestMapping(value = "/delGradationById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<Boolean> delGradationById(@PathVariable Integer id){
        ApiResult<Boolean> result = gradationService.delGradationById(id);
        return result;
    }

    /**
     * 获取全部数据
     * @return
     */
    @RequestMapping(value = "/getGradationList",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<List<Gradation>> getGradationList(){
        ApiResult<List<Gradation>> result = gradationService.getGradationList();
        return result;
    }
}

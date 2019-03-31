package com.qiye.boss.service;

import com.qiye.boss.model.Gradation;
import com.qiye.boss.utils.ApiResult;

import java.util.List;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-31
 */
public interface GradationService {

    ApiResult<Boolean> addGradation(Gradation gradation);

    ApiResult<Boolean> delGradationById(Integer id);

    ApiResult<List<Gradation>> getGradationList();
}

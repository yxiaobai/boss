package com.qiye.boss.service.impl;

import com.qiye.boss.mapper.GradationMapper;
import com.qiye.boss.model.Gradation;
import com.qiye.boss.service.GradationService;
import com.qiye.boss.utils.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-31
 */
@Service
public class GradationServiceImpl implements GradationService {
    private Logger logger = LoggerFactory.getLogger(GradationService.class);

    @Autowired
    private GradationMapper gradationMapper;

    /**
     * 新增/修改    级差数据
     * @param gradation
     * @return
     */
    @Override
    public ApiResult<Boolean> addGradation(Gradation gradation) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        try {
            if (gradation.getId()==null){
                if (gradationMapper.insertSelective(gradation)>0){
                    result.setData(Boolean.TRUE);
                }else {
                    result.setData(Boolean.FALSE);
                    result.setClientMsg("插入数据失败!");
                }
            }else {
                if (gradationMapper.updateByPrimaryKeySelective(gradation)>0){
                    result.setData(Boolean.TRUE);
                }else {
                    result.setData(Boolean.FALSE);
                    result.setClientMsg("修改数据失败!");
                }
            }
        }catch (Exception e){
            result.setData(Boolean.FALSE);
            logger.error("addGradation error...",e.getMessage());
        }
        return result;
    }

    /**
     * 删除级差奖
     * @param id
     * @return
     */
    @Override
    public ApiResult<Boolean> delGradationById(Integer id) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        try {
            if (gradationMapper.deleteByPrimaryKey(id)>0){
                result.setData(Boolean.TRUE);
            }else {
                result.setData(Boolean.FALSE);
                result.setClientMsg("删除数据失败");
            }
        }catch (Exception e){
            result.setData(Boolean.FALSE);
            logger.error("delGradation error...",e.getMessage());
        }
        return result;
    }

    @Override
    public ApiResult<List<Gradation>> getGradationList() {
        ApiResult<List<Gradation>> result = ApiResult.makeSuccessResult();
        List<Gradation> gradationList = gradationMapper.getGradationList();
        result.setData(gradationList);
        return result;
    }
}

package com.fourany.botserver.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fourany.botserver.entities.SysBotBaseConfig;
import com.fourany.botserver.mappers.SysBotBaseConfigMapper;
import com.fourany.botserver.services.impls.BaseConfigServiceImpl;
import com.fourany.common.entities.R;
import com.fourany.common.enums.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年11月26日 9:04
 */
@Controller
@RequestMapping("/bot/config")
public class BotConfigController {
    @Autowired
    private BaseConfigServiceImpl baseConfigService;

    @Autowired
    private SysBotBaseConfigMapper sysBotBaseConfigMapper;

    @PostMapping("/savePipeline")
    @ResponseBody
    public R savePipeline(@RequestBody SysBotBaseConfig config){
        SysBotBaseConfig sysBotBaseConfig = sysBotBaseConfigMapper.selectById(config.getId());
        sysBotBaseConfig.setPipeline(config.getPipeline());
        sysBotBaseConfigMapper.updateById(sysBotBaseConfig);
        Map map = new HashMap();
        return R.result(ResultInfo.DEFAULT_SUCCESS,null);
    }

    @PostMapping("/savePolicies")
    @ResponseBody
    public R savePolicies(@RequestBody SysBotBaseConfig config){
        SysBotBaseConfig sysBotBaseConfig = sysBotBaseConfigMapper.selectById(config.getId());
        sysBotBaseConfig.setPolicies(config.getPolicies());
        sysBotBaseConfigMapper.updateById(sysBotBaseConfig);
        Map map = new HashMap();
        return R.result(ResultInfo.DEFAULT_SUCCESS,null);
    }

    @PostMapping("/saveSession")
    @ResponseBody
    public R saveSession(@RequestBody SysBotBaseConfig config){
        SysBotBaseConfig sysBotBaseConfig = sysBotBaseConfigMapper.selectById(config.getId());
        sysBotBaseConfig.setSession(config.getSession());
        sysBotBaseConfigMapper.updateById(sysBotBaseConfig);
        Map map = new HashMap();
        return R.result(ResultInfo.DEFAULT_SUCCESS,null);
    }

    @GetMapping("/getSysBaseConfig")
    @ResponseBody
    public R getSysBaseConfig(@RequestParam("id") String id){
        SysBotBaseConfig sysBotBaseConfig = null;

        if(StringUtils.isEmpty(id)){
            QueryWrapper<SysBotBaseConfig> wrapper=new QueryWrapper<>();
            wrapper.orderByDesc("create_time");
            wrapper.last("limit 1");
            sysBotBaseConfig = sysBotBaseConfigMapper.selectOne(wrapper);
        }else{
            sysBotBaseConfig = sysBotBaseConfigMapper.selectById(id);
        }
        return R.result(ResultInfo.DEFAULT_SUCCESS,sysBotBaseConfig);
    }

}

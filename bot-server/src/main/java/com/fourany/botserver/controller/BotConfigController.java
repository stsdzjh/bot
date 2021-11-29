package com.fourany.botserver.controller;

import com.fourany.botserver.entities.SysBotBaseConfig;
import com.fourany.botserver.mappers.SysBotBaseConfigMapper;
import com.fourany.botserver.services.impls.BaseConfigServiceImpl;
import com.fourany.common.entities.R;
import com.fourany.common.enums.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public R savePipeline(@RequestParam("id") String id, @RequestParam("pipeline") String pipline){
        SysBotBaseConfig sysBotBaseConfig = sysBotBaseConfigMapper.selectById(id);
        sysBotBaseConfig.setPipeline(pipline);
        sysBotBaseConfigMapper.updateById(sysBotBaseConfig);
        Map map = new HashMap();
        return R.result(ResultInfo.DEFAULT_SUCCESS,null);
    }

    @GetMapping("/getSysBaseConfig")
    public R getSysBaseConfig(@RequestParam("id") String id){
        SysBotBaseConfig sysBotBaseConfig = null;
        if(StringUtils.isEmpty(id)){
            sysBotBaseConfig = sysBotBaseConfigMapper.selectOne(null);
        }else{
            sysBotBaseConfig = sysBotBaseConfigMapper.selectById(id);
        }
        return R.result(ResultInfo.DEFAULT_SUCCESS,sysBotBaseConfig);
    }

}

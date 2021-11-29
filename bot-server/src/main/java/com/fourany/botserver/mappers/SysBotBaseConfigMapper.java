package com.fourany.botserver.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fourany.botserver.entities.SysBotBaseConfig;
import org.springframework.stereotype.Component;


/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年11月28日 12:37
 */
@Component(value = "SysBotBaseConfigMapper")
public interface SysBotBaseConfigMapper extends BaseMapper<SysBotBaseConfig> {
}

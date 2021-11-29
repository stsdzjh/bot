package com.fourany.botserver.services.impls;

import com.fourany.botserver.entities.SysBotBaseConfig;
import com.fourany.botserver.mappers.SysBotBaseConfigMapper;
import com.fourany.botserver.services.BaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年11月28日 16:06
 */
@Service
public class BaseConfigServiceImpl implements BaseConfigService {
    @Autowired
    private SysBotBaseConfigMapper sysBotBaseConfigMapper;

    @Override
    public SysBotBaseConfig getBaseConfig(String id) {
        SysBotBaseConfig sysBotBaseConfig = sysBotBaseConfigMapper.selectOne(null);
        return sysBotBaseConfig;
    }
}

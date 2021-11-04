package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysFunction;
import com.fourany.botauth.mappers.SysFunctionMapper;
import com.fourany.botauth.services.SysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 15:58
 */
@Service
public class SysFunctionServiceImpl implements SysFunctionService {
    @Autowired
    private SysFunctionMapper sysFunctionMapper;

    @Override
    public SysFunction getSysFunctionById(String id) {
        return sysFunctionMapper.getSysFunctionById(id);
    }
}

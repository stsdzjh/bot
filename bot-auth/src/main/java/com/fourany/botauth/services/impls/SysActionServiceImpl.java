package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysAction;
import com.fourany.botauth.mappers.SysActionMapper;
import com.fourany.botauth.services.SysActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 17:06
 */
@Service
public class SysActionServiceImpl implements SysActionService {
    @Autowired
    private SysActionMapper sysActionMapper;

    @Override
    public SysAction getSysActionById(String id) {
        return sysActionMapper.getSysActionById(id);
    }
}

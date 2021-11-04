package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysRoleFunctionAction;
import com.fourany.botauth.mappers.SysRoleFunctionActionMapper;
import com.fourany.botauth.services.SysRoleFunctionActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 17:14
 */
@Service
public class SysRoleFunctionActionServiceImpl implements SysRoleFunctionActionService {
    @Autowired
    private SysRoleFunctionActionMapper sysRoleFunctionActionMapper;
    @Override
    public List<SysRoleFunctionAction> querySysRoleFunctionActionByRoleFunctionId(String roleFunctionId) {
        return sysRoleFunctionActionMapper.querySysRoleFunctionActionByRoleFunctionId(roleFunctionId);
    }
}

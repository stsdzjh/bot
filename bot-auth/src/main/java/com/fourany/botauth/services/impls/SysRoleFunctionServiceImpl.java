package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysRoleFunction;
import com.fourany.botauth.mappers.SysRoleFunctionMapper;
import com.fourany.botauth.services.SysRoleFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月11日 16:06
 */
@Service
public class SysRoleFunctionServiceImpl implements SysRoleFunctionService {
    @Autowired
    private SysRoleFunctionMapper sysRoleFunctionMapper;

    @Override
    public List<SysRoleFunction> getSysRoleFunctionByRoleId(String roleId) {
        return sysRoleFunctionMapper.getSysRoleFunctionByRoleId(roleId);
    }
}

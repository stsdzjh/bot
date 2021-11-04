package com.fourany.botauth.services.impls;

import com.fourany.botauth.entities.SysNav;
import com.fourany.botauth.mappers.SysNavMapper;
import com.fourany.botauth.services.SysNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年10月15日 16:57
 */
@Service
public class SysNavServiceImpl implements SysNavService {
    @Autowired
    private SysNavMapper sysNavMapper;

    @Override
    public List<SysNav> queryAll() {
        return sysNavMapper.queryAll();
    }
}

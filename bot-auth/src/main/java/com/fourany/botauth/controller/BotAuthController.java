package com.fourany.botauth.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fourany.botauth.entities.*;
import com.fourany.botauth.services.SysFunctionService;
import com.fourany.botauth.services.impls.*;

import com.fourany.common.entities.R;
import com.fourany.common.enums.ResultInfo;
import com.fourany.common.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年09月25日 23:40
 */
@RestController
@RequestMapping("/bot/auth")
public class BotAuthController {
    @Value("${auth.secretkey}")
    private String secretKey;

    @Value("${auth.tokenVarName}")
    private String tokenVarName;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    @Autowired
    private SysUserRoleServiceImpl sysUserRoleService;

    @Autowired
    private SysRoleFunctionServiceImpl sysRoleFunctionService;

    @Autowired
    private SysFunctionService sysFunctionService;

    @Autowired
    private SysRoleFunctionActionServiceImpl sysRoleFunctionActionService;

    @Autowired
    private SysActionServiceImpl sysActionService;

    @Autowired
    private SysNavServiceImpl sysNavService;

    @Autowired
    private SysRolePermissionServiceImpl sysRolePermissionService;

    @Autowired
    private SysPermissionServiceImpl sysPermissionService;



    @PostMapping("/reg")
    @ResponseBody
    public R register(@RequestBody @Valid SysUser sysUser, BindingResult bindingResult){
        List<SysUser> sysUserList = sysUserService.querySysUserByUsername(sysUser.getUsername());
        if(sysUserList.size() > 0 ){
            return R.result(ResultInfo.REG_ERROR_USERNAME_EXISTS,null);
        }
        String pwdMD5 = SecureUtil.md5(sysUser.getPassword());
        sysUser.setPassword(pwdMD5);

        sysUserService.addUser(sysUser);

        return R.result(ResultInfo.REG_SUCCESS,null);

    }

    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult){
        String userName = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        List<SysUser> sysUserList = sysUserService.querySysUserByUsername(userName);
        if(sysUserList.size()>0){
            SysUser user = sysUserList.get(0);
            //密码在客户端完成md5加密,此处只是做判断
            //if(user.getPassword().equals(SecureUtil.md5(password))){
            if(user.getPassword().equals(password)){
                JSONObject object = new JSONObject();
                String token = JWTUtils.generateToken(userName,secretKey);
                object.set("token",token);
                return R.result(ResultInfo.LOGIN_SUCCESS,object);

            }else{
                return R.result(ResultInfo.LOGIN_ERROR_USERNAME_OR_PWD_ERR,null);
            }
        }else{
            return R.result(ResultInfo.LOGIN_ERROR_USER_NOT_EXISTS,null);
        }

      //  return R.fail(ResultInfo.DEFAULT_FAIL,null);

    }

    @PostMapping("/logout")
    public R logout(){
        return R.success("注销成功了");
    }

    @GetMapping("/user/info")
    public R info(HttpServletRequest request){
        String token = request.getHeader(tokenVarName);
        String username = JWTUtils.getUserInfo(token);

        JSONObject userInfo = new JSONObject();

        SysUser sysUser = sysUserService.getSysUserByUsername(username);
        if(sysUser == null){
            return R.result(ResultInfo.USER_NOT_EXISTIS,null);
        }

        SysUserRole sysUserRole = sysUserRoleService.getSysUserRoleByUserId(sysUser.getId());
        if(sysUserRole == null){
            return R.result(ResultInfo.USER_NO_ROLE,null);
        }
        SysRole sysRole = sysRoleService.getSysRoleById(sysUserRole.getRid());
        if(sysRole == null){
            return R.result(ResultInfo.USER_ROLE_NOT_EXISTS,null);
        }

        //处理权限
        List<SysRolePermission> sysRolePermissionList = sysRolePermissionService.querySysRolePermissionByRoleId(sysRole.getId());
        JSONArray permissions = new JSONArray();
        for(SysRolePermission sysRolePermission : sysRolePermissionList){
            SysPermission sysPermission = sysPermissionService.getPermissionById(sysRolePermission.getPermissionId());
            JSONObject sysPermissionJson = new JSONObject();
            sysPermissionJson.set("roleId",sysRolePermission.getRoleId());
            sysPermissionJson.set("permissionId",sysRolePermission.getPermissionId());
            sysPermissionJson.set("permissionName",sysPermission.getName());
            permissions.add(sysPermissionJson);
        }

        JSONObject sysRoleJson = JSONUtil.parseObj(sysRole);
        sysRoleJson.set("permissions", permissions);


        userInfo = JSONUtil.parseObj(sysUser);
        userInfo.set("role", sysRoleJson);
        return R.result(ResultInfo.DEFAULT_SUCCESS,userInfo);
        /*

        if(userList.size()>0){

            SysUser sysUser = userList.get(0);
            userInfo.set("baseinfo", sysUser);

            if(sysUserRole != null){
                SysRole sysRole = sysRoleService.getSysRoleById(sysUserRole.getRid());
                List<SysRoleFunction> sysRoleFunctionList = sysRoleFunctionService.getSysRoleFunctionByRoleId(sysRole.getId());
                List<JSONObject> functionList = new ArrayList<>();

                for(SysRoleFunction sysRoleFunction : sysRoleFunctionList){
                    SysFunction sysFunction = sysFunctionService.getSysFunctionById(sysRoleFunction.getFunctionid());

                    List<SysRoleFunctionAction> sysRoleFunctionActionList = sysRoleFunctionActionService.querySysRoleFunctionActionByRoleFunctionId(sysRoleFunction.getId());

                    List<SysAction> sysActionList = new ArrayList<>();
                    for(SysRoleFunctionAction sysRoleFunctionAction : sysRoleFunctionActionList){
                        SysAction sysAction = sysActionService.getSysActionById(sysRoleFunctionAction.getActionId());
                        sysAction.setDefaultCheck(sysRoleFunctionAction.getCheck());
                        sysAction.setDefaultDisplay(sysRoleFunctionAction.getDisplay());
                        sysActionList.add(sysAction);
                    }
                    JSONObject sysFunctionJson = JSONUtil.parseObj(sysFunction);
                    sysFunctionJson.set("actions",sysActionList);
                    functionList.add(sysFunctionJson);
                }
                JSONObject sysRoleJson = JSONUtil.parseObj(sysRole);
                sysRoleJson.set("functions",functionList);
                userInfo.set("role",sysRoleJson);
                return R.result(ResultInfo.DEFAULT_SUCCESS,userInfo);

            }else{
                return R.result(ResultInfo.USER_NO_ROLE,null);
            }
        }else{
            return R.result(ResultInfo.TOKEN_SIGNATURE_INVALID,null);
        }*/

    }

    @GetMapping("/user/nav")
    public R nav(HttpServletRequest request){
        String token = request.getHeader(tokenVarName);
        String username = JWTUtils.getUserInfo(token);

        List<SysNav> sysNavList = sysNavService.queryAll();
        
        JSONArray navArray = new JSONArray();
        for(SysNav sysNav : sysNavList){
            JSONObject navObject = JSONUtil.parseObj(sysNav);
            JSONObject metaObject = new JSONObject();
            metaObject.set("title", sysNav.getTitle());
            metaObject.set("icon", sysNav.getIcon());
            metaObject.set("show", sysNav.getShow());
            metaObject.set("hiddenHeaderContent", sysNav.getHiddenHeaderContent());
            metaObject.set("hideHeader", sysNav.getHideHeader());
            metaObject.set("hideChildren", sysNav.getHideChildren());
            navObject.set("meta", metaObject);
            navArray.add(navObject);
        }

        return R.result(ResultInfo.DEFAULT_SUCCESS,navArray);
    }
}

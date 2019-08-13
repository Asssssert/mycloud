package com.iilei.authority.config;

import com.google.common.collect.Lists;
import com.iilei.authority.entity.Account;
import com.iilei.authority.entity.*;
import com.iilei.authority.service.*;
import com.iilei.authority.utils.JWTUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IAccount_roleService account_roleService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IRole_permissionsService role_permissionsService;
    @Autowired
    private IPermissionsService permissionsService;
    @Autowired
    private RedisService redisService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限");
        String token = (String) principalCollection.getPrimaryPrincipal();
        String username = JWTUtil.getUsername(token);
        Account account = accountService.findByUsername(username);
        List<String> roles = Lists.newArrayList();
        List<String> permissions = Lists.newArrayList();
        if (account != null) {
            return initRolePermission(account, roles, permissions);
        }
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录");
        String token = (String) authenticationToken.getCredentials();
        if (token == null) {
            throw new AccountException("token不能为空");
        }
        String username = JWTUtil.getUsername(token);
        if (!redisService.hasKey(username)) {
            throw new AccountException("token无效,请重新登录");
        }
        String checkToken = (String) redisService.get(username);
        if (!token.equals(checkToken)) {
            throw new AccountException("登录失效");
        }
        //刷新时间
        redisService.expire(username, 24 * 60 * 60 * 1000);//一天
        return new SimpleAuthenticationInfo(token, token, getName());
    }

    //装配角色和权限
    private AuthorizationInfo initRolePermission(Account account, List<String> roles, List<String> permissions) {
        List<Account_role> ars = account_roleService.findListByAid(account.getId());
        ars.forEach(account_role -> {
            Role role = roleService.findById(account_role.getRid());
            roles.add(role.getName());
            List<Role_permissions> rps = role_permissionsService.findListByRid(role.getId());
            rps.forEach(role_permissions -> {
                Permissions p = permissionsService.findById(role_permissions.getPid());
                if (p.getParentId() != 0) {
                    permissions.add(p.getResource());
                }
            });
        });
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }
}

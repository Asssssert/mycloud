package com.iilei.authority.config;

import com.google.common.collect.Lists;
import com.iilei.authority.entity.Account;
import com.iilei.authority.entity.*;
import com.iilei.authority.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.iilei.authority.utils.Constant.ACCOUNT_LOCK;

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

    @Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
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
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        Account login = accountService.login(username, password);
        if (login == null) {
            throw new AccountException("用户名或密码不正确");
        }
        if (login.getLock() == ACCOUNT_LOCK) {
            throw new LockedAccountException("该用户已被锁定");
        }
        return new SimpleAuthenticationInfo(username, password, getName());
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

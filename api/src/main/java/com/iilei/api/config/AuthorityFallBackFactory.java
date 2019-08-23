package com.iilei.api.config;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.account.AccountDto;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.api.service.AuthorityService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorityFallBackFactory implements FallbackFactory<AuthorityService> {
    @Override
    public AuthorityService create(Throwable throwable) {
        return new AuthorityService() {


            @Override
            public AccountDto accountFindByUsername(String username) {
                return null;
            }

            @Override
            public boolean accountAdd(AccountAdd params) {
                return false;
            }

            @Override
            public boolean accountDel(Integer[] ids) {
                return false;
            }

            @Override
            public boolean accountUpd(AccountUpd params) {
                return false;
            }

            @Override
            public AccountDto accountFindById(Integer id) {
                return null;
            }

            @Override
            public Page<AccountDto> accountListByPage(Integer page, Integer size) {
                return null;
            }

            @Override
            public boolean accountLock(Integer[] ids, Integer lock) {
                return false;
            }

            @Override
            public PermissionsDto permissionFindById(Integer id) {
                return null;
            }

            @Override
            public boolean permissionAdd(PermissionAdd params) {
                return false;
            }

            @Override
            public boolean permissionDel(Integer[] ids) {
                return false;
            }

            @Override
            public boolean permissionUpd(PermissionUpd params) {
                return false;
            }

            @Override
            public Page<PermissionsDto> permissionListByPage(Integer page, Integer size) {
                return null;
            }

            @Override
            public Page<PermissionsDto> permissionListByType(Integer type, Integer page, Integer size) {
                return null;
            }

            @Override
            public Page<PermissionsDto> permissionListByPid(Integer pid, Integer page, Integer size) {
                return null;
            }

            @Override
            public List<PermissionsDto> permissionListAll() {
                return null;
            }

            @Override
            public List<PermissionsDto> permissionListAllByRid(Integer rid) {
                return null;
            }

            @Override
            public RoleDto roleFindById(Integer id) {
                return null;
            }

            @Override
            public boolean roleAdd(RoleAdd params) {
                return false;
            }

            @Override
            public boolean roleDel(Integer[] ids) {
                return false;
            }

            @Override
            public boolean roleUpd(RoleUpd params) {
                return false;
            }

            @Override
            public Page<RoleDto> roleListByPage(Integer page, Integer size) {
                return null;
            }

            @Override
            public List<RoleDto> roleListAll() {
                return null;
            }

            @Override
            public List<RoleDto> roleListAllByAid(Integer aid) {
                return null;
            }
        };
    }
}

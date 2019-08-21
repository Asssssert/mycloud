package com.iilei.api.config;

import com.iilei.api.entity.Account;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.api.service.AuthorityService;
import com.iilei.api.vo.ResponseData;
import org.springframework.stereotype.Component;

//@Component
public class SchedualAuthorityServiceHystric implements AuthorityService {
    @Override
    public Account accountFindByUsername(String username) {
        Account account = new Account();
        account.setAccount("123123");
        return account;
    }

    @Override
    public ResponseData accountAdd(AccountAdd params) {
        return null;
    }

    @Override
    public ResponseData accountDel(Integer[] ids) {
        return null;
    }

    @Override
    public ResponseData accountUpd(AccountUpd params) {
        return null;
    }

    @Override
    public ResponseData accountFindById(Integer id) {
        return null;
    }

    @Override
    public ResponseData accountListByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseData accountLock(Integer[] ids, Integer lock) {
        return null;
    }

    @Override
    public ResponseData permissionFindById(Integer id) {
        return null;
    }

    @Override
    public ResponseData permissionAdd(PermissionAdd params) {
        return null;
    }

    @Override
    public ResponseData permissionDel(Integer[] ids) {
        return null;
    }

    @Override
    public ResponseData permissionUpd(PermissionUpd params) {
        return null;
    }

    @Override
    public ResponseData permissionListByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseData permissionListByType(Integer type, Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseData permissionListByPid(Integer pid, Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseData permissionListAll() {
        return null;
    }

    @Override
    public ResponseData permissionListAllByRid(Integer rid) {
        return null;
    }

    @Override
    public ResponseData roleFindById(Integer id) {
        return null;
    }

    @Override
    public ResponseData roleAdd(RoleAdd params) {
        return null;
    }

    @Override
    public ResponseData roleDel(Integer[] ids) {
        return null;
    }

    @Override
    public ResponseData roleUpd(RoleUpd params) {
        return null;
    }

    @Override
    public ResponseData roleListByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseData roleListAll() {
        return null;
    }

    @Override
    public ResponseData roleListAllByAid(Integer aid) {
        return null;
    }
}

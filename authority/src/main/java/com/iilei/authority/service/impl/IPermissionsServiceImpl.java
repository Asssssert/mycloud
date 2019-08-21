package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Permissions;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.authority.service.IPermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPermissionsServiceImpl implements IPermissionsService {
    @Override
    public Permissions findById(Integer id) {
        return null;
    }

    @Override
    public void add(PermissionAdd params) {

    }

    @Override
    public void del(Integer[] ids) {

    }

    @Override
    public void upd(PermissionUpd params) {

    }

    @Override
    public Page<Permissions> listByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<Permissions> listByType(Integer type, Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<Permissions> listByPid(Integer pid, Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Permissions> listAll() {
        return null;
    }

    @Override
    public List<Permissions> listAllByRid(Integer rid) {
        return null;
    }
}

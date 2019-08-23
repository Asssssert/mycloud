package com.iilei.gateway.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.gateway.service.IPermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPermissionsServiceImpl implements IPermissionsService {
    @Override
    public PermissionsDto findById(Integer id) {
        return null;
    }

    @Override
    public boolean add(PermissionAdd params) {
        return false;
    }

    @Override
    public boolean del(Integer[] ids) {
        return false;
    }

    @Override
    public boolean upd(PermissionUpd params) {
        return false;
    }

    @Override
    public Page<PermissionsDto> listByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<PermissionsDto> listByType(Integer type, Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<PermissionsDto> listByPid(Integer pid, Integer page, Integer size) {
        return null;
    }

    @Override
    public List<PermissionsDto> listAll() {
        return null;
    }

    @Override
    public List<PermissionsDto> listAllByRid(Integer rid) {
        return null;
    }
}

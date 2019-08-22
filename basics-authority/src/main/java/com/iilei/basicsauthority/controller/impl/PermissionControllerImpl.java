package com.iilei.basicsauthority.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.basicsauthority.controller.PermissionController;
import com.iilei.basicsauthority.service.IPermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class PermissionControllerImpl implements PermissionController {
    @Autowired
    private IPermissionsService permissionsService;

    @Override
    public PermissionsDto findById(Integer id) {
        return permissionsService.findById(id);
    }

    @Override
    public boolean add(PermissionAdd params) {
        try {
            permissionsService.add(params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean del(Integer[] ids) {
        try {
            permissionsService.del(ids);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean upd(PermissionUpd params) {
        try {
            permissionsService.upd(params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Page<PermissionsDto> listByPage(Integer page, Integer size) {
        return permissionsService.listByPage(page, size);
    }

    @Override
    public Page<PermissionsDto> listByType(Integer type, Integer page, Integer size) {
        return permissionsService.listByType(type, page, size);
    }

    @Override
    public Page<PermissionsDto> listByPid(Integer pid, Integer page, Integer size) {
        return permissionsService.listByPid(pid, page, size);
    }

    @Override
    public List<PermissionsDto> listAll() {
        return permissionsService.listAll();
    }

    @Override
    public List<PermissionsDto> listAllByRid(Integer rid) {
        return permissionsService.listAllByRid(rid);
    }
}

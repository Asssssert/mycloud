package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.PermissionController;
import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.dto.permission.PermissionGetDto;
import com.iilei.authority.params.permission.PermissionAdd;
import com.iilei.authority.params.permission.PermissionUpd;
import com.iilei.authority.service.IPermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class PermissionControllerImpl implements PermissionController {
    @Autowired
    private IPermissionsService permissionsService;

    @Override
    public ResponseData add(PermissionAdd params) {
        try {
            permissionsService.add(params);
        } catch (Exception e) {
            return ResponseData.fail(40001, e.getMessage());
        }
        return ResponseData.success("添加成功");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        try {
            permissionsService.del(ids);
        } catch (Exception e) {
            return ResponseData.fail(40002, e.getMessage());
        }
        return ResponseData.success("删除成功");
    }

    @Override
    public ResponseData upd(PermissionUpd params) {
        try {
            permissionsService.upd(params);
        } catch (Exception e) {
            return ResponseData.fail(40003, e.getMessage());
        }
        return ResponseData.success("修改成功");
    }

    @Override
    public ResponseData getById(Integer id) {
        PermissionGetDto dto = null;
        try {
            dto = permissionsService.getById(id);
        } catch (Exception e) {
            return ResponseData.fail(40004, e.getMessage());
        }
        return ResponseData.success(dto);
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        return ResponseData.success(permissionsService.listByPage(page, size));
    }

    @Override
    public ResponseData listByPageByType(Integer type, Integer page, Integer size) {
        return ResponseData.success(permissionsService.listByType(type, page, size));
    }

    @Override
    public ResponseData listByPid(Integer pid, Integer page, Integer size) {
        return ResponseData.success(permissionsService.listByPid(pid, page, size));
    }
}

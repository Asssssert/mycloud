package com.iilei.basicsauthority.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.vo.ResponseData;
import com.iilei.basicsauthority.controller.PermissionController;
import com.iilei.basicsauthority.entity.Permissions;
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
    private Permissions permissions;
    private Page<Permissions> list;
    private List<Permissions> all;

    @Override
    public ResponseData findById(Integer id) {
        try {
            permissions = permissionsService.findById(id);
        } catch (Exception e) {
            return ResponseData.fail(20000, e.getMessage());
        }
        return ResponseData.success(permissions);
    }

    @Override
    public ResponseData add(PermissionAdd params) {
        try {
            permissionsService.add(params);
        } catch (Exception e) {
            return ResponseData.fail(20001, e.getMessage());
        }
        return ResponseData.success("添加成功");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        try {
            permissionsService.del(ids);
        } catch (Exception e) {
            return ResponseData.fail(20002, e.getMessage());
        }
        return ResponseData.success("删除成功");
    }

    @Override
    public ResponseData upd(PermissionUpd params) {
        try {
            permissionsService.upd(params);
        } catch (Exception e) {
            return ResponseData.fail(10003, e.getMessage());
        }
        return ResponseData.success("修改成功");
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        try {
            list = permissionsService.listByPage(page, size);
        } catch (Exception e) {
            return ResponseData.fail(10004, e.getMessage());
        }
        return ResponseData.success(list);
    }

    @Override
    public ResponseData listByType(Integer type, Integer page, Integer size) {
        try {
            list = permissionsService.listByType(type, page, size);
        } catch (Exception e) {
            return ResponseData.fail(10005, e.getMessage());
        }
        return ResponseData.success(list);
    }

    @Override
    public ResponseData listByPid(Integer pid, Integer page, Integer size) {
        try {
            list = permissionsService.listByPid(pid, page, size);
        } catch (Exception e) {
            return ResponseData.fail(10006, e.getMessage());
        }
        return ResponseData.success(list);
    }

    @Override
    public ResponseData listAll() {
        try {
            all = permissionsService.listAll();
        } catch (Exception e) {
            return ResponseData.fail(10007, e.getMessage());
        }
        return ResponseData.success(all);
    }

    @Override
    public ResponseData listAllByRid(Integer rid) {
        try {
            all = permissionsService.listAllByRid(rid);
        } catch (Exception e) {
            return ResponseData.fail(10008, e.getMessage());
        }
        return ResponseData.success(all);
    }
}

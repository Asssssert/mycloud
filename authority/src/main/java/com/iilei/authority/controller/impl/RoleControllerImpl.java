package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.RoleController;
import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.dto.role.RoleGetDto;
import com.iilei.authority.params.role.RoleAdd;
import com.iilei.authority.params.role.RoleUpd;
import com.iilei.authority.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class RoleControllerImpl implements RoleController {
    @Autowired
    private IRoleService roleService;

    @Override
    public ResponseData add(RoleAdd params) {
        try {
            roleService.add(params);
        } catch (Exception e) {
            return ResponseData.fail(30001, e.getMessage());
        }
        return ResponseData.success("添加成功");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        try {
            roleService.del(ids);
        } catch (Exception e) {
            return ResponseData.fail(30002, e.getMessage());
        }
        return ResponseData.success("删除成功");
    }

    @Override
    public ResponseData upd(RoleUpd params) {
        try {
            roleService.upd(params);
        } catch (Exception e) {
            return ResponseData.fail(30003, e.getMessage());
        }
        return ResponseData.success("修改成功");
    }

    @Override
    public ResponseData getById(Integer id) {
        RoleGetDto dto = null;
        try {
            dto = roleService.getById(id);
        } catch (Exception e) {
            return ResponseData.fail(30004, e.getMessage());
        }
        return ResponseData.success(dto);
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        return ResponseData.success(roleService.listByPage(page, size));
    }
}

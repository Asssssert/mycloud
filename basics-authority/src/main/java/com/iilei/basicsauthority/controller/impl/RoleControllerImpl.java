package com.iilei.basicsauthority.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.basicsauthority.controller.RoleController;
import com.iilei.basicsauthority.entity.Role;
import com.iilei.basicsauthority.params.role.RoleAdd;
import com.iilei.basicsauthority.params.role.RoleUpd;
import com.iilei.basicsauthority.service.IRoleService;
import com.iilei.basicsauthority.vo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class RoleControllerImpl implements RoleController {
    @Autowired
    private IRoleService roleService;
    private Role role;
    private Page<Role> list;
    private List<Role> all;

    @Override
    public ResponseData findById(Integer id) {
        try {
            role = roleService.findById(id);
        } catch (Exception e) {
            return ResponseData.fail(30000, e.getMessage());
        }
        return ResponseData.success(role);
    }

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
    public ResponseData listByPage(Integer page, Integer size) {
        try {
            list = roleService.listByPage(page, size);
        } catch (Exception e) {
            return ResponseData.fail(30004, e.getMessage());
        }
        return ResponseData.success(list);
    }

    @Override
    public ResponseData listAll() {
        try {
            all = roleService.listAll();
        } catch (Exception e) {
            return ResponseData.fail(30005, e.getMessage());
        }
        return ResponseData.success(all);
    }

    @Override
    public ResponseData listAllByAid(Integer aid) {
        try {
            all = roleService.listAllByAid(aid);
        } catch (Exception e) {
            return ResponseData.fail(30006, e.getMessage());
        }
        return ResponseData.success(all);
    }
}

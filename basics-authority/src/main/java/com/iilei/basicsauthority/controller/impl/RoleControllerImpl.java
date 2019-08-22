package com.iilei.basicsauthority.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.basicsauthority.controller.RoleController;
import com.iilei.basicsauthority.service.IRoleService;
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

    @Override
    public RoleDto findById(Integer id) {
        return roleService.findById(id);
    }

    @Override
    public boolean add(RoleAdd params) {
        try {
            roleService.add(params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean del(Integer[] ids) {
        try {
            roleService.del(ids);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean upd(RoleUpd params) {
        try {
            roleService.upd(params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Page<RoleDto> listByPage(Integer page, Integer size) {
        return roleService.listByPage(page, size);
    }

    @Override
    public List<RoleDto> listAll() {
        return roleService.listAll();
    }

    @Override
    public List<RoleDto> listAllByAid(Integer aid) {
        return roleService.listAllByAid(aid);
    }
}

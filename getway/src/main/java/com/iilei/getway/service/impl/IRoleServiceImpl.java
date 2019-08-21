package com.iilei.getway.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Role;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.getway.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleServiceImpl implements IRoleService {
    @Override
    public Role findById(Integer id) {
        return null;
    }

    @Override
    public void add(RoleAdd params) {

    }

    @Override
    public void del(Integer[] ids) {

    }

    @Override
    public void upd(RoleUpd params) {

    }

    @Override
    public Page<Role> listByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Role> listAll() {
        return null;
    }

    @Override
    public List<Role> listAllByAid(Integer aid) {
        return null;
    }
}

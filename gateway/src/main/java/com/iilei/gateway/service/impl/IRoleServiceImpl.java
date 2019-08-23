package com.iilei.gateway.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.gateway.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleServiceImpl implements IRoleService {
    @Override
    public RoleDto findById(Integer id) {
        return null;
    }

    @Override
    public boolean add(RoleAdd params) {
        return false;
    }

    @Override
    public boolean del(Integer[] ids) {
        return false;
    }

    @Override
    public boolean upd(RoleUpd params) {
        return false;
    }

    @Override
    public Page<RoleDto> listByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public List<RoleDto> listAll() {
        return null;
    }

    @Override
    public List<RoleDto> listAllByAid(Integer aid) {
        return null;
    }
}

package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.basicsauthority.entity.Role;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IRoleService extends IService<Role> {
    RoleDto findById(Integer id);

    void add(RoleAdd params);

    void del(Integer[] ids);

    void upd(RoleUpd params);

    Page<RoleDto> listByPage(Integer page, Integer size);

    List<RoleDto> listAll();

    List<RoleDto> listAllByAid(Integer aid);
}

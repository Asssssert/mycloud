package com.iilei.authority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.dto.role.RoleGetDto;
import com.iilei.authority.dto.role.RoleListDto;
import com.iilei.authority.entity.Role;
import com.iilei.authority.params.role.RoleAdd;
import com.iilei.authority.params.role.RoleUpd;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IRoleService extends IService<Role> {
    Role findById(Integer id);

    void add(RoleAdd params);

    void del(Integer[] ids);

    void upd(RoleUpd params);

    RoleGetDto getById(Integer id);

    Page<RoleListDto> listByPage(Integer page, Integer size);
}

package com.iilei.gateway.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IRoleService {
    RoleDto findById(Integer id);

    boolean add(RoleAdd params);

    boolean del(Integer[] ids);

    boolean upd(RoleUpd params);

    Page<RoleDto> listByPage(Integer page, Integer size);

    List<RoleDto> listAll();

    List<RoleDto> listAllByAid(Integer aid);
}

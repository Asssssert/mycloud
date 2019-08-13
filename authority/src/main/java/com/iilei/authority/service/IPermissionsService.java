package com.iilei.authority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.dto.permission.PermissionGetDto;
import com.iilei.authority.dto.permission.PermissionListDto;
import com.iilei.authority.entity.Permissions;
import com.iilei.authority.params.permission.PermissionAdd;
import com.iilei.authority.params.permission.PermissionUpd;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IPermissionsService extends IService<Permissions> {
    Permissions findById(Integer id);

    void add(PermissionAdd params);

    void del(Integer[] ids);

    void upd(PermissionUpd params);

    PermissionGetDto getById(Integer id);

    Page<PermissionListDto> listByPage(Integer page, Integer size);

    Page<PermissionListDto> listByType(Integer type, Integer page, Integer size);

    Page<PermissionListDto> listByPid(Integer pid, Integer page, Integer size);
}

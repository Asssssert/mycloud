package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.basicsauthority.entity.Permissions;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IPermissionsService extends IService<Permissions> {
    PermissionsDto findById(Integer id);

    void add(PermissionAdd params);

    Boolean del(Integer[] ids);

    Boolean upd(PermissionUpd params);

    Page<PermissionsDto> listByPage(Integer page, Integer size);

    Page<PermissionsDto> listByType(Integer type, Integer page, Integer size);

    Page<PermissionsDto> listByPid(Integer pid, Integer page, Integer size);

    List<PermissionsDto> listAll();

    List<PermissionsDto> listAllByRid(Integer rid);
}

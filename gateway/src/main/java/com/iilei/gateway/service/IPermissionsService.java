package com.iilei.gateway.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IPermissionsService {
    PermissionsDto findById(Integer id);

    boolean add(PermissionAdd params);

    boolean del(Integer[] ids);

    boolean upd(PermissionUpd params);

    Page<PermissionsDto> listByPage(Integer page, Integer size);

    Page<PermissionsDto> listByType(Integer type, Integer page, Integer size);

    Page<PermissionsDto> listByPid(Integer pid, Integer page, Integer size);

    List<PermissionsDto> listAll();

    List<PermissionsDto> listAllByRid(Integer rid);
}

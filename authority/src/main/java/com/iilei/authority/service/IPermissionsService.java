package com.iilei.authority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Permissions;
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
    Permissions findById(Integer id);

    void add(PermissionAdd params);

    void del(Integer[] ids);

    void upd(PermissionUpd params);

    Page<Permissions> listByPage(Integer page, Integer size);

    Page<Permissions> listByType(Integer type, Integer page, Integer size);

    Page<Permissions> listByPid(Integer pid, Integer page, Integer size);

    List<Permissions> listAll();

    List<Permissions> listAllByRid(Integer rid);
}

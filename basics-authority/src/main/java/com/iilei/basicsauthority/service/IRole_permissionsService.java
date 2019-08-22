package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.api.dto.rolepermission.RolePermissionsDto;
import com.iilei.api.params.role.RoleAddPermission;
import com.iilei.basicsauthority.entity.Role_permissions;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IRole_permissionsService extends IService<Role_permissions> {
    List<RolePermissionsDto> findListByRid(Integer rid);

    void addPermission(RoleAddPermission params);

    void delPermissionByRid(Integer rid, Integer[] pids);
}

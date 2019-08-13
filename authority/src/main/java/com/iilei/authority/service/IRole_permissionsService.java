package com.iilei.authority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.entity.Role_permissions;
import com.iilei.authority.params.role.RoleAddPermission;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IRole_permissionsService extends IService<Role_permissions> {
    List<Role_permissions> findListByRid(Integer rid);

    void addPermission(RoleAddPermission params);

    void delPermissionByRid(Integer rid, Integer[] pids);
}

package com.iilei.authority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.entity.Role_permissions;

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
}
